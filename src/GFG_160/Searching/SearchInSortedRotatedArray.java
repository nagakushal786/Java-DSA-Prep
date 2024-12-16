package GFG_160.Searching;

public class SearchInSortedRotatedArray {
    public static int findPivot(int[] arr, int low, int high){
        while(low<high){
            if(arr[low]<arr[high]){
                return low;
            }

            int mid=low+(high-low)/2;

            if(arr[mid]>arr[high]){
                low=mid+1;
            }else{
                high=mid;
            }
        }

        return low;
    }

    public static int binarySearch(int[] arr, int low, int high, int key){
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }

    public static int searchBetter(int[] arr, int key){
        int n=arr.length;

        int pivot=findPivot(arr, 0, n-1);

        if(arr[pivot]==key){
            return pivot;
        }

        if(arr[0]<key){
            return binarySearch(arr, 0, pivot-1, key);
        }

        return binarySearch(arr, pivot, n-1, key);
    }

    public static int searchOptimal(int[] arr, int key){
        int n=arr.length;
        int low=0, high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==key){
                return mid;
            }

            if(arr[mid]>=arr[low]){
                if(key>=arr[low] && key<arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(key>arr[mid] && key<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]){
        int arr[]={4, 5, 6, 7, 0, 1, 2, 3};
        int key=6;

        int idxBetter=searchBetter(arr, key);
        System.out.println(idxBetter);

        int idxOptimal=searchOptimal(arr, key);
        System.out.println(idxOptimal);
    }
}

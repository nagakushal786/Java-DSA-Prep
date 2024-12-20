package GFG_160.Searching;

public class SearchInRotatedSortedArray {
    public static int searchBrute(int[] arr, int key){
        int idx=-1;
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==key){
                idx=i;
                break;
            }
        }

        return idx;
    }

    public static int findPivot(int[] arr, int low, int high){
        while(low<high){
            if(arr[low]<=arr[high]){
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

        if(pivot==0){
            return binarySearch(arr, 0, n-1, key);
        }

        if(arr[0]<=key){
            return binarySearch(arr, 0, pivot-1, key);
        }

        return binarySearch(arr, pivot, n-1, key);
    }

    public static int searchOptimal(int[] arr, int key){
        int n=arr.length;
        int low=0, high=n-1;
        int idx=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==key){
                idx=mid;
            }

            if(arr[low]<=arr[mid]){
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

        return idx;
    }

    public static void main(String args[]){
        int arr[]={5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key=3;

        int idx1=searchBrute(arr, key);
        System.out.println(idx1);

        int idx2=searchBetter(arr, key);
        System.out.println(idx2);

        int idx3=searchOptimal(arr, key);
        System.out.println(idx3);
    }
}

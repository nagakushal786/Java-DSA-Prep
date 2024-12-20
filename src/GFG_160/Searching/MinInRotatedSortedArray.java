package GFG_160.Searching;

public class MinInRotatedSortedArray {
    public static int minBrute(int[] arr){
        int min=arr[0];
        int n=arr.length;

        for(int i=1;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }

        return min;
    }

    public static int minOptimal(int[] arr){
        int n=arr.length;

        int low=0, high=n-1;
        while(low<high){
            if(arr[low]<=arr[high]){
                return arr[low];
            }

            int mid=low+(high-low)/2;

            if(arr[mid]>arr[high]){
                low=mid+1;
            }else{
                high=mid;
            }
        }

        return arr[low];
    }

    public static void main(String args[]){
        int arr[]={5, 6, 7, 8, 0, 1, 2};

        int min1=minBrute(arr);
        System.out.println(min1);

        int min2=minOptimal(arr);
        System.out.println(min2);
    }
}

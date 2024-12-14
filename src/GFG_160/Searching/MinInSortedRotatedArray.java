package GFG_160.Searching;

public class MinInSortedRotatedArray {
    public static int minEleInSortedRotatedArrayBrute(int[] arr){
        int n=arr.length;

        int min=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }

        return min;
    }

    public static int minEleInSortedRotatedArrayOptimal(int[] arr){
        int n=arr.length;

        int low=0, high=n-1;
        while(low<high){
            if(arr[low]<arr[high]){
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
        int arr[]={5, 6, 1, 2, 3, 4};

        int minEle=minEleInSortedRotatedArrayBrute(arr);
        System.out.println(minEle);

        int minEleOpt=minEleInSortedRotatedArrayOptimal(arr);
        System.out.println(minEleOpt);
    }
}

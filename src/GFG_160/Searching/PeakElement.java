package GFG_160.Searching;

public class PeakElement {
    public static int peakElementBrute(int[] arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            boolean left=true;
            boolean right=true;

            if(i>0 && arr[i]<=arr[i-1]){
                left=false;
            }

            if(i<n-1 && arr[i]<=arr[i+1]){
                right=false;
            }

            if(left==true && right==true){
                return i;
            }
        }

        return -1;
    }

    public static int peakElementOptimal(int[] arr){
        int n=arr.length;

        if(n==1){
            return 0;
        }

        if(arr[0]>arr[1]){
            return 0;
        }

        if(arr[n-1]>arr[n-2]){
            return n-1;
        }

        int low=1, high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }

            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        int arr[]={1, 2, 7, 4, 5, 4};

        int idx1=peakElementBrute(arr);
        System.out.println(idx1);

        int idx2=peakElementOptimal(arr);
        System.out.println(idx2);
    }
}

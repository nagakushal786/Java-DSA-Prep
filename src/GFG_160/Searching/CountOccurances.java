package GFG_160.Searching;

public class CountOccurances {
    public static int countOccurancesBrute(int[] arr, int target){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]==target){
                count+=1;
            }
        }

        return count;
    }

    public static int lowerBound(int[] arr, int target){
        int n=arr.length;
        int low=0, high=n-1;

        int lowB=n;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=target){
                lowB=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return lowB;
    }

    public static int upperBound(int[] arr, int target){
        int n=arr.length;
        int low=0, high=n-1;

        int upB=n;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>target){
                upB=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return upB;
    }

    public static int countOccurancesOptimal(int[] arr, int target){
        return upperBound(arr, target)-lowerBound(arr, target);
    }

    public static void main(String args[]){
        int arr[]={1, 2, 2, 2, 2, 3};
        int target=4;

        int count1=countOccurancesBrute(arr, target);
        System.out.println(count1);

        int count2=countOccurancesOptimal(arr, target);
        System.out.println(count2);
    }
}

package GFG_160.Searching;

public class CountOccurances {
    public static int countOccurancesBrute(int[] arr, int target){
        int count=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==target){
                count+=1;
            }
        }

        return count;
    }

    public static int lowerBound(int[] arr, int target){
        int lowerRes=arr.length;
        int n=arr.length;

        int low=0, high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                lowerRes=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return lowerRes;
    }

    public static int upperBound(int[] arr, int target){
        int upperRes=arr.length;
        int n=arr.length;

        int low=0, high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                upperRes=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return upperRes;
    }

    public static int countOccurancesOptimal(int[] arr, int target){
        int upper_bound=upperBound(arr, target);
        int lower_bound=lowerBound(arr, target);

        return upper_bound-lower_bound;
    }

    public static void main(String args[]){
        int arr[]={1, 2, 2, 2, 2, 3, 4};
        int target=2;

        int count1=countOccurancesBrute(arr, target);
        System.out.println(count1);

        int count2=countOccurancesOptimal(arr, target);
        System.out.println(count2);
    }
}

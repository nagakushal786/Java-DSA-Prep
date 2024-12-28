package GFG_160.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static boolean twoSumBrute(int[] arr, int target){
        int n=arr.length;
        boolean sumCheck=false;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    sumCheck=true;
                    break;
                }
            }
        }

        return sumCheck;
    }

    public static boolean binarySearch(int[] arr, int low, int high, int target){
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return false;
    }

    public static boolean twoSumBetter1(int[] arr, int target){
        int n=arr.length;
        boolean sumCheck=false;

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int compliment=target-arr[i];

            if(binarySearch(arr, i+1, n-1, compliment)){
                sumCheck=true;
                break;
            }
        }

        return sumCheck;
    }

    public static boolean twoSumBetter2(int[] arr, int target){
        int n=arr.length;
        boolean sumCheck=false;

        Arrays.sort(arr);

        int low=0, high=n-1;
        while(low<=high){
            int sum=arr[low]+arr[high];

            if(sum==target){
                sumCheck=true;
                break;
            }else if(sum<target){
                low+=1;
            }else{
                high-=1;
            }
        }

        return sumCheck;
    }

    public static boolean twoSumOptimal(int[] arr, int target){
        boolean sumCheck=false;

        HashSet<Integer> set=new HashSet<>();
        for(int num: arr){
            int compliment=target-num;

            if(set.contains(compliment)){
                sumCheck=true;
                break;
            }

            set.add(num);
        }

        return sumCheck;
    }

    public static void main(String args[]){
        int arr[]={1, 4, 45, 6, 10, 8};
        int target=16;

        boolean check1=twoSumBrute(arr, target);
        System.out.println(check1);

        boolean check2=twoSumBetter1(arr, target);
        System.out.println(check2);

        boolean check3=twoSumBetter2(arr, target);
        System.out.println(check3);

        boolean check4=twoSumOptimal(arr, target);
        System.out.println(check4);
    }
}

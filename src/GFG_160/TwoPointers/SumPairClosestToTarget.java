package GFG_160.TwoPointers;

import java.util.*;

public class SumPairClosestToTarget {
    public static List<Integer> sumPairClosestToKOptimal(int[] arr, int target){
        int n=arr.length;
        int low=0, high=n-1;
        int minDiff=Integer.MAX_VALUE;
        List<Integer> res=new ArrayList<>();

        Arrays.sort(arr);

        while(low<high){
            int sum=arr[low]+arr[high];

            if(Math.abs(target-sum)<minDiff){
                minDiff=Math.abs(target-sum);
                res=Arrays.asList(arr[low], arr[high]);
            }

            if(sum<target){
                low+=1;
            }else if(sum>target){
                high-=1;
            }else{
                return res;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={5, 2, 7, 1, 4};
        int target=10;

        List<Integer> res=new ArrayList<>();
        res=sumPairClosestToKOptimal(arr, target);
        System.out.println(res);
    }
}

package GFG_160.TwoPointers;

import java.util.*;

public class IndicesOfSubArraySum {
    public static ArrayList<Integer> rangeOfSubArraySum(int[] arr, int target){
        int n=arr.length;

        ArrayList<Integer> ans=new ArrayList<>();
        int l=0, sum=0;
        for(int r=0;r<n;r++){
            sum+=arr[r];

            while(sum>target){
                sum-=arr[l];
                l+=1;
            }

            if(sum==target){
                ans.add(l+1);
                ans.add(r+1);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }

    public static void main(String[] args){
        int arr[]={1, 2, 3, 7, 5};
        int target=12;

        ArrayList<Integer> res=new ArrayList<>();
        res=rangeOfSubArraySum(arr, target);
        System.out.println(res);
    }
}

package GFG_160.Hashing;

import java.util.HashMap;

public class SubArraysWithSumK {
    public static int subArraysSumKBrute(int[] arr, int k){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k){
                    count+=1;
                }
            }
        }

        return count;
    }

    public static int subArraysSumKOptimal(int[] arr, int k){
        HashMap<Integer, Integer> map=new HashMap<>();
        int res=0, currSum=0;

        for(int val: arr){
            currSum+=val;

            if(currSum==k){
                res+=1;
            }

            if(map.containsKey(currSum-k)){
                res+=map.get(currSum-k);
            }

            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={10, 2, -2, -20, 10};
        int k=-10;

        int count1=subArraysSumKBrute(arr, k);
        System.out.println(count1);

        int count2=subArraysSumKOptimal(arr, k);
        System.out.println(count2);
    }
}
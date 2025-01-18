package GFG_160.PrefixSum;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static int lengthOfLongestSubarray(int[] arr, int k){
        int n=arr.length;
        int res=0, prefSum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            prefSum+=arr[i];
            
            if(prefSum==k){
                res=i+1;
            }else if(map.containsKey(prefSum-k)){
                res=Math.max(res, i-map.get(prefSum-k));
            }
            
            if(!map.containsKey(prefSum)){
                map.put(prefSum, i);
            }
        }
        
        return res;
    }

    public static void main(String[] args){
        int arr[]={10, 5, 2, 7, 1, -10};
        int k=15;

        int length=lengthOfLongestSubarray(arr, k);
        System.out.println(length);
    }
}

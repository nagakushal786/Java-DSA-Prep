package GFG_160.PrefixSum;

import java.util.HashMap;

public class LongestSubarrayWithEqual0s1s {
    public static int lengthOfLongestSubarray(int[] arr){
        int n=arr.length;
        int res=0, prefixSum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                prefixSum+=arr[i];
            }else{
                prefixSum+=-1;
            }
            
            if(prefixSum==0){
                res=i+1;
            }else if(map.containsKey(prefixSum)){
                res=Math.max(res, i-map.get(prefixSum));
            }
            
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }
        
        return res;
    }

    public static void main(String[] args){
        int arr[]={1, 0, 1, 1, 1, 0, 0};

        int res=lengthOfLongestSubarray(arr);
        System.out.println(res);
    }
}

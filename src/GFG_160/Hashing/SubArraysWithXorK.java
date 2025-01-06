package GFG_160.Hashing;

import java.util.HashMap;

public class SubArraysWithXorK {
    public static int subArraysXorKBrute(int[] arr, int k){
        int n=arr.length;
        int res=0;

        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor^=arr[j];
                if(xor==k){
                    res+=1;
                }
            }
        }

        return res;
    }

    public static int subArraysXorKOptimal(int[] arr, int k){
        HashMap<Integer, Integer> map=new HashMap<>();
        int currXor=0, res=0;

        for(int val: arr){
            currXor^=val;

            if(currXor==k){
                res+=1;
            }

            if(map.containsKey(currXor^k)){
                res+=map.get(currXor^k);
            }

            map.put(currXor, map.getOrDefault(currXor, 0)+1);
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={4, 2, 2, 6, 4};
        int k=6;

        int xor1=subArraysXorKBrute(arr, k);
        System.out.println(xor1);

        int xor2=subArraysXorKOptimal(arr, k);
        System.out.println(xor2);
    }
}

package GFG_160;

import java.util.*;

public class MinimizeHeights {
    public static int getMinDiffMinimizingHeights(int[] arr, int k){
        int n=arr.length;
        Arrays.sort(arr);

        int minDiff=arr[n-1]=arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]-k<0){
                continue;
            }

            int minH=Math.min(arr[0]+k, arr[i]-k);
            int maxH=Math.max(arr[n-1]-k, arr[i-1]+k);

            minDiff=Math.min(minDiff, maxH-minH);
        }

        return minDiff;
    }

    public static void main(String args[]){
        int arr[]={1, 5, 8, 10};
        int k=2;

        int diff=getMinDiffMinimizingHeights(arr, k);
        System.out.println(diff);
    }
}

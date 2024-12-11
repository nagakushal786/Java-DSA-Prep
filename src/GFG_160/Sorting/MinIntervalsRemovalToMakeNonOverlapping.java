package GFG_160.Sorting;

import java.util.*;

public class MinIntervalsRemovalToMakeNonOverlapping {
    public static int minIntervalsRemoval(int[][] arr){
        int n=arr.length;
        int count=0;

        Arrays.sort(arr, (a, b)-> Integer.compare(a[0], b[0]));

        int end=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]<end){
                count+=1;
                end=Math.min(end, arr[i][1]);
            }else{
                end=arr[i][1];
            }
        }

        return count;
    }

    public static void main(String args[]){
        int arr[][]={{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        int cnt1=minIntervalsRemoval(arr);
        System.out.println(cnt1);
    }
}

// T.C: O(nlogn)
// S.C: O(1)
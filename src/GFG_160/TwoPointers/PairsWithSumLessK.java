package GFG_160.TwoPointers;

import java.util.Arrays;

public class PairsWithSumLessK {
    public static int pairsWithSumLessThanKBrute(int[] arr, int target){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]<target){
                    count+=1;
                }
            }
        }

        return count;
    }

    public static int pairsWithSumLessThanKOptimal(int[] arr, int target){
        int n=arr.length;
        int count=0;

        Arrays.sort(arr);
        int low=0, high=n-1;
        while(low<=high){
            if(arr[low]+arr[high]<target){
                count+=high-low;
                low+=1;
            }else{
                high-=1;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int arr[]={2, 1, 8, 3, 4, 7, 6, 5};
        int target=7;

        int count1=pairsWithSumLessThanKBrute(arr, target);
        System.out.println(count1);

        int count2=pairsWithSumLessThanKOptimal(arr, target);
        System.out.println(count2);
    }
}

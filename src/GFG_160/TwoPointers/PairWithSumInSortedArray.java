package GFG_160.TwoPointers;

import java.util.HashSet;

public class PairWithSumInSortedArray {
    public static int pairWithSumKSortedBrute(int[] arr, int target){
        HashSet<Integer> set=new HashSet<>();
        int count=0;

        for(int val: arr){
            int compliment=target-val;

            if(set.contains(compliment)){
                count+=1;
            }

            set.add(val);
        }

        return count;
    }

    public static int pairWithSumKSortedOptimal(int[] arr, int target){
        int n=arr.length;
        int low=0, high=n-1;
        int count=0;

        while(low<high){
            int sum=arr[low]+arr[high];

            if(sum==target){
                int s=low+1;
                int e=high-1;
                count+=1;

                while(s<high && arr[s]==arr[s-1]){
                    count+=1;
                    s+=1;
                }

                while(low<e && arr[e]==arr[e+1]){
                    e-=1;
                    count+=1;
                }

                low+=1;
                high-=1;
            }else if(sum<target){
                low+=1;
            }else{
                high-=1;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int arr[]={-1, 1, 5, 5, 7};
        int target=6;

        int count1=pairWithSumKSortedBrute(arr, target);
        System.out.println(count1);

        int count2=pairWithSumKSortedOptimal(arr, target);
        System.out.println(count2);
    }
}

// Array can contain duplicate elements.
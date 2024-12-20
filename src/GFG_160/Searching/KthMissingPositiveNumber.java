package GFG_160.Searching;

import java.util.HashSet;

public class KthMissingPositiveNumber {
    public static int kthMissingBrute(int[] arr, int k){
        HashSet<Integer> set=new HashSet<>();

        for(int ele: arr){
            set.add(ele);
        }

        int count=0;
        int curr=0;

        while(count<k){
            curr+=1;

            if(!set.contains(curr)){
                count+=1;
            }
        }

        return curr;
    }

    public static int kthMissingBetter(int[] arr, int k){
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]>k+i){
                return k+i;
            }
        }

        return k+n;
    }

    public static int kthMissingOptimal(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;
        int res=n+k;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>k+mid){
                res=mid+k;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={2, 3, 4, 7, 11};
        int k=5;

        int kthMissing1=kthMissingBrute(arr, k);
        System.out.println(kthMissing1);

        int kthMissing2=kthMissingBetter(arr, k);
        System.out.println(kthMissing2);

        int kthMissing3=kthMissingOptimal(arr, k);
        System.out.println(kthMissing3);
    }
}

package Strivers;

import java.util.ArrayList;

public class PrintSubArrayWithMaxSum {
    public static ArrayList<Integer> subarrayWithMaxSum(int[] arr){
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();

        int sum=0;
        int max=Integer.MIN_VALUE;
        int ansS=-1;
        int ansE=-1;
        int start=-1;

        for(int i=0;i<n;i++){
            if(sum==0){
                start=i;
            }

            sum+=arr[i];
            if(sum>max){
                max=sum;
                ansS=start;
                ansE=i;
            }

            if(sum<0){
                sum=0;
            }
        }

        for(int i=ansS;i<=ansE;i++){
            res.add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={2, 3, -8, 7, -1, 2, 3};

        ArrayList<Integer> res=new ArrayList<>();
        res=subarrayWithMaxSum(arr);
        System.out.println(res);
    }
}

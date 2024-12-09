package GFG_160.Arrays;

public class MaxSubarraySumCircular {
    public static int prefixSuffixMethod(int[] arr){
        int n=arr.length;
        int suffixSum=arr[n-1];

        int[] maxSuffix=new int[n+1];
        maxSuffix[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            suffixSum+=arr[i];
            maxSuffix[i]=Math.max(suffixSum, maxSuffix[i+1]);
        }

        int circularSum=arr[0];
        int normalSum=arr[0];

        int maxEnding=0;
        int prefixSum=0;

        for(int i=0;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i], arr[i]);
            normalSum=Math.max(normalSum, maxEnding);

            prefixSum+=arr[i];
            circularSum=Math.max(prefixSum+maxSuffix[i+1], circularSum);
        }

        return Math.max(circularSum, normalSum);
    }

    public static int kadaneMinSumMethod(int[] arr){
        int totalSum=0;
        int maxEnding=0;
        int minEnding=0;
        int maxSum=arr[0];
        int minSum=arr[0];
        int n=arr.length;

        for(int i=0;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i], arr[i]);
            maxSum=Math.max(maxSum, maxEnding);

            minEnding=Math.min(minEnding+arr[i], arr[i]);
            minSum=Math.min(minSum, minEnding);

            totalSum+=arr[i];
        }

        int normalSum=maxSum;
        int circularSum=totalSum-minSum;

        if(totalSum==minSum){
            return normalSum;
        }

        return Math.max(normalSum, circularSum);
    }

    public static void main(String args[]){
        int arr[]={8, -8, 9, -9, 10, -11, 12};

        int maxSum1=prefixSuffixMethod(arr);
        System.out.println(maxSum1);

        int maxSum2=kadaneMinSumMethod(arr);
        System.out.println(maxSum2);
    }
}

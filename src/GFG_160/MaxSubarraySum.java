package GFG_160;

public class MaxSubarraySum {
    public static int kadanesAlgorithm(int[] arr){
        int n=arr.length;
        int maxEnding=arr[0];
        int maxSum=arr[0];

        for(int i=1;i<n;i++){
            maxEnding=Math.max(maxEnding+arr[i], arr[i]);

            maxSum=Math.max(maxSum, maxEnding);
        }

        return maxSum;
    }

    public static void main(String args[]){
        int arr[]={2, 3, -8, 7, -1, 2, 3};
        
        int maxSum=kadanesAlgorithm(arr);
        System.out.println(maxSum);
    }
}

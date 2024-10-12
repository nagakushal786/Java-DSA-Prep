package Strivers.Arrays.Easy;

public class Max_Consecutive_Ones {
    public static int max_consecutive_ones(int[] arr, int n){
        int max_count=0;
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]==1){
                count+=1;
                max_count=Math.max(max_count, count);
            }else{
                count=0;
            }
        }

        return max_count;
    }

    public static void main(String args[]){
        int arr[]={1, 1, 0, 1, 1, 1, 0, 1, 1};
        int n=arr.length;

        int max_con_ones=max_consecutive_ones(arr, n);
        System.out.println(max_con_ones);
    }
}

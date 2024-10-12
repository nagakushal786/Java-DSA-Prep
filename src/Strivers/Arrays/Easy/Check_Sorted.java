package Strivers.Arrays.Easy;
import java.util.*;

public class Check_Sorted {
    public static boolean check_sorted(int[] arr, int n){
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(arr[i]>=arr[i-1]){
                continue;
            }else{
                flag=false;
            }
        }

        return flag;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        boolean isSorted=check_sorted(arr, n);
        if(isSorted){
            System.out.println("Array is sorted");
        }else{
            System.out.println("Array is not sorted");
        }

        sc.close();
    }
}

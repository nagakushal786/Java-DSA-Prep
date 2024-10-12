package Strivers.Arrays.Easy;
import java.util.*;

public class Right_Rotate_1 {
    public static void right_rotate_1(int[] arr, int n){
        int temp=arr[n-1];

        for(int i=n-1;i>0;i--){
            arr[i]=arr[i-1];
        }

        arr[0]=temp;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        System.out.print("Array before rotating left by 1: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        right_rotate_1(arr, n);

        System.out.print("Array after rotating left by 1: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

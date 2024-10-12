package Strivers.Arrays.Easy;
import java.util.*;

public class Left_Rotate_1 {
    public static void left_rotate_1(int[] arr, int n){
        int temp=arr[0];

        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }

        arr[n-1]=temp;
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

        left_rotate_1(arr, n);

        System.out.print("Array after rotating left by 1: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

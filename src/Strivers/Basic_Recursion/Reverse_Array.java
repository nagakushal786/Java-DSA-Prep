package Strivers.Basic_Recursion;
import java.util.*;

public class Reverse_Array {
    public static void reverse_array(int[] arr, int i, int n){
        if(i>=n/2){
            return;
        }
        
        int temp=arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        reverse_array(arr, i+1, n);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        System.out.println("Array before reversing -");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        reverse_array(arr, 0, n);

        System.out.println("Array after reversing -");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}

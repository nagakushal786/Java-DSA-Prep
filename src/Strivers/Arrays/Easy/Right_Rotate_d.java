package Strivers.Arrays.Easy;
import java.util.*;

public class Right_Rotate_d {
    public static void right_rotate_d_brute(int[] arr, int n, int d){
        d=d%n;

        int[] temp=new int[n];

        for(int i=0;i<d;i++){
            temp[i]=arr[n-d+i];
        }

        for(int i=n-1;i>=d;i--){
            arr[i]=arr[i-d];
        }

        for(int i=0;i<d;i++){
            arr[i]=temp[i];
        }
    }

    public static void reverseArray(int[] arr, int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start+=1;
            end-=1;
        }
    }

    public static void right_rotate_d_optimal(int[] arr, int n, int d){
        d=d%n;

        reverseArray(arr, 0, d);
        reverseArray(arr, d+1, n-1);
        reverseArray(arr, 0, n-1);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr1[i]=temp;
        }

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr2[i]=temp;
        }

        System.out.print("Brute array before rotating right by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        right_rotate_d_brute(arr1, n, d);

        System.out.print("Brute array after rotating right by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        System.out.print("Optimal array before rotating right by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        right_rotate_d_optimal(arr2, n, d);

        System.out.print("Optimal array after rotating right by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

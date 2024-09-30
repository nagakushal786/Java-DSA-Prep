package Strivers.Sorting_Algorithms;
import java.util.*;

public class Bubble_Sort {
    public static void bubble_sort_worst(int[] arr, int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<(n-i-1);j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void bubble_sort_best(int[] arr, int n){
        for(int i=0;i<n-1;i++){
            int didSwap=0;
            for(int j=0;j<(n-i-1);j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    didSwap=1;
                }
            }
            if(didSwap==0){
                break;
            }
        }
    }

    public static void bubble_sort_recursive(int[] arr, int n){
        if(n==1){
            return;
        }

        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        bubble_sort_recursive(arr, n-1);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        System.out.print("Array before sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        bubble_sort_worst(arr, n);

        System.out.print("Array after worst sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        bubble_sort_best(arr, n);

        System.out.print("Array after best sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        System.out.print("Array after recursive sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

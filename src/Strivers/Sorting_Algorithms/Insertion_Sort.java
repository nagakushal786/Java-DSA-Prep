package Strivers.Sorting_Algorithms;
import java.util.*;

public class Insertion_Sort {
    public static void insertion_sort(int[] arr, int n){
        for(int i=1;i<n;i++){
            int curr_val=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>curr_val){
                arr[j+1]=arr[j];
                j-=1;
            }
            arr[j+1]=curr_val;
        }
    }

    public static void insertion_sort_recursive(int[] arr, int n){
        if(n==1){
            return;
        }

        insertion_sort_recursive(arr, n-1);

        int last=arr[n-1];
        int j=n-2;

        while(j>=0 && arr[j]>last){
            arr[j+1]=arr[j];
            j-=1;
        }

        arr[j+1]=last;
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

        insertion_sort(arr, n);

        System.out.print("Array after iterative sorting: ");
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

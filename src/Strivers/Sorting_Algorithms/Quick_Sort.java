package Strivers.Sorting_Algorithms;
import java.util.*;

public class Quick_Sort {
    public static int partition(int[] arr, int l, int r){
        int pivot=arr[l];
        int i=l;
        int j=r;

        while(i<j){
            while(arr[i]<=pivot && i<r){
                i+=1;
            }
            while(arr[j]>pivot && j>l){
                j-=1;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp1=arr[l];
        arr[l]=arr[j];
        arr[j]=temp1;

        return j;
    }

    public static void quick_sort(int[] arr, int l, int r){
        if(l<r){
            int pivot=partition(arr, l, r);
            quick_sort(arr, l, pivot-1);
            quick_sort(arr, pivot+1, r);
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        int l=0;
        int r=n-1;

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        System.out.print("Array before sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        quick_sort(arr, l, r);

        System.out.print("Array after sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

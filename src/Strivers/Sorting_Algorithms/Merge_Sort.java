package Strivers.Sorting_Algorithms;
import java.util.*;

public class Merge_Sort {
    public static void merge(int[] arr, int l, int m, int r){
        int n1=m-l+1;
        int n2=r-m;

        int[] arr1=new int[n1];
        int[] arr2=new int[n2];

        for(int i=0;i<n1;i++){
            arr1[i]=arr[l+i];
        }

        for(int j=0;j<n2;j++){
            arr2[j]=arr[m+1+j];
        }

        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i+=1;
                k+=1;
            }else{
                arr[k]=arr2[j];
                j+=1;
                k+=1;
            }
        }

        while(i<n1){
            arr[k]=arr1[i];
            i+=1;
            k+=1;
        }

        while(j<n2){
            arr[k]=arr2[j];
            j+=1;
            k+=1;
        }
    }

    public static void merge_sort(int[] arr, int l, int r){
        if(l<r){
            int mid=l+(r-l)/2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid+1, r);
            merge(arr, l, mid, r);
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

        merge_sort(arr, l, r);

        System.out.print("Array after sorting: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

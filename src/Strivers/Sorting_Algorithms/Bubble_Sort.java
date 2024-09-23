package Strivers.Sorting_Algorithms;
import java.util.*;

public class Bubble_Sort {
    public static void bubble_sort(int[] arr, int n){
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

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        System.out.print("Array before sorting: ");
        for(int item:arr){
            System.out.print(item+" ");
        }
        System.out.println();

        bubble_sort(arr, n);

        System.out.print("Array after sorting: ");
        for(int item:arr){
            System.out.print(item+" ");
        }
        System.out.println();
        sc.close();
    }
}

package Strivers.Sorting_Algorithms;
import java.util.*;

public class Selection_Sort {
    public static void selectionSort(int[] arr, int n){
        for(int i=0;i<=n-2;i++){
            int minIndex=i;
            for(int j=i;j<=n-1;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }

            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
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

        System.out.print("Array before sorted: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        selectionSort(arr, n);

        System.out.print("Array after sorted: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}

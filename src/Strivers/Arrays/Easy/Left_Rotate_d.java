package Strivers.Arrays.Easy;
import java.util.*;

public class Left_Rotate_d {
    // T.C: O(n+d) S.C: O(d)
    public static void left_rotate_d_brute(int[] arr, int n, int d){
        d=d%n;

        int[] temp=new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }

        for(int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }

        for(int i=(n-d);i<n;i++){
            arr[i]=temp[i-(n-d)];
        }
    }

    public static void reverseArray(int[] arr, int l, int r){
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l+=1;
            r-=1;
        }
    }

    // T.C: O(2n) S.C: O(1)
    public static void left_rotate_d_optimal(int[] arr, int n, int d){
        d=d%n;

        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
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

        System.out.print("Brute array before rotating left by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        left_rotate_d_brute(arr1, n, d);

        System.out.print("Brute array after rotating left by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        System.out.print("Optimal array before rotating left by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        left_rotate_d_optimal(arr2, n, d);

        System.out.print("Optimal array after rotating left by d: ");
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

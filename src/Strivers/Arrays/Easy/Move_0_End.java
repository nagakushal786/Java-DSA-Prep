package Strivers.Arrays.Easy;
import java.util.*;

public class Move_0_End {
    public static void move_zero_end_brute(int[] arr, int n){
        ArrayList<Integer> temp=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }

        int nz_elements=temp.size();

        for(int i=0;i<nz_elements;i++){
            arr[i]=temp.get(i);
        }

        for(int i=nz_elements;i<n;i++){
            arr[i]=0;
        }
    }

    public static void move_zero_end_optimal(int[] arr, int n){
        int j=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j+=1;
            }
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
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

        System.out.print("Brute array before moving zeroes to end: ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        move_zero_end_brute(arr1, n);

        System.out.print("Optimal array before moving zeroes to end: ");
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        System.out.print("Optimal array after moving zeroes to end: ");
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        move_zero_end_optimal(arr2, n);

        System.out.print("Brute array before moving zeroes to end: ");
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

        sc.close();
    }
}

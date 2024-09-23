package Strivers.Basic_Hashing;
import java.util.*;

// The array contains the elements from 1 to p whereas we have to find the frequency of elements in the range 1 to n.
// Any element greater than n in the array can be ignored
// We have to modify the array in-place with S.C-O(1)

public class Count_Frequency {
    public static void frequency_count(int[] arr, int n, int p){
        for(int i=0;i<n;i++){
            arr[i]-=1;
        }

        for(int i=0;i<n;i++){
            if(arr[i]%p<n){
                arr[arr[i]%p]+=p;
            }
        }

        for(int i=0;i<n;i++){
            arr[i]=arr[i]/p;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        frequency_count(arr, n, p);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}

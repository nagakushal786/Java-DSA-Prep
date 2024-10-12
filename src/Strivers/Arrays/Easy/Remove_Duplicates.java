// Remove duplicates from sorted array in-place and return number of unique elements in the array

package Strivers.Arrays.Easy;
import java.util.*;

public class Remove_Duplicates {
    public static int brute_force(int[] arr, int n){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }

        int idx=0;
        for(int item: set){
            arr[idx]=item;
            idx+=1;
        }

        return idx;
    }

    public static int optimal_app(int[] arr, int n){
        // Two pointer approach
        int i=0;

        for(int j=1;j<n;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i+=1;
            }
        }

        return i+1;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        int num_unique_1=brute_force(arr, n);
        int num_unique_2=optimal_app(arr, n);

        System.out.println("Brute: "+num_unique_1+", Optimal: "+num_unique_2);

        sc.close();
    }
}

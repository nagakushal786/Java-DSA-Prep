package Strivers.Arrays;
import java.util.*;

public class Largest_Element {
    public static int largest_element(int[] arr, int n){
        int largest=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        int largest=largest_element(arr, n);
        System.out.println(largest);

        sc.close();
    }
}

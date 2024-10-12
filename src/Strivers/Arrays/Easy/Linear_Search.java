package Strivers.Arrays.Easy;
import java.util.*;

public class Linear_Search {
    public static int linear_search(int[] arr, int n, int x){
        int idx=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                idx=i;
                break;
            }
        }

        return idx;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        int idx=linear_search(arr, n, x);

        if(idx!=-1){
            System.out.println("Element "+x+" found at index "+idx);
        }else{
            System.out.println("Element "+x+" not found");
        }

        sc.close();
    }
}

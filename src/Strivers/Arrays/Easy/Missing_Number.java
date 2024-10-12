package Strivers.Arrays.Easy;
import java.util.*;

public class Missing_Number {
    public static int missing_number_brute(int[] arr, int n){
        int m_n=-1;

        for(int i=1;i<=n;i++){
            int flag=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    flag=1;
                    break;
                }
            }

            if(flag==0){
                m_n=i;
            }
        }

        return m_n;
    }

    public static int missing_number_better(int[] arr, int n){
        int[] hashtable=new int[n+1];
        int m_n=-1;

        for(int i=0;i<n+1;i++){
            hashtable[i]=0;
        }

        for(int i=0;i<arr.length;i++){
            hashtable[arr[i]]=1;
        }

        for(int i=1;i<n+1;i++){
            if(hashtable[i]==0){
                m_n=i;
            }
        }

        return m_n;
    }

    public static int missing_number_optimal_1(int[] arr, int n){
        int arr_sum=0;
        for(int i=0;i<arr.length;i++){
            arr_sum+=arr[i];
        }

        int expected_sum=(n*(n+1))/2;

        return expected_sum-arr_sum;
    }

    public static int missing_number_optimal_2(int[] arr, int n){
        int xor1=0, xor2=0;

        for(int i=0;i<arr.length;i++){
            xor1=xor1^(i+1);
            xor2=xor2^(arr[i]);
        }

        xor1=xor1^n;

        return xor1^xor2;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]={1, 2, 4, 5};
        int n=5;

        int choice=sc.nextInt();
        switch(choice){
            case 1: System.out.println("Brute method: "+missing_number_brute(arr, n)); break;
            case 2: System.out.println("Better method: "+missing_number_better(arr, n)); break;
            case 3: System.out.println("Optimal sum method: "+missing_number_optimal_1(arr, n)); break;
            case 4: System.out.println("Optimal xor method: "+missing_number_optimal_2(arr, n)); break;
            default: System.out.println("Choose valid choice");
        }

        sc.close();
    }
}

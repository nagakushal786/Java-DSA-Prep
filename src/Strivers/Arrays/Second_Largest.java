package Strivers.Arrays;
import java.util.*;

public class Second_Largest {
    public static int brute_force(int[] arr, int n){
        Arrays.sort(arr);

        int largest=arr[n-1];
        int slargest=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]!=largest){
                slargest=arr[i];
                break;
            }
        }

        return slargest;
    }

    public static int better_app(int[] arr, int n){
        int largest=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }

        int slargest=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>slargest && arr[i]!=largest){
                slargest=arr[i];
            }
        }

        return slargest;
    }

    public static int optimal_app(int[] arr, int n){
        int largest=arr[0];
        int slargest=-1;

        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }else if(arr[i]<largest && arr[i]>slargest){
                slargest=arr[i];
            }
        }

        return slargest;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        int sec_largest1=brute_force(arr, n);
        int sec_largest2=better_app(arr, n);
        int sec_largest3=optimal_app(arr, n);

        System.out.println("Brute: "+sec_largest1+", Better: "+sec_largest2+", Optimal: "+sec_largest3);

        sc.close();
    }
}

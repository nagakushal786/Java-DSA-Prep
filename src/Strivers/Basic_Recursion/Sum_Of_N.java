package Strivers.Basic_Recursion;
import java.util.*;

public class Sum_Of_N {
    public static void sum_n_param(int i, int n, int sum){
        if(i>n){
            System.out.println(sum);
            return;
        }

        sum+=i;
        sum_n_param(i+1, n, sum);
    }

    public static int sum_1_n_func(int n){
        if(n==0){
            return 0;
        }
        return n+sum_1_n_func(n-1);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println("Parameterized form -");
        sum_n_param(1, n, 0);
        System.out.println("Functional form -");
        int sum=sum_1_n_func(n);
        System.out.println(sum);
        sc.close();
    }
}

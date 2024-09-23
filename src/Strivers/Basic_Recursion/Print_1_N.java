package Strivers.Basic_Recursion;
import java.util.*;

public class Print_1_N {
    public static void print_1_n(int i, int n){
        if(i>n){
            return;
        }

        System.out.println(i);
        print_1_n(i+1, n);
    }

    public static void print_1_n_backtrack(int i, int n){
        if(i<1){
            return;
        }

        print_1_n_backtrack(i-1, n);
        System.out.println(i);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println("Normal process -");
        print_1_n(1, n);
        System.out.println("Backtrack process -");
        print_1_n_backtrack(n, n);
        sc.close();
    }
}

package Strivers.Basic_Recursion;
import java.util.*;

public class Print_N_1 {
    public static void print_n_1(int i, int n){
        if(i<1){
            return;
        }

        System.out.println(i);
        print_n_1(i-1, n);
    }

    public static void print_n_1_backtrack(int i, int n){
        if(i>n){
            return;
        }

        print_n_1_backtrack(i+1, n);
        System.out.println(i);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println("Normal process -");
        print_n_1(n, n);
        System.out.println("Backtrack process -");
        print_n_1_backtrack(1, n);
        sc.close();
    }
}

package Strivers.Basic_Recursion;
import java.util.*;

public class Print_Names {
    public static void print_name(String name, int i, int n){
        if(i==n){
            return;
        }

        System.out.println(name);
        print_name(name, i+1, n);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();

        print_name(name, 0, n);
        sc.close();
    }
}

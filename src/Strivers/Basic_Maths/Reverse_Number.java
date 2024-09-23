package Strivers.Basic_Maths;
import java.util.*;

public class Reverse_Number {
    public static int reverse_number(int num){
        int rev=0;

        while(num>0){
            int a=num%10;
            rev=(rev*10)+a;
            num=num/10;
        }

        return rev;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        int rev=reverse_number(num);
        System.out.println(rev);
        sc.close();
    }
}

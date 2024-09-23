package Strivers.Basic_Maths;
import java.util.*;

public class Find_GCD {
    public static int find_hcf(int a, int b){
        if(a<b){
            int t=a;
            a=b;
            b=t;
        }

        while(b>0){
            int temp=a%b;
            a=b;
            b=temp;
        }

        return a;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        int gcd=find_hcf(a, b);
        System.out.println(gcd);
        sc.close();
    }
}

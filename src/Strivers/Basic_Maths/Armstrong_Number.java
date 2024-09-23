package Strivers.Basic_Maths;
import java.util.*;

public class Armstrong_Number {
    public static boolean check_Armstrong(int num){
        int sum=0;
        int original=num;

        while(num>0){
            int a=num%10;
            sum=sum+(a*a*a);
            num=num/10;
        }

        if(sum==original){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        boolean is_Armstrong=check_Armstrong(num);

        if(is_Armstrong){
            System.out.println(num+" is an Armstrong number");
        }else{
            System.out.println(num+" is not an Armstrong number");
        }
        sc.close();
    }
}

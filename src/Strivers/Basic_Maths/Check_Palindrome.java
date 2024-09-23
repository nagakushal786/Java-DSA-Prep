package Strivers.Basic_Maths;
import java.util.*;

public class Check_Palindrome {
    public static boolean check_palindrome(int num){
        if(num<0){
            return false;
        }
        
        int rev=0;
        int original=num;

        while(num>0){
            int a=num%10;
            rev=(rev*10)+a;
            num=num/10;
        }

        if(rev==original){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        boolean isPalindrome=check_palindrome(num);

        if(isPalindrome){
            System.out.println(num+" is a Palindrome");
        }else{
            System.out.println(num+" is not a Palindrome");
        }
        sc.close();
    }
}

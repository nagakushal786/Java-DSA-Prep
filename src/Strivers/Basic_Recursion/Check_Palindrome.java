package Strivers.Basic_Recursion;
import java.util.*;

public class Check_Palindrome {
    public static boolean check_palindrome(String str, int i, int n){
        if(i>=n/2){
            return true;
        }

        if(str.charAt(i)!=str.charAt(n-i-1)){
            return false;
        }

        return check_palindrome(str, i+1, n);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=str.length();

        boolean isPalindrome=check_palindrome(str, 0, n);
        if(isPalindrome){
            System.out.println(str+" is a Palindrome");
        }else{
            System.out.println(str+" is not a Palindrome");
        }
        sc.close();
    }
}

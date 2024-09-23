package Strivers.Basic_Maths;
import java.util.*;

public class Count_Digits {
    public static int count_digits(int num){
        int count=0;

        while(num>0){
            count=count+1;
            num=num/10;
        }

        return count;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        int count=count_digits(num);
        System.out.println(count);
        sc.close();
    }
}

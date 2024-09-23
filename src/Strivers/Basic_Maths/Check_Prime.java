package Strivers.Basic_Maths;
import java.util.*;

public class Check_Prime {
    public static boolean check_prime(int num){
        int i=1;
        int count=0;

        while(i*i<=num){
            if(num%i==0){
                count+=1;
                if((num/i)!=i){
                    count+=1;
                }
            }
            i=i+1;
        }

        if(count==2){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        boolean isPrime=check_prime(num);

        if(isPrime){
            System.out.println(num+" is a Prime number");
        }else{
            System.out.println(num+" is not a Prime number");
        }
        sc.close();
    }
}

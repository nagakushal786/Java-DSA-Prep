package Strivers.Basic_Maths;
import java.util.*;

public class Print_Divisors {
    public static ArrayList<Integer> print_divisors(int num){
        int i=1;
        ArrayList<Integer> divisors=new ArrayList<>();

        while(i*i<=num){
            if(num%i==0){
                divisors.add(i);
                if((num/i)!=i){
                    divisors.add(num/i);
                }
            }
            i=i+1;
        }

        return divisors;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        ArrayList<Integer> divisors=print_divisors(num);

        for(int divisor: divisors){
            System.out.print(divisor+" ");
        }
        System.out.println();
        sc.close();
    }
}

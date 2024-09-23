package Strivers.Basic_Recursion;

public class Print_N_Times {
    static int count=0;

    public static void print(){
        if(count==4){
            return;
        }

        System.out.println(count);
        count+=1;
        print();
    }

    public static void main(String args[]){
        print();
    }
}

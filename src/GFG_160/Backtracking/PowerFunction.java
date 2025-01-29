package GFG_160.Backtracking;

public class PowerFunction {
    public static double power(double b, int e){
        if(e<0) return 1/power(b, -e);
        if(e==0) return 1;
        if(e==1) return b;

        if(e%2==0) return power(b*b, e/2);
        return b*power(b, e-1);
    }

    public static void main(String[] args){
        double b=3.00000;
        int e=5;

        double ans=power(b, e);
        System.out.println(ans);
    }
}

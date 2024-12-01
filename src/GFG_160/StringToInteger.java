package GFG_160;

public class StringToInteger {
    public static int myAtoi(String s){
        int n=s.length();
        int sign=1;
        int num=0;
        int idx=0;

        while(idx<n && s.charAt(idx)==' '){
            idx+=1;
        }

        while(idx<n && (s.charAt(idx)=='-' || s.charAt(idx)=='+')){
            if(s.charAt(idx)=='-'){
                sign=-1;
            }
            idx+=1;
        }

        while(idx<n && (s.charAt(idx)>='0' && s.charAt(idx)<='9')){
            num=num*10+(s.charAt(idx)-'0');

            if(num>(Integer.MAX_VALUE)/10 || (num==Integer.MAX_VALUE/10 && s.charAt(idx)-'0'>7)){
                if(sign==1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }

            idx+=1;
        }

        return num*sign;
    }

    public static void main(String args[]){
        String s="2147483649";

        int num=myAtoi(s);
        System.out.println(num);
    }
}

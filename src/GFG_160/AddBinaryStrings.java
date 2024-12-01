package GFG_160;

public class AddBinaryStrings {
    public static String trimLeadingZeroes(String s){
        String res="";

        int idx=s.indexOf('1');
        int n=s.length();

        if(idx!=-1){
            for(int i=idx;i<n;i++){
                res+=s.charAt(i);
            }

            return res;
        }

        return "0";
    }

    public static String addBinary(String s1, String s2){
        s1=trimLeadingZeroes(s1);
        s2=trimLeadingZeroes(s2);

        int n=s1.length();
        int m=s2.length();

        if(n<m){
            String temp1=s1;
            s1=s2;
            s2=temp1;

            int temp2=n;
            n=m;
            m=temp2;
        }

        int j=m-1;
        int carry=0;
        String res="";

        for(int i=n-1;i>=0;i--){
            int bit1=s1.charAt(i)-'0';
            int bitsum=carry+bit1;

            if(j>=0){
                int bit2=s2.charAt(j)-'0';
                bitsum+=bit2;
                j-=1;
            }

            int bit=bitsum%2;
            carry=bitsum/2;

            res+=(char)(bit+'0');
        }

        if(carry>0){
            res+='1';
        }

        String reversed=new StringBuilder(res).reverse().toString();
        return reversed;
    }

    public static void main(String args[]){
        String s1="1101";
        String s2="111";

        String s=addBinary(s1, s2);
        System.out.println(s);
    }
}

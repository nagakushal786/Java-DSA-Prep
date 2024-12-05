package GFG_160;

public class MinCharForPalindrome {
    public static void createLPS(String s, int[] lps){
        int lps_len=0;
        int m=lps.length;

        int i=1;
        while(i<m){
            if(s.charAt(i)==s.charAt(lps_len)){
                lps_len+=1;
                lps[i]=lps_len;
                i+=1;
            }else if(lps_len!=0){
                lps_len=lps[lps_len-1];
            }else{
                lps_len=0;
                i+=1;
            }
        }
    }

    public static int minCharCountLPS(String s){
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();

        s=s+"$"+rev;
        int m=s.length();

        int[] lps=new int[m];
        createLPS(s, lps);

        return n-lps[m-1];
    }

    public static void main(String args[]){
        String s="abac";

        int minCount=minCharCountLPS(s);
        System.out.println(minCount);
    }
}

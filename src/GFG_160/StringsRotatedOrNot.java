package GFG_160;

public class StringsRotatedOrNot {
    public static String reverseString(String s, int l, int r){
        StringBuilder sb=new StringBuilder(s);

        while(l<=r){
            char temp=sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);

            l+=1;
            r-=1;
        }

        return sb.toString();
    }

    public static String rotateString(String s, int d){
        int n=s.length();
        d=d%n;

        s=reverseString(s, 0, d-1);
        s=reverseString(s, d, n-1);
        s=reverseString(s, 0, n-1);

        return s;
    }

    public static boolean areRotatedBrute(String s1, String s2){
        int n=s1.length();

        int i=0;
        while(i<n){
            s1=rotateString(s1, 1);

            if(s1.equals(s2)){
                return true;
            }

            i+=1;
        }

        return false;
    }

    public static void constructLPS(String s, int[] lps){
        int m=lps.length;
        int patLen=0;

        int i=1;
        while(i<m){
            if(s.charAt(i)==s.charAt(patLen)){
                patLen+=1;
                lps[i]=patLen;
                i+=1;
            }else if(patLen!=0){
                patLen=lps[patLen-1];
            }else{
                lps[i]=0;
                i+=1;
            }
        }
    }

    public static boolean areRotated(String s1, String s2){
        String txt=s1+s1;
        String pat=s2;

        int n=txt.length();
        int m=pat.length();

        int[] lps=new int[m];
        constructLPS(pat, lps);

        int i=0;
        int j=0;

        while(i<n){
            if(txt.charAt(i)==pat.charAt(j)){
                i+=1;
                j+=1;

                if(j==m){
                    return true;
                }
            }else if(i<n && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i+=1;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){
        String s1="abcd";
        String s2="acbd";

        boolean check1=areRotatedBrute(s1, s2);
        System.out.println(check1);

        boolean check2=areRotated(s1, s2);
        System.out.println(check2);
    }
}

package GFG_160.Strings;

import java.util.*;

public class SearchPattern {
    public static ArrayList<Integer> trialMethod(String txt, String pat){
        int n=txt.length();
        int m=pat.length();
        ArrayList<Integer> indices=new ArrayList<>();

        for(int i=0;i<n-m+1;i++){
            if(txt.substring(i, i+m).equals(pat)){
                indices.add(i);
            }
        }

        return indices;
    }

    public static void constructLPS(String pat, int lps[]){
        int lenPointer=0;
        int m=pat.length();

        lps[0]=0;

        int i=1;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(lenPointer)){
                lenPointer+=1;
                lps[i]=lenPointer;
                i+=1;
            }else if(lenPointer!=0){
                lenPointer=lps[lenPointer-1];
            }else{
                lps[i]=0;
                i+=1;
            }
        }
    }

    public static ArrayList<Integer> kmpAlgorithm(String txt, String pat){
        int n=txt.length();
        int m=pat.length();

        int[] lps=new int[m];
        ArrayList<Integer> indices=new ArrayList<>();

        constructLPS(pat, lps);

        int i=0;
        int j=0;

        while(i<n){
            if(txt.charAt(i)==pat.charAt(j)){
                i+=1;
                j+=1;

                if(j==m){
                    indices.add(i-j);
                    j=lps[j-1];
                }
            }else if(j!=0){
                j=lps[j-1];
            }else{
                i+=1;
            }
        }

        return indices;
    }

    public static void main(String args[]){
        String txt="aabaacaadaabaaba";
        String pat="aaba";

        ArrayList<Integer> indices1=new ArrayList<>();
        indices1=trialMethod(txt, pat);
        System.out.println(indices1);

        ArrayList<Integer> indices2=new ArrayList<>();
        indices2=kmpAlgorithm(txt, pat);
        System.out.println(indices2);
    }
}

// Time complexity: O(m+n)
// Space complexity: O(m)
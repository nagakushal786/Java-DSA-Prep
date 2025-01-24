package Google_Questions;

import java.util.*;

public class test {
    public static ArrayList<Integer> inter(int[] a, int[] b){
        int n=a.length;
        int m=b.length;

        int i=0, j=0;
        ArrayList<Integer> res=new ArrayList<>();

        while(i<n && j<m){
            if(a[i]<b[j]){
                i+=1;
            }else if(b[j]<a[i]){
                j+=1;
            }else{
                res.add(a[i]);
                i+=1;
                j+=1;
            }
        }

        return res;
    }

    public static void main(String args[]){
        int a[]={1, 2, 3, 4, 5};
        int b[]={1, 2, 3, 6, 7};

        ArrayList<Integer> res=new ArrayList<>();
        res=inter(a, b);
        System.out.println(res);
    }
}

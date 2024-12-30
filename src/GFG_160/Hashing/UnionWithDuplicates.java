package GFG_160.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionWithDuplicates {
    public static int unionOfUnsortedArrays(int[] a, int[] b){
        HashSet<Integer> set=new HashSet<>();

        for(int num: a){
            set.add(num);
        }

        for(int num: b){
            set.add(num);
        }

        return new ArrayList<>(set).size();
    }

    public static void main(String args[]){
        int a[]={1, 2, 3, 4, 5};
        int b[]={1, 2, 3};

        int res=unionOfUnsortedArrays(a, b);
        System.out.println(res);
    }
}

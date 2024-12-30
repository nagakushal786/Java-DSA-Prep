package GFG_160.Hashing;

import java.util.*;

public class IntersectionWithDuplicates {
    public static ArrayList<Integer> intOfUnsortedArrays(int[] a, int[] b){
        HashMap<Integer, Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();

        for(int num: a){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int num: b){
            if(map.containsKey(num)){
                set.add(num);
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args){
        int a[]={1, 2, 1, 3, 1};
        int b[]={3, 1, 3, 4, 1};

        ArrayList<Integer> res=new ArrayList<>();
        res=intOfUnsortedArrays(a, b);
        System.out.println(res);
    }
}

package GFG_160.Backtracking;

import java.util.*;

public class PermutationsOfString {
    public static void makePermutations(String s, HashSet<String> ans, String curr, boolean[] visit){
        if(curr.length()==s.length()){
            ans.add(curr);
            return;
        }
        
        for(int i=0;i<s.length();i++){
            if(!visit[i]){
                visit[i]=true;
                makePermutations(s, ans, curr+s.charAt(i), visit);
                visit[i]=false;
            }
        }
    }

    public static ArrayList<String> permutationsOfString(String s){
        HashSet<String> ans=new HashSet<>();
        boolean[] visit=new boolean[s.length()];
        
        makePermutations(s, ans, "", visit);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args){
        String s="abc";

        ArrayList<String> res=new ArrayList<>();
        res=permutationsOfString(s);
        System.out.println(res);
    }
}

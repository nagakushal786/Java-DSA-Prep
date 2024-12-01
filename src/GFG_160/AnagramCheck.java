package GFG_160;

import java.util.*;

public class AnagramCheck {
    public static boolean anagramCheck(String s1, String s2){
        HashMap<Character, Integer> map=new HashMap<>();

        int n=s1.length();
        int m=s2.length();

        for(int i=0;i<n;i++){
            if(map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            }else{
                map.put(s1.charAt(i), 1);
            }
        }

        for(int i=0;i<m;i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
            }else{
                map.put(s2.charAt(i), 1);
            }
        }

        for(char ch: map.keySet()){
            if(map.get(ch)!=0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        String s1="geeks";
        String s2="eksgc";

        boolean isAnagram=anagramCheck(s1, s2);
        System.out.println(isAnagram);
    }
}

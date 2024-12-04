package GFG_160;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static String hashMapApproach(String s){
        int n=s.length();
        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        String res="";
        for(int i=0;i<n;i++){
            if(map.get(s.charAt(i))==1){
                res+=s.charAt(i);
                return res;
            }
        }

        return "$";
    }

    public static String visitedArrayMethod(String s){
        int n=s.length();
        int char_len=26;

        int[] visited=new int[char_len];
        for(int i=0;i<char_len;i++){
            visited[i]=-1;
        }

        for(int i=0;i<n;i++){
            if(visited[s.charAt(i)-'a']==-1){
                visited[s.charAt(i)-'a']=i;
            }else{
                visited[s.charAt(i)-'a']=-2;
            }
        }

        int idx=Integer.MAX_VALUE;

        for(int i=0;i<char_len;i++){
            if(visited[i]>=0){
                idx=Math.min(idx, visited[i]);
            }
        }

        if(idx==Integer.MAX_VALUE){
            return "$";
        }else{
            String res="";
            res+=s.charAt(idx);
            return res;
        }
    }

    public static void main(String args[]){
        String s="zxvcbzxywy";

        String res1=hashMapApproach(s);
        System.out.println(res1);

        String res2=visitedArrayMethod(s);
        System.out.println(res2);
    }
}

// Time complexity: O(n)
// Space complexity: O(26)
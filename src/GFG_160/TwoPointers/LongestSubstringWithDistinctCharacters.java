package GFG_160.TwoPointers;

public class LongestSubstringWithDistinctCharacters {
    public static int longestSubstring(String s){
        int n=s.length();
        int res=0;
        
        int[] lastIndex=new int[26];
        for(int i=0;i<26;i++){
            lastIndex[i]=-1;
        }
        
        int start=0;
        
        for(int end=0;end<n;end++){
            start=Math.max(start, lastIndex[s.charAt(end)-'a']+1);
            res=Math.max(res, end-start+1);
            lastIndex[s.charAt(end)-'a']=end;
        }
        
        return res;
    }

    public static void main(String[] args){
        String s="geeksforgeeks";

        int res=longestSubstring(s);
        System.out.println(res);
    }
}

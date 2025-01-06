package GFG_160.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrintAnagramsTogether {
    public static ArrayList<ArrayList<String>> printAnagramsBrute(String[] arr){
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            String s=arr[i];

            char[] charArray=s.toCharArray();
            Arrays.sort(charArray);
            s=new String(charArray);

            if(!map.containsKey(s)){
                map.put(s, res.size());
                res.add(new ArrayList<>());
            }

            res.get(map.get(s)).add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args){
        String arr[]={"act", "god", "cat", "dog", "tac"};

        ArrayList<ArrayList<String>> res1=new ArrayList<>();
        res1=printAnagramsBrute(arr);
        System.out.println(res1);
    }
}

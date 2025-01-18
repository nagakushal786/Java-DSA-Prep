package GFG_160.TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementsInWindow {
    public static ArrayList<Integer> distinctElementsInWindow(int[] arr, int k){
        HashMap<Integer, Integer> map=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        res.add(map.size());
        
        for(int i=k;i<arr.length;i++){
            if(map.get(arr[i-k])==1){
                map.remove(arr[i-k]);
            }else{
                map.put(arr[i-k], map.get(arr[i-k])-1);
            }
            
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            res.add(map.size());
        }
        
        return res;
    }

    public static void main(String[] args){
        int arr[]={1, 2, 1, 3, 4, 2, 3};
        int k=4;

        ArrayList<Integer> res=new ArrayList<>();
        res=distinctElementsInWindow(arr, k);
        System.out.println(res);
    }
}

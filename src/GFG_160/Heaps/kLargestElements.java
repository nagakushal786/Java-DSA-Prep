package GFG_160.Heaps;

import java.util.*;

public class kLargestElements {
    public static ArrayList<Integer> kLargest(int[] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int num: arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0, pq.poll());
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={12, 5, 787, 1, 23};
        int k=2;

        ArrayList<Integer> res=new ArrayList<>();
        res=kLargest(arr, k);
        System.out.println(res);
    }
}

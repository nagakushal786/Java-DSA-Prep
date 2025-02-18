package GFG_160.Heaps;

import java.util.*;

public class kClosestToOrigin {
    public static int[][] kClosestOrigin(int[][] points, int k){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)-> Integer.compare(distance(b), distance(a)));

        for(int[] pt: points){
            pq.add(pt);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }

        return ans;
    }

    public static int distance(int[] points){
        return points[0]*points[0]+points[1]*points[1];
    }

    public static void main(String[] args){
        int[][] points={{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k=2;

        int[][] ans=new int[k][2];
        ans=kClosestOrigin(points, k);
        
        for(int[] pt: ans){
            for(int num: pt){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

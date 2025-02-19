package GFG_160.Heaps;

import java.util.List;
import java.util.PriorityQueue;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val=val;
        next=null;
    }
}

public class MergeKLinkedLists {
    public static Node mergeKLL(List<Node> arr){
        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)-> a.val-b.val);
        for(Node n: arr){
            pq.add(n);
        }

        Node newHead=null, tail=null;
        while(!pq.isEmpty()){
            Node tmp=pq.poll();
            if(newHead==null){
                newHead=tmp;
                tail=tmp;
            }else{
                tail.next=tmp;
                tail=tmp;
            }

            if(tmp.next!=null){
                pq.add(tmp.next);
            }
        }

        return newHead;
    }
}

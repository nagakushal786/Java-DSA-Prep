package GFG_160.LinkedList;

import java.util.*;

class Node{
    int key, value;
    Node next, prev;
    Node(int key, int value){
        this.key=key;
        this.value=value;
        next=null;
        prev=null;
    }
}

class DLL{
    Node head, tail;
    DLL(){
        head=new Node(-1, -1);
        tail=new Node(-1, -1);
        tail.next=head;
        head.prev=tail;
    }
    
    void addToHead(Node node){
        node.prev=head.prev;
        node.next=head;
        node.prev.next=node;
        node.next.prev=node;
    }
    
    Node removeTail(){
        Node ans=tail.next;
        tail.next=tail.next.next;
        tail.next.prev=tail;
        
        return ans;
    }
    
    void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

public class LRUCache {
    static HashMap<Integer, Node> map;
    static DLL list;
    static int n;
    
    LRUCache(int cap) {
        n=cap;
        list=new DLL();
        map=new HashMap<>();
    }

    public static int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node=map.get(key);
        list.removeNode(node);
        list.addToHead(node);
        return node.value;
    }

    public static void put(int key, int value) {
        Node node=new Node(key, value);
        
        if(map.containsKey(key)){
            Node already=map.get(key);
            map.remove(already.key);
            list.removeNode(already);
        }
        if(map.size()==n){
            Node last=list.removeTail();
            map.remove(last.key);
        }
        
        list.addToHead(node);
        map.put(key, node);
    }
}

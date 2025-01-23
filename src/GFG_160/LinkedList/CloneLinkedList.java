package GFG_160.LinkedList;

class Node{
    int val;
    Node next;
    Node random;
    Node(int val){
        this.val=val;
    }
}

public class CloneLinkedList {
    public static Node cloneLinkedList(Node head){
        Node curr=head;
        
        while(curr!=null){
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            
            curr=curr.next.next;
        }
        
        curr=head;
        while(curr!=null){
            curr.next.random=curr.random==null ? null : curr.random.next;
            curr=curr.next.next;
        }
        
        curr=head;
        Node clone_head=head.next;
        Node clone_curr=clone_head;
        
        while(curr!=null){
            curr.next=curr.next.next;
            
            if(clone_curr.next!=null){
                clone_curr.next=clone_curr.next.next;
            }
            curr=curr.next;
            clone_curr=clone_curr.next;
        }
        
        return clone_head;
    }
}

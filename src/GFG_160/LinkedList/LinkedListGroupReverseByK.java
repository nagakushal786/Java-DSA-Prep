package GFG_160.LinkedList;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}

public class LinkedListGroupReverseByK {
    public static Node reverse(Node start, Node end){
        if(start.next==end){
            return start;
        }
        
        Node ans=reverse(start.next, end);
        start.next.next=start;
        start.next=null;
        return ans;
    }

    public static Node groupReverseByK(Node head, int k){
        Node ans=new Node(-1);
        Node ans_ptr=ans;
        Node head_ptr=head;
        
        while(head_ptr!=null){
            Node start=head_ptr;
            Node end=head_ptr;
            
            int i=0;
            while(i<k && end!=null){
                i+=1;
                end=end.next;
            }
            
            Node rev=reverse(start, end);
            ans_ptr.next=rev;
            ans_ptr=start;
            head_ptr=end;
        }
        
        return ans.next;
    }

    public static void printLinkedList(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+" -> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
}

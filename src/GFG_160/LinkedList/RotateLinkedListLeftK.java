package GFG_160.LinkedList;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}

public class RotateLinkedListLeftK {
    public static int length(Node head){
        int count=0;
        Node curr=head;
        
        while(curr!=null){
            count+=1;
            curr=curr.next;
        }
        
        return count;
    }

    public static Node rotateLeftK(Node head, int k){
        if(head==null){
            return head;
        }
        
        int n=length(head);
        k=k%n;
        
        if(k==0){
            return head;
        }
        
        Node curr=head;
        Node prev=head;
        
        while(curr.next!=null){
            curr=curr.next;
        }
        
        for(int i=0;i<k-1;i++){
            prev=prev.next;
        }
        
        Node new_head=prev.next;
        prev.next=null;
        curr.next=head;
        
        return new_head;
    }

    public static void printLinkedList(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+" -> ");
            curr=curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);

        head=rotateLeftK(head, 7);
        printLinkedList(head);
    }
}

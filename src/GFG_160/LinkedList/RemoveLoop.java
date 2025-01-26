package GFG_160.LinkedList;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}

public class RemoveLoop {
    public static void removeLoop(Node head){
        if(head==null){
            return;
        }

        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }

        if(fast==null || fast.next==null){
            return;
        }

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        while(slow.next!=fast){
            slow=slow.next;
        }
        slow.next=null;
    }
}

package GFG_160.LinkedList;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}

public class FirstNodeOfLoop {
    public static Node firstNodeOfLoop(Node head){
        if(head==null){
            return null;
        }

        Node fast=head;
        Node slow=head;
        Node ptr=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }

                return ptr;
            }
        }

        return null;
    }
}

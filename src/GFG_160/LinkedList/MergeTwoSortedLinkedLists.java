package GFG_160.LinkedList;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}

public class MergeTwoSortedLinkedLists {
    public static Node mergeLL(Node head1, Node head2){
        if(head1==null && head2==null){
            return null;
        }

        if(head1==null){
            return head2;
        }

        if(head2==null){
            return head1;
        }

        Node dummy=new Node(0);
        Node curr1=head1;
        Node curr2=head2;
        Node currHead;
        
        if(curr1.val<=curr2.val){
            dummy.next=curr1;
            currHead=curr1;
            curr1=curr1.next;
        }else{
            dummy.next=curr2;
            currHead=curr2;
            curr2=curr2.next;
        }

        while(curr1!=null && curr2!=null){
            if(curr1.val<=curr2.val){
                currHead.next=curr1;
                curr1=curr1.next;
            }else{
                currHead.next=curr2;
                curr2=curr2.next;
            }
            currHead=currHead.next;
        }

        while(curr1!=null){
            currHead.next=curr1;
            curr1=curr1.next;
            currHead=currHead.next;
        }

        while(curr2!=null){
            currHead.next=curr2;
            curr2=curr2.next;
            currHead=currHead.next;
        }

        return dummy.next;
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
        Node head1=new Node(5);
        head1.next=new Node(10);
        head1.next.next=new Node(15);
        head1.next.next.next=new Node(40);

        Node head2=new Node(2);
        head2.next=new Node(3);
        head2.next.next=new Node(20);

        Node temp;
        temp=mergeLL(head1, head2);

        printLinkedList(temp);
    }
}

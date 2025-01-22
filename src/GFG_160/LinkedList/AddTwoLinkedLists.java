package GFG_160.LinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}

public class AddTwoLinkedLists {
    static Node reverse(Node head){
        Node curr=head;
        Node prev=null;
        Node temp;
        
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        return prev;
    }

    public static Node addLinkedLists(Node num1, Node num2){
        if(num1==null){
            return num2;
        }
        if(num2==null){
            return num1;
        }
        
        Node ptr1=reverse(num1);
        Node ptr2=reverse(num2);
        
        int carry=0;
        Node ans=null;
        
        while(ptr1!=null || ptr2!=null){
            int val1=0;
            int val2=0;
            
            if(ptr1!=null){
                val1=ptr1.data;
            }
            if(ptr2!=null){
                val2=ptr2.data;
            }
            
            int sum=val1+val2+carry;
            carry=sum/10;
            int digit=sum%10;
            
            Node n=new Node(digit);
            if(ans==null){
                ans=n;
            }else{
                n.next=ans;
                ans=n;
            }
            
            if(ptr1!=null){
                ptr1=ptr1.next;
            }
            if(ptr2!=null){
                ptr2=ptr2.next;
            }
        }
        
        if(carry>0){
            Node tt=new Node(carry);
            if(ans==null){
                ans=tt;
            }else{
                tt.next=ans;
                ans=tt;
            }
        }
        
        Node temp=ans;
        while(temp!=null && temp.data==0){
            temp=temp.next;
        }
        
        if(temp==null){
            return new Node(0);
        }
        
        return temp;
    }
}

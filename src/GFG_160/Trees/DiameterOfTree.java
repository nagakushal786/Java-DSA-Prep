package GFG_160.Trees;

class Node{
    int val;
    Node left, right;

    Node(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

public class DiameterOfTree {
    static int ans=0;

    public static int calc(Node node){
        if(node==null){
            return 0;
        }

        int left=calc(node.left);
        int right=calc(node.right);
        ans=Math.max(ans, left+right);
        return Math.max(left, right)+1;
    }

    public static int diameterOfBinaryTree(Node root){
        calc(root);
        return ans;
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

        int diameter=diameterOfBinaryTree(root);
        System.out.println(diameter);
    }
}

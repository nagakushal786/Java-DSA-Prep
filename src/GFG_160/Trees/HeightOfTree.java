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

public class HeightOfTree {
    public static int heightOfBinaryTree(Node root){
        if(root==null){
            return -1;
        }

        int leftHeight=heightOfBinaryTree(root.left);
        int rightHeight=heightOfBinaryTree(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

        int height=heightOfBinaryTree(root);
        System.out.println(height);
    }
}

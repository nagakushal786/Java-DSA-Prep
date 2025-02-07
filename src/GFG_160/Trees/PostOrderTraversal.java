package GFG_160.Trees;

import java.util.*;

class Node{
    int val;
    Node left, right;

    Node(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

public class PostOrderTraversal {
    public static ArrayList<Integer> postOrderTraversal(Node root){
        ArrayList<Integer> res=new ArrayList<>();
        solve(root, res);
        return res;
    }

    public static void solve(Node root, ArrayList<Integer> res){
        if(root==null){
            return;
        }

        solve(root.left, res);
        solve(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

        ArrayList<Integer> res=new ArrayList<>();
        res=postOrderTraversal(root);
        System.out.println(res);
    }
}

package GFG_160.Trees;

import java.util.ArrayList;

class Node{
    int val;
    Node left, right;

    Node(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

public class BoundaryTraversal {
    public static ArrayList<Integer> boundaryTraversal(Node node){
        ArrayList<Integer> ans=new ArrayList<>();

        if(node.left!=null || node.right!=null){
            ans.add(node.val);
        }

        leftNodes(node.left, ans);
        addLeaves(node, ans);
        rightRevNodes(node.right, ans);
        return ans;
    }

    public static void leftNodes(Node node, ArrayList<Integer> ans){
        if(node==null){
            return;
        }

        if(node.left!=null){
            ans.add(node.val);
            leftNodes(node.left, ans);
        }else if(node.right!=null){
            ans.add(node.val);
            leftNodes(node.right, ans);
        }
    }

    public static void addLeaves(Node node, ArrayList<Integer> ans){
        if(node==null){
            return;
        }

        addLeaves(node.left, ans);
        if(node.left==null && node.right==null){
            ans.add(node.val);
        }
        addLeaves(node.right, ans);
    }

    public static void rightRevNodes(Node node, ArrayList<Integer> ans){
        if(node==null){
            return;
        }

        if(node.right!=null){
            rightRevNodes(node.right, ans);
            ans.add(node.val);
        }else if(node.left!=null){
            rightRevNodes(node.left, ans);
            ans.add(node.val);
        }
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

        ArrayList<Integer> res=new ArrayList<>();
        res=boundaryTraversal(root);
        System.out.println(res);
    }
}

package GFG_160.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left, right;

    Node(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

public class MirrorTree {
    public static void mirrorTree(Node root){
        if(root==null){
            return;
        }

        Node temp=root.left;
        root.left=root.right;
        root.right=temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

        mirrorTree(root);

        Queue<Node> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> level=new ArrayList<>();
            while(size>0){
                Node temp=q.poll();
                level.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }

                size-=1;
            }

            res.add(level);
        }

        System.out.println(res);
    }
}

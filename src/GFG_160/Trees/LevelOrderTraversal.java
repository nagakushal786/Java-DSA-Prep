package GFG_160.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left, right;
    Node(int item){
        this.data=item;
        left=null;
        right=null;
    }
}

public class LevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> level=new ArrayList<>();
            while(size>0){
                Node temp=q.poll();
                level.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }

                size-=1;
            }
            
            ans.add(level);
        }
        
        return ans;
    }

    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.right=new Node(5);

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        res=levelOrder(root);
        System.out.println(res);
    }
}

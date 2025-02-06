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

public class InorderPreorderTreeConstruction {
    public static int pos;

    public static Node solve(int[] inorder, int[] preorder, int str, int end){
        if(str>inorder.length || str>end){
            return null;
        }

        Node root=new Node(preorder[pos]);
        int div=0;

        for(int i=str;i<=end;i++){
            if(preorder[pos]==inorder[i]){
                div=i;
                break;
            }
        }

        pos+=1;
        for(int i=str;i<=end;i++){
            if(preorder[pos]==inorder[i]){
                div=i;
                break;
            }
        }

        root.left=solve(inorder, preorder, str, div-1);
        root.right=solve(inorder, preorder, div+1, end);
        return root;
    }

    public static Node treeConstruction(int[] inorder, int[] preorder){
        pos=0;
        return solve(inorder, preorder, 0, inorder.length-1);
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

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

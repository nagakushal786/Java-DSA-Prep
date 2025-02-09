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

public class MaxPathSumFromRoot {
    public static int solve(Node root, int[] maxSum){
        if(root==null){
            return 0;
        }

        int leftSum=Math.max(0, solve(root.left, maxSum));
        int rightSum=Math.max(0, solve(root.right, maxSum));

        maxSum[0]=Math.max(maxSum[0], root.val+leftSum+rightSum);

        return root.val+Math.max(leftSum, rightSum);
    }

    public static int maxPathSum(Node root){
        int[] maxSum={Integer.MIN_VALUE};
        solve(root, maxSum);
        return maxSum[0];
    }

    public static void main(String[] args){
        Node root=new Node(5);
        root.left=new Node(8);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(7);
        root.right.left=new Node(9);

        int maxPathSum=maxPathSum(root);
        System.out.println(maxPathSum);
    }
}

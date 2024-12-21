package GFG_160.Matrix;

import java.util.*;

public class SpiralTraversal {
    public static ArrayList<Integer> spiralTraversal(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int top=0, bottom=n-1;
        int left=0, right=m-1;
        ArrayList<Integer> ans=new ArrayList<>();

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(mat[top][i]);
            }
            top+=1;

            for(int j=top;j<=bottom;j++){
                ans.add(mat[j][right]);
            }
            right-=1;

            if(top<=bottom){
                for(int k=right;k>=left;k--){
                    ans.add(mat[bottom][k]);
                }
                bottom-=1;
            }

            if(left<=right){
                for(int l=bottom;l>=top;l--){
                    ans.add(mat[l][left]);
                }
                left+=1;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int mat[][]={{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        ArrayList<Integer> res=new ArrayList<>();
        res=spiralTraversal(mat);
        System.out.println(res);
    }
}

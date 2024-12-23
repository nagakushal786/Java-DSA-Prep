package GFG_160.Matrix;

public class SearchInRowAndColumnSortedMatrix {
    public static boolean searchBrute(int[][] mat, int x){
        int n=mat.length;
        int m=mat[0].length;
        boolean isFound=false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==x){
                    isFound=true;
                    break;
                }
            }
        }

        return isFound;
    }

    public static boolean searchOptimal(int[][] mat, int x){
        int n=mat.length;
        int m=mat[0].length;

        int i=0, j=m-1;
        boolean isFound=false;

        while(i<n && j>=0){
            if(mat[i][j]>x){
                j-=1;
            }else if(mat[i][j]<x){
                i+=1;
            }else{
                isFound=true;
                break;
            }
        }

        return isFound;
    }

    public static void main(String args[]){
        int mat[][]={{3, 30, 38}, {20, 52, 54}, {35, 60, 69}};
        int x=62;

        boolean found1=searchBrute(mat, x);
        System.out.println(found1);

        boolean found2=searchOptimal(mat, x);
        System.out.println(found2);
    }
}

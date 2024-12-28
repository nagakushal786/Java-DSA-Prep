package GFG_160.Matrix;

public class SetMatrixZeroes {
    public static void setMatZeroesBrute(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rows[i]==true || cols[j]==true){
                    mat[i][j]=0;
                }
            }
        }
    }

    public static void setMatZeroesOptimal(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int c0=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;

                    if(j==0){
                        c0=0;
                    }else{
                        mat[0][j]=0;
                    }
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][0]==0 || mat[0][j]==0){
                    mat[i][j]=0;
                }
            }
        }

        if(mat[0][0]==0){
            for(int j=0;j<m;j++){
                mat[0][j]=0;
            }
        }

        if(c0==0){
            for(int i=0;i<n;i++){
                mat[i][0]=0;
            }
        }
    }

    public static void main(String[] args){
        int mat[][]={{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        setMatZeroesOptimal(mat);
        for(int[] row: mat){
            for(int ele: row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        System.out.println();

        setMatZeroesBrute(mat);
        for(int[] row: mat){
            for(int ele: row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

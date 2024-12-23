package GFG_160.Matrix;

public class RotateBy90 {
    public static void rotate90Brute(int[][] mat){
        int n=mat.length;
        int[][] res=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[n-1-j][i]=mat[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=res[i][j];
            }
        }
    }

    public static void rotate90Better(int[][] mat){
        int n=mat.length;

        for(int i=0;i<(n/2);i++){
            for(int j=i;j<n-i-1;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][n-1-i];
                mat[j][n-1-i]=mat[n-1-i][n-1-j];
                mat[n-1-i][n-1-j]=mat[n-1-j][i];
                mat[n-1-j][i]=temp;
            }
        }
    }

    public static void reverse(int[] arr){
        int m=arr.length;

        for(int i=0;i<(m/2);i++){
            int temp=arr[i];
            arr[i]=arr[m-1-i];
            arr[m-1-i]=temp;
        }
    }

    public static void rotate90Optimal(int[][] mat){
        int n=mat.length;

        for(int[] row: mat){
            reverse(row);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }

    public static void main(String args[]){
        int mat[][]={{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n=mat.length;

        rotate90Optimal(mat);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        rotate90Better(mat);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        rotate90Brute(mat);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}

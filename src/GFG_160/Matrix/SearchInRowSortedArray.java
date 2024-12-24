package GFG_160.Matrix;

public class SearchInRowSortedArray {
    public static boolean binarySearch(int[] arr, int l, int r, int x){
        while(l<=r){
            int mid=l+(r-l)/2;

            if(arr[mid]==x){
                return true;
            }else if(arr[mid]<x){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return false;
    }

    public static boolean searchOptimal(int[][] mat, int x){
        int n=mat.length;
        int m=mat[0].length;
        boolean isFound=false;

        for(int i=0;i<n;i++){
            if(binarySearch(mat[i], 0, m-1, x)){
                isFound=true;
                break;
            }
        }

        return isFound;
    }

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

    public static void main(String args[]){
        int mat[][]={{3, 4, 9}, {2, 5, 6}, {9, 25, 27}};
        int x=9;

        boolean found1=searchBrute(mat, x);
        System.out.println(found1);

        boolean found2=searchOptimal(mat, x);
        System.out.println(found2);
    }
}

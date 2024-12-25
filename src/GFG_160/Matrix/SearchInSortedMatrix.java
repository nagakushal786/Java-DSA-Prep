package GFG_160.Matrix;

public class SearchInSortedMatrix {
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

    public static boolean searchBetter(int[][] mat, int x){
        int n=mat.length;
        int m=mat[0].length;
        int row=-1;

        int low=0, high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(mat[mid][0]==x){
                return true;
            }

            if(mat[mid][0]<x){
                row=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        if(row!=-1){
            return binarySearch(mat[row], 0, m-1, x);
        }else{
            return false;
        }
    }

    public static boolean searchOptimal(int[][] mat, int x){
        int n=mat.length;
        int m=mat[0].length;

        int low=0, high=(n*m)-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            int row=mid/m;
            int col=mid%m;

            if(mat[row][col]<x){
                low=mid+1;
            }else if(mat[row][col]>x){
                high=mid-1;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int mat[][]={{1, 5, 9}, {14, 20, 21}, {30, 34, 43}};
        int x=14;

        boolean found1=searchBetter(mat, x);
        System.out.println(found1);

        boolean found2=searchOptimal(mat, x);
        System.out.println(found2);
    }
}

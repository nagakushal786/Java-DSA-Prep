package GFG_160.PrefixSum;

public class ProductArrayPuzzle {
    public static int[] productArrayPuzzle(int[] arr){
        int n=arr.length;
        
        int[] left=new int[n];
        int[] right=new int[n];
        int[] res=new int[n];
        
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*arr[i-1];
        }
        
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*arr[i+1];
        }
        
        for(int i=0;i<n;i++){
            res[i]=left[i]*right[i];
        }
        
        return res;
    }

    public static void main(String[] args){
        int arr[]={10, 3, 5, 6, 2};

        int[] res=new int[arr.length];
        res=productArrayPuzzle(arr);
        for(int num: res){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}

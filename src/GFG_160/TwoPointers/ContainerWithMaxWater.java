package GFG_160.TwoPointers;

public class ContainerWithMaxWater {
    public static int maxWater(int[] arr){
        int n=arr.length;
        int res=0;
        
        int left=0, right=n-1;
        while(left<=right){
            if(arr[left]<=arr[right]){
                res=Math.max(res, arr[left]*(right-left));
                left+=1;
            }else{
                res=Math.max(res, arr[right]*(right-left));
                right-=1;
            }
        }
        
        return res;
    }

    public static void main(String[] args){
        int arr[]={1, 5, 4, 3};

        int res=maxWater(arr);
        System.out.println(res);
    }
}

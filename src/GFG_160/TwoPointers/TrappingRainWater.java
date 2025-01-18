package GFG_160.TwoPointers;

public class TrappingRainWater {
    public static int trappingRainWater(int arr[]){
        int n=arr.length;
        
        int left=1;
        int right=n-2;
        
        int lmax=arr[left-1];
        int rmax=arr[right+1];
        int res=0;
        
        while(left<=right){
            if(rmax<=lmax){
                res+=Math.max(0, rmax-arr[right]);
                rmax=Math.max(rmax, arr[right]);
                right-=1;
            }else{
                res+=Math.max(0, lmax-arr[left]);
                lmax=Math.max(lmax, arr[left]);
                left+=1;
            }
        }
        
        return res;
    }

    public static void main(String[] args){
        int arr[]={3, 0, 1, 0, 4, 0, 2};

        int res=trappingRainWater(arr);
        System.out.println(res);
    }
}

package GFG_160.TwoPointers;

import java.util.Arrays;

public class CountPossibleTriangles {
    public static int countTriangles(int[] arr){
        int n=arr.length;
        int ans=0;
        Arrays.sort(arr);

        for(int i=n-1;i>=0;i--){
            int l=0, r=i-1;
            while(l<r){
                int sum=arr[l]+arr[r];
                if(sum>arr[i]){
                    ans+=r-l;
                    r-=1;
                }else{
                    l+=1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int arr[]={4, 6, 3, 7};

        int count=countTriangles(arr);
        System.out.println(count);
    }
}

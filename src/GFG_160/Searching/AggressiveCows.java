package GFG_160.Searching;

import java.util.Arrays;

public class AggressiveCows {
    public static boolean check(int[] stalls, int k, int dist){
        int cnt=1;
        int prev=stalls[0];
        int n=stalls.length;

        for(int i=1;i<n;i++){
            if(stalls[i]-prev>=dist){
                prev=stalls[i];
                cnt+=1;
            }
        }

        if(cnt>=k){
            return true;
        }else{
            return false;
        }
    }

    public static int aggressiveCowsBrute(int[] stalls, int k){
        Arrays.sort(stalls);
        int n=stalls.length;
        int res=0;

        int minDist=1;
        int maxDist=stalls[n-1]-stalls[0];

        for(int i=minDist;i<=maxDist;i++){
            if(check(stalls, k, i)){
                res=i;
            }
        }

        return res;
    }

    public static int aggressiveCowsOptimal(int[] stalls, int k){
        Arrays.sort(stalls);
        int n=stalls.length;
        int res=0;
        
        int low=1;
        int high=stalls[n-1]-stalls[0];

        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(stalls, k, mid)){
                res=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return res;
    }

    public static void main(String args[]){
        int arr[]={1, 2, 4, 8, 9};
        int k=3;

        int minDistThatIsMax1=aggressiveCowsBrute(arr, k);
        System.out.println(minDistThatIsMax1);

        int minDistThatIsMax2=aggressiveCowsOptimal(arr, k);
        System.out.println(minDistThatIsMax2);
    }
}

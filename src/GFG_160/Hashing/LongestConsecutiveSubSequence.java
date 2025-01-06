package GFG_160.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubSequence {
    public static int lengthOfLCSubsequenceBrute(int[] arr){
        Arrays.sort(arr);

        ArrayList<Integer> v=new ArrayList<>();
        v.add(arr[0]);

        int count=1, ans=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                v.add(arr[i]);
            }
        }

        for(int i=0;i<v.size();i++){
            if(i>0 && v.get(i)==v.get(i-1)+1){
                count+=1;
            }else{
                count=1;
            }

            ans=Math.max(ans, count);
        }

        return ans;
    }

    public static int lengthOfLCSubsequenceOptimal(int[] arr){
        int n=arr.length;
        int ans=0;

        HashSet<Integer> set=new HashSet<>();

        for(int ele: arr){
            set.add(ele);
        }

        for(int i=0;i<n;i++){
            if(!set.contains(arr[i]-1)){
                int j=arr[i];
                while(set.contains(j)){
                    j+=1;
                }

                ans=Math.max(ans, j-arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int arr[]={15, 13, 12, 14, 11, 10, 9};

        int ans1=lengthOfLCSubsequenceBrute(arr);
        System.out.println(ans1);

        int ans2=lengthOfLCSubsequenceOptimal(arr);
        System.out.println(ans2);
    }
}

package GFG_160.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class CountTargetPairs {
    public static int countPairsBrute(int[] arr, int target){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    count+=1;
                }
            }
        }

        return count;
    }

    public static int countPairsBetter(int[] arr, int target){
        int n=arr.length;
        int res=0;

        Arrays.sort(arr);
        int left=0, right=n-1;

        while(left<=right){
            if(arr[left]+arr[right]<target){
                left+=1;
            }else if(arr[left]+arr[right]>target){
                right-=1;
            }else{
                int c1=0, c2=0;
                int ele1=arr[left], ele2=arr[right];

                while(left<=right && arr[left]==ele1){
                    left+=1;
                    c1+=1;
                }

                while(left<=right && arr[right]==ele2){
                    right-=1;
                    c2+=1;
                }

                if(ele1==ele2){
                    res+=(c1)*(c1-1)/2;
                }else{
                    res+=(c1*c2);
                }
            }
        }

        return res;
    }

    public static int countPairsOptimal(int[] arr, int target){
        int res=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int num: arr){
            int compliment=target-num;

            if(map.containsKey(compliment)){
                res+=map.get(compliment);
            }

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        return res;
    }

    public static void main(String args[]){
        int arr[]={1, 5, 7, -1, 5};
        int target=6;

        int count1=countPairsBrute(arr, target);
        System.out.println(count1);

        int count2=countPairsBetter(arr, target);
        System.out.println(count2);

        int count3=countPairsOptimal(arr, target);
        System.out.println(count3);
    }
}

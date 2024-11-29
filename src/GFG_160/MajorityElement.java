package GFG_160;

import java.util.*;

public class MajorityElement {
    public static ArrayList<Integer> hashMapApproach(int[] arr){
        HashMap<Integer, Integer> map=new HashMap<>();
        ArrayList<Integer> result=new ArrayList<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(int ele: map.keySet()){
            if(map.get(ele)>(n/3)){
                result.add(ele);
            }
        }

        if(result.size()!=0){
            result.sort(null);
        }

        return result;
    }

    public static ArrayList<Integer> mooresVotingAlgorithm(int[] arr){
        int n=arr.length;

        int ele1=-1, ele2=-1;
        int cnt1=0, cnt2=0;

        for(int ele: arr){
            if(ele1==ele){
                cnt1+=1;
            }else if(ele2==ele){
                cnt2+=1;
            }else if(cnt1==0){
                ele1=ele;
                cnt1+=1;
            }else if(cnt2==0){
                ele2=ele;
                cnt2+=1;
            }else{
                cnt1-=1;
                cnt2-=1;
            }
        }

        ArrayList<Integer> result=new ArrayList<>();
        cnt1=0;
        cnt2=0;

        for(int ele: arr){
            if(ele==ele1){
                cnt1+=1;
            }
            if(ele==ele2){
                cnt2+=1;
            }
        }

        if(cnt1>(n/3)){
            result.add(ele1);
        }
        if(cnt2>(n/3) && ele1!=ele2){
            result.add(ele2);
        }

        if(result.size()!=0){
            result.sort(null);
        }

        return result;
    }

    public static void main(String args[]){
        int arr1[]={2, 3, 3, 2, 1, 1};
        int arr2[]={2, 1, 1, 1, 1, 3, 5, 1, 1, 2};

        ArrayList<Integer> result1=hashMapApproach(arr1);
        System.out.println(result1);

        ArrayList<Integer> result2=hashMapApproach(arr2);
        System.out.println(result2);
    }
}

// Time complexity for hashmap approach: O(n)
// Space complexity for hashmap approach: O(n)

// Time complexity of moores approach: O(n)
// Space complexity of moores approach: O(1)
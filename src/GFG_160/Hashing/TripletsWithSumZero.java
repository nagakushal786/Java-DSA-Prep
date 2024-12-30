package GFG_160.Hashing;

import java.util.*;

public class TripletsWithSumZero {
    public static ArrayList<int[]> tripletsWithZeroSumBrute(int[] arr){
        int n=arr.length;

        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        list.add(new int[]{i, j, k});
                    }
                }
            }
        }

        return list;
    }

    public static List<List<Integer>> tripletsWithZeroSumOptimal(int[] arr){
        int n=arr.length;

        HashMap<Integer, List<int[]>> map=new HashMap<>();
        HashSet<List<Integer>> set=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int s=arr[i]+arr[j];
                if(!map.containsKey(s)){
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(new int[]{i, j});
            }
        }

        for(int i=0;i<n;i++){
            int other=-arr[i];

            if(map.containsKey(other)){
                for(int[] p: map.get(other)){
                    if(p[0]!=i && p[1]!=i){
                        List<Integer> curr=Arrays.asList(i, p[0], p[1]);
                        Collections.sort(curr);
                        set.add(curr);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String args[]){
        int arr[]={0, -1, 2, -3, 1};

        ArrayList<int[]> ans1=new ArrayList<>();
        ans1=tripletsWithZeroSumBrute(arr);
        for(int[] triplet: ans1){
            for(int ele: triplet){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

        List<List<Integer>> ans2=new ArrayList<>();
        ans2=tripletsWithZeroSumOptimal(arr);
        for(List<Integer> triplet: ans2){
            for(int ele: triplet){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}

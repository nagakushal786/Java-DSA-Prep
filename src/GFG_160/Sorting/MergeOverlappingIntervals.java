package GFG_160.Sorting;

import java.util.*;

public class MergeOverlappingIntervals {
    public static ArrayList<int[]> mergeOverlappingIntervalsBrute(int[][] arr){
        int n=arr.length;

        Arrays.sort(arr, (a, b)-> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res=new ArrayList<>();

        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];

            if(res.size()!=0 && res.get(res.size()-1)[1]>=end){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(arr[j][0]<=end){
                    end=Math.max(end, arr[j][1]);
                }
            }

            res.add(new int[]{start, end});
        }

        return res;
    }

    public static ArrayList<int[]> mergeOverlappingIntervalsBetter(int[][] arr){
        int n=arr.length;

        Arrays.sort(arr, (a, b)-> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res=new ArrayList<>();
        res.add(arr[0]);

        for(int i=1;i<n;i++){
            int[] last=res.get(res.size()-1);
            int[] curr=arr[i];

            if(curr[0]<=last[1]){
                last[1]=Math.max(last[1], curr[1]);
            }else{
                res.add(curr);
            }
        }

        return res;
    }

    public static ArrayList<int[]> mergeOverlappingIntervalsOptimal(int[][] arr){
        int n=arr.length;

        Arrays.sort(arr, (a, b)-> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res=new ArrayList<>();
        int resIdx=0;

        for(int i=1;i<n;i++){
            if(arr[resIdx][1]>=arr[i][0]){
                arr[resIdx][1]=Math.max(arr[resIdx][1], arr[i][1]);
            }else{
                resIdx+=1;
                arr[resIdx]=arr[i];
            }
        }

        for(int i=0;i<=resIdx;i++){
            res.add(arr[i]);
        }

        return res;
    }

    public static void main(String args[]){
        int arr[][]={{1, 3}, {2, 4}, {6, 8}, {9, 10}};

        ArrayList<int[]> res1=new ArrayList<>();
        res1=mergeOverlappingIntervalsOptimal(arr);
        System.out.print("Inplace sorting with O(nlogn) T.C and O(n) S.C: ");
        for(int[] ele: res1){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();

        ArrayList<int[]> res2=new ArrayList<>();
        res2=mergeOverlappingIntervalsBetter(arr);
        System.out.print("Comparing with last merged interval with O(nlogn) T.C and O(n) S.C: ");
        for(int[] ele: res2){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();

        ArrayList<int[]> res3=new ArrayList<>();
        res3=mergeOverlappingIntervalsBrute(arr);
        System.out.print("Comparing all with O(n^2) T.C and O(n) S.C: ");
        for(int[] ele: res3){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();
    }
}

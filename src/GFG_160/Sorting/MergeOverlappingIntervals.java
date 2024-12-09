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

    public static ArrayList<int[]> mergeOverlappingIntervalsOptimal(int[][] arr){
        int n=arr.length;
        ArrayList<int[]> res=new ArrayList<>();

        Arrays.sort(arr, (a, b)-> Integer.compare(a[0], b[0]));

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
        for(int[] ele: res1){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();

        ArrayList<int[]> res=new ArrayList<>();
        res=mergeOverlappingIntervalsBrute(arr);
        for(int[] ele: res){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();
    }
}

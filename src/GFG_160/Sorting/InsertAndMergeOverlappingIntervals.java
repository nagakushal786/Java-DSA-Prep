package GFG_160.Sorting;

import java.util.*;

public class InsertAndMergeOverlappingIntervals {
    public static ArrayList<int[]> mergeInsertedIntervalBetter(int[][] arr, int[] newInt){
        int n=arr.length;

        int[][] updatedArr=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            updatedArr[i]=arr[i];
        }
        updatedArr[n]=newInt;

        Arrays.sort(updatedArr, (a, b)-> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res=new ArrayList<>();

        int m=updatedArr.length;
        res.add(updatedArr[0]);

        for(int i=1;i<m;i++){
            int[] last=res.get(res.size()-1);
            int[] curr=updatedArr[i];

            if(curr[0]<=last[1]){
                last[1]=Math.max(last[1], curr[1]);
            }else{
                res.add(curr);
            }
        }

        return res;
    }

    public static ArrayList<int[]> mergeInsertedIntervalOptimal(int[][] arr, int[] newInt){
        int n=arr.length;
        ArrayList<int[]> res=new ArrayList<>();
        
        int i=0;

        while(i<n && arr[i][1]<newInt[0]){
            res.add(arr[i]);
            i+=1;
        }

        while(i<n && arr[i][0]<=newInt[1]){
            newInt[0]=Math.min(newInt[0], arr[i][0]);
            newInt[1]=Math.max(newInt[1], arr[i][1]);
            i+=1;
        }

        res.add(newInt);

        while(i<n){
            res.add(arr[i]);
            i+=1;
        }

        return res;
    }

    public static void main(String args[]){
        int arr[][]={{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInt={4, 9};

        ArrayList<int[]> res1=new ArrayList<>();
        res1=mergeInsertedIntervalBetter(arr, newInt);
        for(int[] ele: res1){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();

        ArrayList<int[]> res2=new ArrayList<>();
        res2=mergeInsertedIntervalOptimal(arr, newInt);
        for(int[] ele: res2){
            System.out.print(Arrays.toString(ele)+" ");
        }
        System.out.println();
    }
}

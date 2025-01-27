package Strivers;

import java.util.ArrayList;

// Number of positives not same as number of negatives

public class ArrangeWithAlternatingSigns {
    public static int[] arrangeArray(int[] arr){
        int n=arr.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i]<0){
                neg.add(arr[i]);
            }else{
                pos.add(arr[i]);
            }
        }

        if(pos.size()>neg.size()){
            for(int i=0;i<neg.size();i++){
                arr[2*i]=pos.get(i);
                arr[2*i+1]=neg.get(i);
            }

            int index=neg.size()*2;
            for(int i=neg.size();i<pos.size();i++){
                arr[index]=pos.get(i);
                index+=1;
            }
        }else{
            for(int i=0;i<pos.size();i++){
                arr[2*i]=pos.get(i);
                arr[2*i+1]=neg.get(i);
            }

            int index=pos.size()*2;
            for(int i=pos.size();i<neg.size();i++){
                arr[index]=neg.get(i);
                index+=1;
            }
        }

        return arr;
    }

    public static void main(String[] args){
        int arr[]={-1, 2, 3, 4, -3, 1};

        arr=arrangeArray(arr);
        for(int num: arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}

package GFG_160.Sorting;

import java.util.*;

public class MergeWithoutExtraSpace {
    public static void mergeSortedArraysWithoutExtraSpaceBetter(int[] a, int[] b){
        int n=a.length;
        int m=b.length;

        int i=n-1;
        int j=0;

        while(i>=0 && j<m){
            if(a[i]<b[j]){
                i-=1;
            }else{
                int temp=a[i];
                a[i]=b[j];
                b[j]=temp;

                i-=1;
                j+=1;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void gapApproach(int[] a, int[] b){
        int n=a.length;
        int m=b.length;
        int gap=(n+m+1)/2;

        while(gap>0){
            int i=0;
            int j=gap;

            while(j<m+n){
                if(j<n && a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }else if(i<n && j>=n && a[i]>b[j-n]){
                    int temp=a[i];
                    a[i]=b[j-n];
                    b[j-n]=temp;
                }else if(i>=n && b[i-n]>b[j-n]){
                    int temp=b[i-n];
                    b[i-n]=b[j-n];
                    b[j-n]=temp;
                }

                i+=1;
                j+=1;
            }

            if(gap==1){
                break;
            }

            gap=(gap+1)/2;
        }
    }

    public static void main(String args[]){
        int a1[]={1, 5, 9, 10, 15, 20};
        int b1[]={2, 3, 8, 13};
        
        mergeSortedArraysWithoutExtraSpaceBetter(a1, b1);
        for(int ele1: a1){
            System.out.print(ele1+" ");
        }
        System.out.println();

        for(int ele2: b1){
            System.out.print(ele2+" ");
        }
        System.out.println();

        int a2[]={1, 5, 9, 10, 15, 20};
        int b2[]={2, 3, 8, 13};
        
        gapApproach(a2, b2);
        for(int ele1: a2){
            System.out.print(ele1+" ");
        }
        System.out.println();

        for(int ele2: b2){
            System.out.print(ele2+" ");
        }
        System.out.println();
    }
}

package GFG_160.Searching;

import java.util.*;

public class KthElementInMergedSortedArrays {
    public static int kthElementBrute(int[] a, int[] b, int k){
        int n=a.length;
        int m=b.length;

        int[] c=new int[n+m];
        int idx=0;

        for(int i=0;i<n;i++){
            c[idx]=a[i];
            idx+=1;
        }

        for(int j=0;j<m;j++){
            c[idx]=b[j];
            idx+=1;
        }

        Arrays.sort(c);
        return c[k-1];
    }

    public static int kthElementBetter(int[] a, int[] b, int k){
        int n=a.length;
        int m=b.length;

        int last=0, i=0, j=0;

        for(int l=0;l<k;l++){
            if(i<n){
                if(j<m && a[i]>b[j]){
                    last=b[j];
                    j+=1;
                }else{
                    last=a[i];
                    i+=1;
                }
            }else if(j<m){
                last=b[j];
                j+=1;
            }
        }

        return last;
    }

    public static int kthElementOptimal(int[] a, int[] b, int k){
        int n=a.length;
        int m=b.length;

        if(n>m){
            return kthElementOptimal(b, a, k);
        }
        
        int ele=0;
        int low=Math.max(0, k-m);
        int high=Math.min(n, k);

        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=k-mid1;

            int l1=((mid1==0) ? Integer.MIN_VALUE : a[mid1-1]);
            int r1=((mid1==n) ? Integer.MAX_VALUE : a[mid1]);

            int l2=((mid2==0) ? Integer.MIN_VALUE : b[mid2-1]);
            int r2=((mid2==m) ? Integer.MAX_VALUE : b[mid2]);

            if(l1<=r2 && l2<=r1){
                ele=Math.max(l1, l2);
            }

            if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }

        return ele;
    }

    public static void main(String args[]){
        int a[]={2, 3, 6, 7, 9};
        int b[]={1, 4, 8, 10};
        int k=5;

        int ele1=kthElementBrute(a, b, k);
        System.out.println(ele1);

        int ele2=kthElementBetter(a, b, k);
        System.out.println(ele2);

        int ele3=kthElementOptimal(a, b, k);
        System.out.println(ele3);
    }
}

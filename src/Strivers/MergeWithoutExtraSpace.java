package Strivers;

public class MergeWithoutExtraSpace {
    public static void mergeSortedArraysWithoutExtraSpace(int[] a, int[] b){
        int m=a.length;
        int n=b.length;

        for(int k=0;k<n;k++){
            a[k+m]=b[k];
        }

        int gap=(m+n+1)/2;

        while(gap>0){
            int i=0;
            int j=gap;

            while(j<m+n){
                if(i<m && j<m && a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }else if(i<m && j>=m && a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }else if(i>=m && j>=m && a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
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
}

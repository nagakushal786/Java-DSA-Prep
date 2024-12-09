package GFG_160.Sorting;

public class CountInversionPairs {
    public static int countInvMerge(int[] arr, int l, int m, int r){
        int n1=m-l+1;
        int n2=r-m;

        int[] left=new int[n1];
        int[] right=new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }

        for(int j=0;j<n2;j++){
            right[j]=arr[m+1+j];
        }

        int count=0, i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i+=1;
            }else{
                arr[k]=right[j];
                j+=1;
                count+=(n1-i);
            }
            k+=1;
        }

        while(i<n1){
            arr[k]=left[i];
            i+=1;
            k+=1;
        }

        while(j<n2){
            arr[k]=right[j];
            j+=1;
            k+=1;
        }

        return count;
    }

    public static int countInvPairs(int[] arr, int l, int r){
        int count=0;

        if(l<r){
            int mid=l+(r-l)/2;

            count+=countInvPairs(arr, l, mid);
            count+=countInvPairs(arr, mid+1, r);
            count+=countInvMerge(arr, l, mid, r);
        }

        return count;
    }

    public static void main(String args[]){
        int arr[]={2, 4, 1, 3, 5};
        int invPairs=countInvPairs(arr, 0, arr.length-1);
        System.out.println(invPairs);
    }
}

// Inversion pair: arr[i]>arr[j] and i<j
package GFG_160;

public class NextPermutation {
    public static void reverse(int[] arr, int l, int r){
        while(l<=r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            l+=1;
            r-=1;
        }
    }

    public static void nextPermutation(int[] arr){
        int n=arr.length;
        int pivot=-1;

        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }

        if(pivot==-1){
            reverse(arr, 0, n-1);
            return;
        }

        for(int i=n-1;i>pivot;i--){
            if(arr[i]>arr[pivot]){
                int temp=arr[i];
                arr[i]=arr[pivot];
                arr[pivot]=temp;

                break;
            }
        }

        reverse(arr, pivot+1, n-1);
    }

    public static void main(String args[]){
        int arr[]={2, 4, 1, 7, 5, 0};

        nextPermutation(arr);
        for(int ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
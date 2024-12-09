package GFG_160.Arrays;

public class RotateArray {
    public static int gcd(int a, int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }

        while(b>0){
            a=b;
            b=a%b;
        }

        return a;
    }

    public static void jugglingAlgorithm(int[] arr, int d){
        int n=arr.length;
        d=d%n;
        int cycles=gcd(d, n);

        for(int i=0;i<cycles;i++){
            int startEle=arr[i];
            int currIndex=i;

            while(true){
                int nextIndex=(currIndex+d)%n;

                if(nextIndex==i){
                    break;
                }

                arr[currIndex]=arr[nextIndex];
                currIndex=nextIndex;
            }

            arr[currIndex]=startEle;
        }
    }

    public static void reverseArray(int[] arr, int l, int r){
        while(l<=r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            l+=1;
            r-=1;
        }
    }

    public static void reversalAlgorithm(int[] arr, int d){
        int n=arr.length;
        d=d%n;

        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
    }

    public static void main(String args[]){
        int arr1[]={1, 2, 3, 4, 5, 6};
        int arr2[]={1, 2, 3, 4, 5, 6};
        int d=2;

        jugglingAlgorithm(arr1, d);
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();

        reversalAlgorithm(arr2, d);
        for(int ele: arr2){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
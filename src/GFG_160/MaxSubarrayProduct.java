package GFG_160;

public class MaxSubarrayProduct {
    public static int min(int a, int b, int c){
        if(a<b && a<c){
            return a;
        }else if(b<c){
            return b;
        }else{
            return c;
        }
    }

    public static int max(int a, int b, int c){
        if(a>b && a>c){
            return a;
        }else if(b>c){
            return b;
        }else{
            return c;
        }
    }

    public static int currMinMaxApproach(int[] arr){
        int n=arr.length;

        int currMin=arr[0];
        int currMax=arr[0];
        int maxP=arr[0];

        for(int i=1;i<n;i++){
            int temp=max(arr[i], arr[i]*currMin, arr[i]*currMax);

            currMin=min(arr[i], arr[i]*currMin, arr[i]*currMax);

            currMax=temp;

            maxP=Math.max(maxP, currMax);
        }

        return maxP;
    }

    public static int bothDirectionTraversal(int[] arr){
        int n=arr.length;

        int leftToRight=1;
        int rightToLeft=1;
        int maxP=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(leftToRight==0){
                leftToRight=1;
            }
            if(rightToLeft==0){
                rightToLeft=1;
            }

            leftToRight=leftToRight*arr[i];
            rightToLeft=rightToLeft*arr[n-i-1];

            maxP=max(maxP, leftToRight, rightToLeft);
        }

        return maxP;
    }

    public static void main(String args[]){
        int arr[]={-2, 6, -3, -10, 0, 2};

        int maxProd1=currMinMaxApproach(arr);
        System.out.println(maxProd1);

        int maxProd2=bothDirectionTraversal(arr);
        System.out.println(maxProd2);
    }
}

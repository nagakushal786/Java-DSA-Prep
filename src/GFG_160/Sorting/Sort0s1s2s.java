package GFG_160.Sorting;

public class Sort0s1s2s {
    public static void sort012Better(int[] arr){
        int n=arr.length;
        int c0=0, c1=0, c2=0;

        for(int i=0;i<n;i++){
            if(arr[i]==0){
                c0+=1;
            }else if(arr[i]==1){
                c1+=1;
            }else{
                c2+=1;
            }
        }

        int idx=0;

        for(int i=0;i<c0;i++){
            arr[idx]=0;
            idx+=1;
        }
        for(int i=0;i<c1;i++){
            arr[idx]=1;
            idx+=1;
        }
        for(int i=0;i<c2;i++){
            arr[idx]=2;
            idx+=1;
        }
    }

    public static void dnfAlgorithm(int[] arr){
        int n=arr.length;
        int low=0;
        int mid=0;
        int high=n-1;

        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;

                low+=1;
                mid+=1;
            }else if(arr[mid]==1){
                mid+=1;
            }else{
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;

                high-=1;
            }
        }
    }

    public static void main(String args[]){
        int arr[]={0, 1, 2, 0, 1, 2};

        dnfAlgorithm(arr);
        for(int ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();

        sort012Better(arr);
        for(int ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}

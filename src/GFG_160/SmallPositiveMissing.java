package GFG_160;

public class SmallPositiveMissing {
    public static int visitedArrayMethod(int[] arr){
        int n=arr.length;

        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(arr[i]>0 && arr[i]<=n){
                visited[arr[i]-1]=true;
            }
        }

        for(int i=1;i<n+1;i++){
            if(!visited[i-1]){
                return i;
            }
        }

        return n+1;
    }

    public static int cycleSortApproach(int[] arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            while(arr[i]>=1 && arr[i]<=n && arr[i]!=arr[arr[i]-1]){
                int temp=arr[i];
                arr[i]=arr[arr[i]-1];
                arr[temp-1]=temp;
            }
        }

        for(int i=1;i<n+1;i++){
            if(i!=arr[i-1]){
                return i;
            }
        }

        return n+1;
    }

    public static void main(String args[]){
        int arr[]={2, -3, 4, 1, 1, 7};

        int res1=visitedArrayMethod(arr);
        System.out.println(res1);

        int res2=cycleSortApproach(arr);
        System.out.println(res2);
    }
}

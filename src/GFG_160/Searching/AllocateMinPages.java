package GFG_160.Searching;

public class AllocateMinPages {
    public static int max(int[] arr){
        int n=arr.length;
        int maxEle=arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]>maxEle){
                maxEle=arr[i];
            }
        }

        return maxEle;
    }

    public static int sum(int[] arr){
        int n=arr.length;
        int sumOfEle=0;

        for(int i=0;i<n;i++){
            sumOfEle+=arr[i];
        }

        return sumOfEle;
    }

    public static boolean check(int[] arr, int k, int pageLimit){
        int cnt=1;
        int pageSum=0;

        for(int pages: arr){
            if(pageSum+pages>pageLimit){
                cnt+=1;
                pageSum=pages;
            }else{
                pageSum+=pages;
            }
        }

        if(cnt<=k){
            return true;
        }else{
            return false;
        }
    }

    public static int findPagesBrute(int[] arr, int k){
        int n=arr.length;

        if(k>n){
            return -1;
        }

        int minPages=max(arr);
        int maxPages=sum(arr);

        for(int i=minPages;i<=maxPages;i++){
            if(check(arr, k, i)){
                return i;
            }
        }

        return -1;
    }

    public static int findPagesOptimal(int[] arr, int k){
        int n=arr.length;
        int res=-1;

        if(k>n){
            return -1;
        }

        int low=max(arr);
        int high=sum(arr);

        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(arr, k, mid)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int arr[]={12, 34, 67, 90};
        int k=2;

        int minInMaxPagesAllocated1=findPagesBrute(arr, k);
        System.out.println(minInMaxPagesAllocated1);

        int minInMaxPagesAllocated2=findPagesOptimal(arr, k);
        System.out.println(minInMaxPagesAllocated2);
    }
}
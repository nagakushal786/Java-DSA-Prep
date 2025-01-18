package GFG_160.PrefixSum;

public class EquilibriumPoint {
    public static int sum(int[] arr){
        int res=0;
        
        for(int i=0;i<arr.length;i++){
            res+=arr[i];
        }
        
        return res;
    }

    public static int equilibriumPoint(int[] arr){
        int n=arr.length;
        int totalSum=sum(arr);
        int ls=0;
        
        for(int i=0;i<n;i++){
            totalSum-=arr[i];
            
            if(ls==totalSum){
                return i;
            }
            
            ls+=arr[i];
        }
        
        return -1;
    }

    public static void main(String[] args){
        int arr[]={-7, 1, 5, 2, -4, 3, 0};

        int eqPoint=equilibriumPoint(arr);
        System.out.println(eqPoint);
    }
}

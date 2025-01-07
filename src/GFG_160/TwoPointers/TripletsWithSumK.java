package GFG_160.TwoPointers;

public class TripletsWithSumK {
    public static int tripletsWithSumKBrute(int[] arr, int target){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==target){
                        count+=1;
                    }
                }
            }
        }

        return count;
    }

    public static int tripletsWithSumKOptimal(int[] arr, int target){
        int n=arr.length;
        int ans=0;
        
        for(int i=0;i<n;i++){
            int low=i+1, high=n-1;
            
            while(low<high){
                int currSum=arr[i]+arr[low]+arr[high];
                
                if(currSum==target){
                    int e1=arr[low], e2=arr[high], c1=0, c2=0;
                    
                    while(low<=high && arr[low]==e1){
                        c1+=1;
                        low+=1;
                    }
                    
                    while(low<=high && arr[high]==e2){
                        c2+=1;
                        high-=1;
                    }
                    
                    if(e1==e2){
                        ans+=(c1*(c1-1))/2;
                    }else{
                        ans+=(c1*c2);
                    }
                }else if(currSum<target){
                    low+=1;
                }else{
                    high-=1;
                }
            }
        }
        
        return ans;
    }

    public static void main(String[] args){
        int arr[]={-3, -1, -1, 0, 1, 2};
        int target=-2;

        int count1=tripletsWithSumKBrute(arr, target);
        System.out.println(count1);

        int count2=tripletsWithSumKOptimal(arr, target);
        System.out.println(count2);
    }
}

// i<j<k and sorted array
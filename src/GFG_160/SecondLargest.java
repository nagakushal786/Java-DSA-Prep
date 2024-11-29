package GFG_160;

public class SecondLargest {
    public static int secondLargest(int[] arr){
        int largest=arr[0];
        int slargest=-1;
        int n=arr.length;

        if(n<2){
            return slargest;
        }

        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }else if(arr[i]>slargest && arr[i]!=largest){
                slargest=arr[i];
            }
        }

        return slargest;
    }

    public static void main(String args[]){
        int arr[]={10, 10, 10};
        int slargest=secondLargest(arr);
        System.out.println(slargest);
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
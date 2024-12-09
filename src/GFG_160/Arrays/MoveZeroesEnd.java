package GFG_160.Arrays;

public class MoveZeroesEnd {
    public static void moveZeroesEnd1(int[] arr){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count+=1;
            }
        }

        while(count<n){
            arr[count]=0;
            count+=1;
        }
    }

    public static void moveZeroesEnd2(int[] arr){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[count];
                arr[count]=temp;

                count+=1;
            }
        }
    }

    public static void main(String args[]){
        int arr1[]={1, 2, 0, 4, 3, 0, 5, 0};
        int arr2[]={0, 0, 4, 3, 0};

        moveZeroesEnd1(arr1);
        System.out.print("Approach1: ");
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();

        moveZeroesEnd2(arr2);
        System.out.print("Approach2: ");
        for(int ele: arr2){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}

// App1 Time complexity: O(2n)
// App1 Space complexity: O(1)

// App2 Time complexity: O(n)
// App2 Space complexity: O(1)
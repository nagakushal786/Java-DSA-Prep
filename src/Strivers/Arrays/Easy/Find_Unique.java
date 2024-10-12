package Strivers.Arrays.Easy;
import java.util.*;

public class Find_Unique {
    public static int find_unique_brute(int[] arr, int n){
        int unique=-1;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[j]==arr[i]){
                    count+=1;
                }
            }

            if(count==1){
                unique=arr[i];
            }
        }

        return unique;
    }

    public static int find_unique_better(int[] arr, int n){
        HashMap<Integer, Integer> map=new HashMap<>();
        int unique=-1;

        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(int i=0;i<n;i++){
            if(map.get(arr[i])==1){
                unique=arr[i];
            }
        }

        return unique;
    }

    public static int find_unique_optimal(int[] arr, int n){
        int xor=0;
        for(int i=0;i<n;i++){
            xor=xor^arr[i];
        }

        return xor;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]={1, 1, 2, 3, 3, 4, 4};
        int n=arr.length;

        int choice=sc.nextInt();
        switch(choice){
            case 1: System.out.println("Brute method: "+find_unique_brute(arr, n)); break;
            case 2: System.out.println("Better method: "+find_unique_better(arr, n)); break;
            case 3: System.out.println("Optimal method: "+find_unique_optimal(arr, n)); break;
            default: System.out.println("Choose valid choice");
        }

        sc.close();
    }
}

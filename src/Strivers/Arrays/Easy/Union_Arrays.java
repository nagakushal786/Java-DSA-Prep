package Strivers.Arrays.Easy;
import java.util.*;

public class Union_Arrays {
    public static ArrayList<Integer> union_arrays_brute(int[] arr1, int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<n1;i++){
            set.add(arr1[i]);
        }

        for(int i=0;i<n2;i++){
            set.add(arr2[i]);
        }

        ArrayList<Integer> union=new ArrayList<>();
        for(int item: set){
            union.add(item);
        }

        return union;
    }

    public static ArrayList<Integer> union_arrays_optimal(int[] arr1, int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        ArrayList<Integer> union=new ArrayList<>();

        int i=0, j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(union.size()==0 || union.get(union.size()-1)!=arr1[i]){
                    union.add(arr1[i]); 
                }
                i+=1;
            }else{
                if(union.size()==0 || union.get(union.size()-1)!=arr2[j]){
                    union.add(arr2[j]);
                }
                j+=1;
            }
        }

        while(i<n1){
            if(union.size()==0 || union.get(union.size()-1)!=arr1[i]){
                union.add(arr1[i]);
            }
            i+=1;
        }

        while(j<n2){
            if(union.size()==0 || union.get(union.size()-1)!=arr2[j]){
                union.add(arr2[j]);
            }
            j+=1;
        }

        return union;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int[] a1=new int[n1];
        int[] a2=new int[n2];

        for(int i=0;i<n1;i++){
            int temp=sc.nextInt();
            a1[i]=temp;
        }

        for(int i=0;i<n2;i++){
            int temp=sc.nextInt();
            a2[i]=temp;
        }

        ArrayList<Integer> union1=new ArrayList<>();
        ArrayList<Integer> union2=new ArrayList<>();

        union1=union_arrays_brute(a1, a2);
        union2=union_arrays_optimal(a1, a2);

        System.out.println("Brute: "+union1);
        System.out.println("Optimal: "+union2);

        sc.close();
    }
}

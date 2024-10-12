package Strivers.Arrays.Easy;
import java.util.*;

public class Intersection_Arrays {
    public static ArrayList<Integer> intersection_arrays_brute(int[] a, int[] b){
        int n1=a.length;
        int n2=b.length;
        int[] visited=new int[n2];
        for(int i=0;i<n2;i++){
            visited[i]=0;
        }

        ArrayList<Integer> intersection=new ArrayList<>();

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(a[i]==b[j] && visited[j]==0){
                    intersection.add(a[i]);
                    visited[j]=1;
                    break;
                }

                if(b[j]>a[i]){
                    break;
                }
            }
        }

        return intersection;
    }

    public static ArrayList<Integer> intersection_arrays_optimal(int[] a, int[] b){
        int n1=a.length;
        int n2=b.length;
        ArrayList<Integer> intersection=new ArrayList<>();

        int i=0, j=0;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                i+=1;
            }else if(b[j]<a[i]){
                j+=1;
            }else{
                intersection.add(a[i]);
                i+=1;
                j+=1;
            }
        }

        return intersection;
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

        ArrayList<Integer> intersection1=new ArrayList<>();
        ArrayList<Integer> intersection2=new ArrayList<>();

        intersection1=intersection_arrays_brute(a1, a2);
        intersection2=intersection_arrays_optimal(a1, a2);

        System.out.println("Brute: "+intersection1);
        System.out.println("Optimal: "+intersection2);

        sc.close();
    }
}

package Strivers.Basic_Hashing;
import java.util.*;

public class Highest_Frequency {
    public static int highest_freq(int[] arr){
        HashMap<Integer, Integer> freq_map=new HashMap<>();

        for(int item:arr){
            freq_map.put(item, freq_map.getOrDefault(item, 0)+1);
        }

        int max_freq=-1;
        int max_freq_element=-1;

        for(int key:freq_map.keySet()){
            if(freq_map.get(key)>max_freq){
                max_freq=freq_map.get(key);
                max_freq_element=key;
            }
        }

        return max_freq_element;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            arr[i]=temp;
        }

        int high_freq_number=highest_freq(arr);
        System.out.println(high_freq_number);
        sc.close();
    }
}

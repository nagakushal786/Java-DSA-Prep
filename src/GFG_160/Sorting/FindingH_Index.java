package GFG_160.Sorting;

public class FindingH_Index {
    public static int countSortApproach(int[] citations){
        int n=citations.length;

        int[] freq=new int[n+1];
        for(int citation: citations){
            if(citation>=n){
                freq[n]+=1;
            }else{
                freq[citation]+=1;
            }
        }

        int idx=n;
        int s=freq[idx];

        while(s<idx){
            idx-=1;
            s+=freq[idx];
        }

        return idx;
    }

    public static void main(String args[]){
        int citations[]={6, 0, 3, 5, 3};
        int hIndex=countSortApproach(citations);
        System.out.println(hIndex);
    }
}

// h-index: atleast h papers citated atleast h times
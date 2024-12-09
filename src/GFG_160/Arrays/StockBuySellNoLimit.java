package GFG_160.Arrays;

public class StockBuySellNoLimit {
    public static int stockBuySellRec(int[] prices, int start, int end){
        int res=0;

        for(int i=start;i<end;i++){
            for(int j=i+1;j<end+1;j++){
                if(prices[j]>prices[i]){
                    int curr=(prices[j]-prices[i])+
                        stockBuySellRec(prices, start, i-1)+
                        stockBuySellRec(prices, j+1, end);

                    res=Math.max(res, curr);
                }
            }
        }

        return res;
    }

    public static int stockBuySellBrute(int[] prices){
        int n=prices.length;
        return stockBuySellRec(prices, 0, n-1);
    }

    public static int localMinMax(int[] prices){
        int n=prices.length;
        int lmin=prices[0];
        int lmax=prices[1];
        int profit=0;

        int i=0;
        while(i<n-1){
            while(i<n-1 && prices[i]>=prices[i+1]){
                i+=1;
            }
            lmin=prices[i];

            while(i<n-1 && prices[i]<=prices[i+1]){
                i+=1;
            }
            lmax=prices[i];

            profit+=(lmax-lmin);
        }

        return profit;
    }

    public static int accumulateProfit(int[] prices){
        int n=prices.length;
        int profit=0;

        for(int i=0;i<n-1;i++){
            if(prices[i]<=prices[i+1]){
                profit+=(prices[i+1]-prices[i]);
            }
        }

        return profit;
    }

    public static void main(String args[]){
        int prices[]={100, 180, 260, 310, 40, 535, 695};
        int res1=stockBuySellBrute(prices);
        System.out.println(res1);

        int res2=localMinMax(prices);
        System.out.println(res2);

        int res3=accumulateProfit(prices);
        System.out.println(res3);
    }
}

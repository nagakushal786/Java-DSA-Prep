package GFG_160;

public class StockBuySellLimit {
    public static int stockBuySellLimit(int[] prices){
        int minSoFar=prices[0];
        int profit=0;
        int n=prices.length;

        for(int i=1;i<n;i++){
            minSoFar=Math.min(minSoFar, prices[i]);

            profit=Math.max(profit, prices[i]-minSoFar);
        }

        return profit;
    }

    public static void main(String args[]){
        int prices[]={7, 10, 1, 3, 6, 9, 2};
        int profit=stockBuySellLimit(prices);
        System.out.println(profit);
    }
}

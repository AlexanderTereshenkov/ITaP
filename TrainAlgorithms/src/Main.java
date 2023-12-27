import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minBuyValue){
                minBuyValue = prices[i];
            }
            if(prices[i] - minBuyValue > maxProfit){
                maxProfit = prices[i] - minBuyValue;
            }
        }
        return maxProfit;
    }
}
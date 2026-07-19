// Problem 1: Best Time to Buy and Sell Stock
// Given an array where each element is a stock price on that day, find the maximum profit
//  from a single buy-sell transaction (buy before you sell).
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5
// (buy at 1, sell at 6)


//Brute force
public class Problem1 {
    public static int buySellBriteForce(int[] arr) {
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int Profit = arr[j] - arr[i];
                if (Profit > maxProfit) {
                    maxProfit = Profit;
                }
            }
        }
        return maxProfit;
    }

    //One-Pass / Greedy approach

    public static int maxProfit(int[] prices) {

    int minPrice = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {

        // Find the minimum buying price
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        }

        // Calculate profit if we sell today
        int profit = prices[i] - minPrice;

        // Update maximum profit
        if (profit > maxProfit) {
            maxProfit = profit;
        }
    }

    return maxProfit;
}

    public static void main(String[] args) {

    }
}

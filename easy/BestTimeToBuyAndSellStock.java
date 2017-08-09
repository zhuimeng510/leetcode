package easy;
/*
 * 题目描述

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1) {
			return 0;
		}
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
        	//更新最小值，当前取得最大收益时，只可能与前面最小值减
			if (prices[i]<min) {
				min = prices[i];
			}
			//更新收益
			if (prices[i]-min>profit) {
				profit = prices[i]-min;
			}
		}
        return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,4,1,5,7,6};
		System.out.println(maxProfit(prices));
	}

}

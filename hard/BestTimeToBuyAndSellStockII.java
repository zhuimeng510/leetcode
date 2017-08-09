package hard;
/*
 * 题目描述

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
	//波谷买进，波峰卖出收益最大
	public static int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1) {
			return 0;
		}
        int[] profit = new int[prices.length];
        int result = 0;
        for (int i = 1; i < profit.length; i++) {
			profit[i] = prices[i]-prices[i-1];
			if (profit[i]>0) {
				result+=profit[i];
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,4,1,5,7,6};
		System.out.println(maxProfit(prices));
	}

}

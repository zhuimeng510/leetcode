package hard;
/*
 * 
��Ŀ����

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
	
	public static int maxProfit(int[] prices) {
		if (prices==null || prices.length<=1) {
			return 0;
		}
		int len = prices.length;//�ܳ���
		int[] preProfit = new int[len];
		int[] postProfit = new int[len];
        //��ǰ������õ�֮ǰ(������ǰ�ڵ�)���������
		int min = prices[0];//�õ�ǰ��Сֵ				
		for (int i = 1; i < len; i++) {
			//ֱ����ǰ����Сֵ
			if (prices[i]<min) {
				min = prices[i];
			}
			//��ǰ�ڵ�ǰ���������
			if (prices[i]-min>preProfit[i-1]) {
				preProfit[i]=prices[i]-min;
			}else {
				preProfit[i]=preProfit[i-1];
			}
		}
		//�Ӻ���ǰ����ýڵ�֮��(��������ǰ�ڵ�)���������
		int totalProfit = preProfit[len-1];//�ܵ��������
		int max = prices[len-1];//��¼��ǰ���ֵ
		for (int i = len-2; i >= 0; i--) {
			if (prices[i+1]>max) {
				max = prices[i+1];
			}
			if (max-prices[i+1]>postProfit[i+1]) {
				postProfit[i] = max-prices[i+1];
			}else {
				postProfit[i] = postProfit[i+1];
			}
			if (postProfit[i]+preProfit[i]>totalProfit) {
				totalProfit = postProfit[i]+preProfit[i];//�������ֵ
			}
		}
		return totalProfit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,1};
		//int[] prices = {2,4,1,5,7,6,8};
		System.out.println(maxProfit(prices));
	}

}

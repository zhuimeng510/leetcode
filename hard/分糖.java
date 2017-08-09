package hard;

import java.util.Arrays;

/*
 * There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class 分糖 {

	public int candy(int[] ratings) {
		if (ratings==null || ratings.length==0) {
			return 0;
		}
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        //从左到右扫描，使得单增区间满足要求
        for (int i = 1; i < count.length; i++) {
			if (ratings[i]>ratings[i-1]) {
				count[i]= count[i-1]+1;
			}
		}
        int sum = count[ratings.length-1];//存总糖果数
        for (int i = count.length-2; i >=0; i--) {
			if (ratings[i]>ratings[i+1] && count[i]<=count[i+1]) {
				count[i] = count[i+1]+1;
			}
			sum+=count[i];
		}
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {7,4,2,8,7};
		System.out.println(new 分糖().candy(ratings));
	}

}

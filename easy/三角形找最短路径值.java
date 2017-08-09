package easy;

import java.util.ArrayList;

/*
 * 题目描述

Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
Note: 
Bonus point if you are able to do this using only O(n) extra space,
 where n is the total number of rows in the triangle.
 */
public class 三角形找最短路径值 {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int hight = triangle.size();
        if (hight==1) {
			return triangle.get(0).get(0);
		}
        int[] res = new int[hight];
        ArrayList<Integer> lastLine = triangle.get(hight-1);
        for (int i = 0; i < res.length; i++) {
			res[i] = lastLine.get(i);
		}
        for (int i = hight-2; i >=0; i--) { 	
        	ArrayList<Integer> curLine = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				res[j] = res[j]<res[j+1]?res[j]+curLine.get(j):res[j+1]+curLine.get(j);
			}
		}
        return res[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

package easy;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 题目描述

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class 三数和 {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return res;
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            if(num[i] > 0) break;//必须加剪枝，否则会超时。。    
            for(int j=i+1;j<num.length;j++){
                if((num[i] + num[j])>0) break;//必须加剪枝，否则会超时。。       
                int k = 0-num[i]-num[j];
                int pos = -1;
                if((pos = Arrays.binarySearch(num, j+1, num.length, k)) > 0){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[pos]);
                        if(!res.contains(tmp))
                            res.add(tmp);
                }
            }
        }  
        return res;    
    }
	/*public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		if (num==null || num.length<3) {
			return null;
		}
		Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= num.length-3; i++) {  
			if (num[i]>0) {//最小的已大于0就没必要比下去了,剪枝
				break;
			}										
			if (i==0 || num[i]!=num[i-1]) {//新进行去重	
				for (int j = i+1; j <= num.length-2; j++) {					
					
					if (num[i]+num[j]>0) {//剪枝
						break;
					}
					//利用二分查找
					int target = 0-num[i]-num[j];//目标值
					int findPos = Arrays.binarySearch(num, j+1, num.length, target);
					if(findPos>j){//找到目标
						ArrayList<Integer> subArrayList = new ArrayList<Integer>();
						subArrayList.add(num[i]);
						subArrayList.add(num[j]);
						subArrayList.add(num[findPos]);
						
						list.add(subArrayList);
					}
				}
			}
	
		}
        return list;
    }*/
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(num));
	}

}

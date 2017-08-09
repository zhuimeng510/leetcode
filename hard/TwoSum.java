package hard;

import java.util.HashMap;

/*
 * 题目描述

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {

	//方法一：使用HashMap
	public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//(值，对应下标)
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i+1);
		}
        for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target-numbers[i]) && map.get(target-numbers[i])!=i+1) {//有对应数且不是自身
				result[0] = i+1;
				result[1] = map.get(target-numbers[i]);
				break;
			}
		}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers={2, 7, 11, 15};
		int[] result = twoSum(numbers,9);
		System.out.println(result[0]+" "+result[1]);
	}

}

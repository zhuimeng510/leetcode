package easy;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 题目描述

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
Your algorithm should run in O(n) complexity.
 */
public class 最长连续序列 {
	//方法一：复杂度o(nlogn)	
	/*public int longestConsecutive(int[] num) {
		if (num==null || num.length==0) {
			return 0;
		}
        Arrays.sort(num);
        int maxLength = 1;
        int count = 1;
        for (int i = 1; i < num.length; i++) {
			if (num[i]==num[i-1]+1) {
				count++;
			}else if (num[i]==num[i-1]) {
				continue;
			}else{				
				count = 1;
			}
			maxLength = count>maxLength?count:maxLength;
		}
        return maxLength;
    }*/
	//方法二：使用HashSet，复杂度主要在于遍历数组中元素
	public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        //加入元素，同时可以去重,o(n)
        for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
        //从每一个元素往两边走，连续的都去除掉，这样访问完一遍后所有元素就都删光了，复杂度o(n)
        int maxLength = 1;
        for (int i = 0; i < num.length; i++) {
        	int count = 1;
			if (!set.isEmpty() && set.remove(num[i])) {//如可以移除此元素，证明还存在于set中
				int down = num[i]-1;
				int up = num[i]+1;
				while (set.remove(down)) {
					count++;
					down--;
				}
				while (set.remove(up)) {
					count++;		
					up++;
				}
				maxLength = count>maxLength?count:maxLength;
			}
		}
        return maxLength;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] num = {1,0,1,2};
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(new 最长连续序列().longestConsecutive(num));
	}

}

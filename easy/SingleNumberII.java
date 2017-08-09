package easy;
/*
 * 题目描述

Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {

	public static int singleNumber(int[] A) {
		/*//写法一：
	     int one=0,two=0;//为1的位分别表示相应位出现了1次，2次
	     int three=0;//用来逢3清0
	     for (int i = 0; i < A.length; i++) {
			int cur = A[i];//逐个数值遍历
			three = two & cur;//出现三次的位
			two &= ~three; //出现三次的位清0
			cur &= ~three; //出现三次的位置防止算为出现一次(one分不清是没出现过还是出现了2次)
			two |= one & cur;//更新出现两次的
			one ^=cur;//更新出现一次的
		 }
	     return one;*/
		//写法二：
		/*
		 * Single Number的本质，就是用一个数记录每个bit出现的次数，如果一个bit出现两次就归0，
		 * 这种运算采用二进制底下的位操作^是很自然的。Single Number II中，如果能定义三进制底下的某种位操作，
		 * 也可以达到相同的效果，Single Number II中想要记录每个bit出现的次数，一个数搞不定就加两个数，
		 * 用ones来记录只出现过一次的bits，用twos来记录只出现过两次的bits，ones&twos实际上就记录了出现过三次的bits，
		 * 这时候我们来模拟进行出现3次就抵消为0的操作，抹去ones和twos中都为1的bits。
		 */
		int one=0,two=0;//为1的位分别表示相应位出现了1次，2次
	    int three=0;//用来逢3清0
	    for (int i = 0; i < A.length; i++) {
			int cur = A[i];//逐个数值遍历
			two |= one & cur;//(1)原来出现了一次，现在又出现一次(2)原来出现两次
			one ^= cur;//原来没有出现过，或是出现过两次，cur中本次出现一次[奇数次都不为0]
			three = two & one;//出现过了三次
			two &= ~three;
			one &= ~three;//清空出现三次的位
	    }
	    return one;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,5,2,3,5,5,3};
		System.out.println(singleNumber(A));
	}

}

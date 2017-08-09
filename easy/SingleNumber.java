package easy;
/*
 * ��Ŀ����

Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

	public int singleNumber(int[] A) {
	     int result = 0;
	     for (int i = 0; i < A.length; i++) {
			result ^=A[i];
		}
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package easy;
/*
 * Given an array of non-negative integers, you are initially positioned at 
 * the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A =[2,3,1,1,4], returntrue.
A =[3,2,1,0,4], returnfalse.

 */
public class 跳跃游戏 {
	//方法一：递归
	/*public static boolean canJump(int[] A,int inx){
		boolean flag = false;
		for (int i = A[inx]; i >0 ; i--) {
			if (i+inx>=A.length-1) {
				return true;
			}
			if (A[i+inx]==0) {
				continue;
			}
			flag = flag||canJump(A,inx+i);
			if (flag) {
				return true;
			}
		}
		return flag;
		
	}
	public static boolean canJump(int[] A) {
        if (A.length<=1) return true;
        return canJump(A,0);
    }*/
	//方法二：贪心
	public static boolean canJump(int[] A) {
        if (A==null || A.length<=1) return true;
        int fastest = A[0];
        for (int i = 0; i <= fastest; i++) {
			if (A[i]+i>=A.length-1) {
				return true;
			}
			fastest = A[i]+i>fastest?A[i]+i:fastest;
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {2,3,1,1,4};
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}

}

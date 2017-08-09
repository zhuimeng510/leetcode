package easy;

public class 跳跃游戏2 {
	
	//方法一：暴力法超时
	/*public static int jump(int[] A,int index) {
		int minStep = Integer.MAX_VALUE;
		for (int i = A[index]; i >0 ; i--) {
			if (index+i>=A.length-1) {
				return 1;
			}
			if (A[i+index]==0) {
				continue;
			}
			int step = 1+jump(A,index+i);
			minStep = step<minStep?step:minStep;
		}
		return minStep;
	}
	public static int jump(int[] A) {
        if (A==null || A.length<=1)return 0;
        return jump(A,0);
    }*/
	//方法二
	public static int jump(int[] A) {
		int lastFarst = 0;//上一轮最远
		int curFarest = 0;//本轮可跳的最远位置
		int jump = 0;
		//i记录当前位置
        for (int i = 0; i < A.length; i++) {
        	//超出了上一步的有效范围
			if (i>lastFarst) {
				jump++;
				lastFarst = curFarest;
			}
			if (i>curFarest) {//证明有0跳不过去
				return -1;
			}
			curFarest = A[i]+i>curFarest?A[i]+i:curFarest;//当前可跳至最远处
			
		}
        if (lastFarst>=A.length-1) {
			return jump;
		}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {2,3,1,1,4};
		int[] A = {3,2,1,0,4,7,5,7};
		System.out.println(jump(A));
	}

}

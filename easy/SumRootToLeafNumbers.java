package easy;
/*
 * 题目描述

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path1->2->3which represents the number123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.
Return the sum = 12 + 13 =25.
 */
public class SumRootToLeafNumbers {
	private int sum = 0;//输出总和
	private int curVal = 0;//当前值
	public int sumNumbers(TreeNode root) {
        if (root == null) {
			return 0;
		}
        curVal = curVal*10+root.val;//刚进入某节点
        if (root.left!=null)  sumNumbers(root.left);//遍历左子树
        if (root.right!=null) sumNumbers(root.right);//遍历右子树
        if (root.left==null && root.right==null) {//左右子树均为空，即叶子
        	sum+=curVal;
		}
        curVal = (curVal-root.val)/10;//离开某节点
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package easy;
/*
 * 题目描述

Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and 
the nodes have the same value.
 */
public class 相同树 {

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null &&q==null ) {
			return true;
		}else if ((p==null&&q!=null) || (p!=null&&q==null) || p.val!=q.val) {
			return false;
		}else {
			return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

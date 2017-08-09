package easy;
/*
 * 题目描述

Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.

 */
public class PathSum {
	int curSum = 0;
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
        	return false;
        }
       boolean left = false;
       boolean right = false;
       curSum+=root.val;
       
       if (root.left!=null) {
    	   left = hasPathSum(root.left, sum);    	   
       }
       if (root.right!=null) {
    	   right = hasPathSum(root.right, sum);    	   
       }
       if (root.left==null && root.right==null) {//叶子节点
    	   if (curSum==sum) {//找到和为sum的路径
    		   return true;
    	   }
       }
       
	   curSum-=root.val;//返回到上一层
	   
       if (left || right) {
    	   return true;
       }
       return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

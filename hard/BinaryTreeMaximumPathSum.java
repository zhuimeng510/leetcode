package hard;
/*
 * 题目描述

Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3

Return6.

 */
public class BinaryTreeMaximumPathSum {	
	/*方法一：进军硅谷
	 * public int maxPathSum(TreeNode root) {
        if (root==null) {
			return 0;		
		}
        if (root.left==null && root.right==null) {//左右都为空
			return root.val;
		}
        int endCur = maxPathSumToCur(root);//以当前节点为尾
        int leftTree = Integer.MIN_VALUE;
        if (root.left!=null) {
        	leftTree = maxPathSum(root.left);//左子树
		}
        int rightTree = Integer.MIN_VALUE;
        if (root.right!=null) {
        	rightTree = maxPathSum(root.right);//右子树
		}         
        int leftCurRight = Integer.MIN_VALUE; 
        if(root.left!=null && root.right!=null){
        	leftCurRight = maxPathSumToCur(root.left)+maxPathSumToCur(root.right)+root.val;//左+根+右
        }
       
        int ans = endCur>leftTree?endCur:leftTree;
        ans = ans>rightTree?ans:rightTree;
        ans = ans>leftCurRight?ans:leftCurRight;
        return ans;
    }
	//以当前节点为尾节点的最大路径
	public int maxPathSumToCur(TreeNode root) {
	    if (root==null) {
			return 0;
		}
	    if (root.left==null && root.right==null) {
			return root.val;
		}
	    int left = Integer.MIN_VALUE;
	    int right = Integer.MIN_VALUE;
	    if (root.left!=null) {
	    	left = maxPathSumToCur(root.left)+root.val;
		}
	    if (root.right!=null) {
	    	right = maxPathSumToCur(root.right)+root.val;
		}		    
	    int ans = left>right?left:right;
	    return ans>root.val?ans:root.val;	    
	}*/
	//方法二：
	/*
	 * 思路:

	首先我们分析一下对于指定某个节点为根时，最大的路径和有可能是哪些情况:
	第一种是左子树的路径加上当前节点，
	第二种是右子树的路径加上当前节点，
	第三种是左右子树的路径加上当前节点（相当于一条横跨当前节点的路径），
	第四种是只有自己的路径。
	
	乍一看似乎以此为条件进行自下而上递归就行了，然而这四种情况只是
	用来计算以当前节点根的最大路径，如果当前节点上面还有节点，
	那它的父节点是不能累加第三种情况的。所以我们要计算两个最大值，
	一个是当前节点下最大路径和，另一个是如果要连接父节点时最大的路径和。
	我们用前者更新全局最大量，用后者返回递归值就行了。
	 */
	int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;    
    }
    private int maxPathDown(TreeNode node){
        if(node==null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
	public static void main(String[] args) {
		TreeNode treeNode0 = new TreeNode(-1);
		TreeNode treeNode1 = new TreeNode(-2);
		TreeNode treeNode2 = new TreeNode(7);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(9);
		treeNode0.left = treeNode1;
		treeNode0.right = treeNode2;
		treeNode1.left = treeNode3;
		treeNode1.right = treeNode4;
		treeNode2.right = treeNode5;
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(treeNode0));
	}

}

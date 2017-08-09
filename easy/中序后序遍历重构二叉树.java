package easy;
/*
 * 题目描述

Given inorder and postorder traversal of a tree, construct the binary tree.
Note: 
You may assume that duplicates do not exist in the tree.
 */
public class 中序后序遍历重构二叉树 {
	public TreeNode buildTree(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd) {
		if (inStart>inEnd || postStart>postEnd) {
			return null;
		}
		int rootVal = postorder[postEnd];
		TreeNode rootNode = new TreeNode(rootVal);
		int i = inStart;
		for (; i <= inEnd; i++) {
			if (inorder[i]==rootVal) {
				break;
			}
		}	
		rootNode.left = buildTree(inorder,inStart,i-1, postorder, postStart,postStart+i-inStart-1);
		rootNode.right = buildTree(inorder,i+1,inEnd, postorder,postStart+i-inStart,postEnd-1);
		return rootNode;
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    if (inorder==null || inorder.length==0 || postorder==null || postorder.length==0) {
			return null;
		} 
	    return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

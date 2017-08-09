package easy;
/*
 * 题目描述

Given preorder and inorder traversal of a tree, construct the binary tree.
Note: 
You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd) {
		if (preStart>preEnd || inStart>inEnd) {
			return null;
		}
		int rootVal = preorder[preStart];
		TreeNode rootNode = new TreeNode(rootVal);
		int i = inStart;
		for (; i <= inEnd; i++) {
			if (inorder[i]==rootVal) {//中序遍历中找到根
				break;
			}
		}
		rootNode.left = buildTree(preorder,preStart+1,preStart+i-inStart, inorder,inStart,i-1);
		rootNode.right = buildTree(preorder,preStart+i-inStart+1,preEnd, inorder,i+1,inEnd);
		return rootNode;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder==null || inorder==null ||preorder.length==0 || inorder.length==0) {
			return null;
		}
        return buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

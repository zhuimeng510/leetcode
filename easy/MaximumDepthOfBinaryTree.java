package easy;
/*
 * ��Ŀ����

Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path 
from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
        if (root == null) {
			return 0;
		}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left>right?left+1:right+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

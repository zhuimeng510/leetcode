package hard;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 题目描述

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.
confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */
public class SymmetricTree {
	/*///////////////////////////////////////////////
	//方法一：递归
	public boolean isSymmetric(TreeNode leftNode,TreeNode rightNode) {
        if (leftNode==null && rightNode==null) {//左右节点同时为空
			return true;
		}
        if ((leftNode==null && rightNode!=null) || (leftNode!=null && rightNode==null)) {//一边为空
			return false;
		}
        if (leftNode.val==rightNode.val && isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left)) {
			return true;
		}
        return false;
    }
	public boolean isSymmetric(TreeNode root) {
        if (root==null || (root.left==null&&root.right==null)) {
			return true;
		}
        return isSymmetric(root.left, root.right);
    }
	///////////////////////////////////////////////
*/	
	public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left==null && root.right==null) {
			return true;
		}
        Queue<TreeNode> leftQueue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> rightQueue = new ArrayDeque<TreeNode>();
        if (root.left!=null && root.right!=null) {
        	leftQueue.add(root.left);
        	rightQueue.add(root.right);
        	while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
        		//出队一对对称节点
				TreeNode leftNode = leftQueue.poll();
				TreeNode rightNode = rightQueue.poll();
				if (leftNode.val!=rightNode.val) {//对称节点值不同
					return false;
				}
				if (leftNode.left!=null&&rightNode.right==null || leftNode.left==null&&rightNode.right!=null) {//外侧数目不对称
					return false;
				}
				if (leftNode.left!=null && rightNode.right!=null) {//对称位置都不为空时入队
					leftQueue.add(leftNode.left);
					rightQueue.add(rightNode.right);
				}
				if (leftNode.right!=null&&rightNode.left==null || leftNode.right==null&&rightNode.left!=null) {//内侧数目不对称
					return false;
				}
				if (leftNode.right!=null && rightNode.left!=null) {//对称位置都不为空时入队
					leftQueue.add(leftNode.right);
					rightQueue.add(rightNode.left);
				}				
			}
        	return true;
		}else {
			return false;
		}
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

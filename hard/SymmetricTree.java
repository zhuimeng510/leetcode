package hard;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * ��Ŀ����

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
	//����һ���ݹ�
	public boolean isSymmetric(TreeNode leftNode,TreeNode rightNode) {
        if (leftNode==null && rightNode==null) {//���ҽڵ�ͬʱΪ��
			return true;
		}
        if ((leftNode==null && rightNode!=null) || (leftNode!=null && rightNode==null)) {//һ��Ϊ��
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
        		//����һ�ԶԳƽڵ�
				TreeNode leftNode = leftQueue.poll();
				TreeNode rightNode = rightQueue.poll();
				if (leftNode.val!=rightNode.val) {//�Գƽڵ�ֵ��ͬ
					return false;
				}
				if (leftNode.left!=null&&rightNode.right==null || leftNode.left==null&&rightNode.right!=null) {//�����Ŀ���Գ�
					return false;
				}
				if (leftNode.left!=null && rightNode.right!=null) {//�Գ�λ�ö���Ϊ��ʱ���
					leftQueue.add(leftNode.left);
					rightQueue.add(rightNode.right);
				}
				if (leftNode.right!=null&&rightNode.left==null || leftNode.right==null&&rightNode.left!=null) {//�ڲ���Ŀ���Գ�
					return false;
				}
				if (leftNode.right!=null && rightNode.left!=null) {//�Գ�λ�ö���Ϊ��ʱ���
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

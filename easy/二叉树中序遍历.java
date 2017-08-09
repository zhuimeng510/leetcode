package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


/*
 * 题目描述

Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3

return[1,3,2].
Note: Recursive solution is trivial, could you do it iteratively?
confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal,
 where '#' signifies a path terminator where no node exists below.
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
public class 二叉树中序遍历 {
	//方法一：递归
	/*ArrayList<Integer> res = new ArrayList<Integer>();
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root!=null) {
        	inorderTraversal(root.left);
			res.add(root.val);
			inorderTraversal(root.right);
		}
        return res;
    }*/
	//方法二：循环
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root==null) return res;
		stack.push(root);
		TreeNode cur = root.left;
		while (!stack.isEmpty() || cur!=null) {
			if (cur!=null) {
				stack.push(cur);
				cur = cur.left;
			}else {
				TreeNode outNode = stack.pop();
				res.add(outNode.val);
				cur = outNode.right;
			}
			
		}
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

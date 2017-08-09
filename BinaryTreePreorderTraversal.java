package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 * 题目描述

Given a binary tree, return the preorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3

return[1,2,3].
Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
	/*//方法一：递归
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root!=null) {
			arrayList.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
        return arrayList;
    }*/
	//方法二：迭代实现
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode curNode = root;
        while (curNode!=null || !stack.isEmpty()) {
			if (curNode!=null) {
				arrayList.add(curNode.val);
				stack.push(curNode);
				curNode = curNode.left;
			}else {				
				curNode = stack.pop().right;
			}
		}
        return arrayList;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

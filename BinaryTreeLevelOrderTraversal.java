package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 * ÌâÄ¿ÃèÊö

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

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
public class BinaryTreeLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root==null) {
			return list;
		}
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
			int num = queue.size();
			ArrayList<Integer> perList = new ArrayList<Integer>();
			for (int i = 0; i < num; i++) {
				TreeNode treeNode = queue.poll();
				perList.add(treeNode.val);
				if (treeNode.left!=null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right!=null) {
					queue.add(treeNode.right);
				}
			}
			list.add(perList);
		}
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

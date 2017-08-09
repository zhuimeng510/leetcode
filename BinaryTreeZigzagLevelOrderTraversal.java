package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/*
 * ��Ŀ����

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
public class BinaryTreeZigzagLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		//����һ��
		/*ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root==null) {
			return list;
		}
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
			int num = queue.size();
			ArrayList<Integer> perList = new ArrayList<Integer>();
			for (int i = 0; i < num; i++) {
				TreeNode treeNode = queue.poll();
				if (leftToRight) {
					perList.add(treeNode.val);
				}else {
					perList.add(0, treeNode.val);
				}
				
				if (treeNode.left!=null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right!=null) {
					queue.add(treeNode.right);
				}
			}
			list.add(perList);
			leftToRight = !leftToRight;
		}
        return list;*/
		//��������
		//��������ջ��������ʱ����һ������ջ��������������������������ʱ���෴
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root==null) {
			return ans;
		}
		Stack<TreeNode> curStack = new Stack<TreeNode>();
		Stack<TreeNode> nextLayerStack = new Stack<TreeNode>();
		curStack.push(root);
		boolean leftToRight = true;//������
		ArrayList<Integer> layerArrayList = new ArrayList<Integer>();
		while (!curStack.isEmpty() || !nextLayerStack.isEmpty()) {			
			if (curStack.isEmpty()) {//��ǰ��һ�������
				//����ջ
				Stack<TreeNode> tmp = curStack;
				curStack = nextLayerStack;
				nextLayerStack = tmp;
				//ת��
				leftToRight = !leftToRight;
				//��ӵ����б�
				ans.add(layerArrayList);
				//�½��б�
				layerArrayList = new ArrayList<Integer>();
			}else {
				TreeNode treeNode = curStack.pop();
				layerArrayList.add(treeNode.val);
				if (leftToRight) {//���������
					if (treeNode.left!=null)  nextLayerStack.push(treeNode.left);
					if (treeNode.right!=null)  nextLayerStack.push(treeNode.right);
				}else {//������ҵ���
					if (treeNode.right!=null)  nextLayerStack.push(treeNode.right);
					if (treeNode.left!=null)  nextLayerStack.push(treeNode.left);
				}
			}			
		}
		ans.add(layerArrayList);//���һ��Ӳ���ȥ��
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

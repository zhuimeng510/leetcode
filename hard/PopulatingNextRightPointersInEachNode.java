package hard;
/*
 * 题目描述

Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
Initially, all next pointers are set toNULL.
Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {

	public void connect(TreeLinkNode root) {
		TreeLinkNode layerLeft = root;//每层最左面节点
        while (layerLeft!=null) {
        	TreeLinkNode layerNode = layerLeft;//从最左面开始
			while (layerNode!=null) {
				if (layerNode.left!=null) {
					layerNode.left.next = layerNode.right;
				}
				if (layerNode.right!=null && layerNode.next!=null) {
					layerNode.right.next = layerNode.next.left;
				}
				layerNode = layerNode.next;
			}
			layerLeft = layerLeft.left;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

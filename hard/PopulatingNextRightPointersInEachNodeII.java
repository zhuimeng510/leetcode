package hard;
/*
 * 题目描述

Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
Note:
You may only use constant extra space.

For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersInEachNodeII {

	public void connect(TreeLinkNode root) {
		if (root==null) {
			return;
		}
		TreeLinkNode leftesTreeLinkNode = root;//指向下一行最左节点
		boolean hasNextLine = true;//是否有下一行
		
		while (hasNextLine) {
			hasNextLine = false;
			TreeLinkNode layerLinkNode = leftesTreeLinkNode;//从左到右遍历
			boolean findFirst = false;
			TreeLinkNode tailLinkNode = null;//连接下一行的尾节点
			while (layerLinkNode!=null) {
				if (layerLinkNode.left!=null) {//左孩子
					if (!findFirst) {//本行第一个
						findFirst = true;//找到下一行最左节点
						hasNextLine = true;
						leftesTreeLinkNode = layerLinkNode.left;
						tailLinkNode = layerLinkNode.left;
					}else {//本行前面已经有节点
						tailLinkNode.next = layerLinkNode.left;
						tailLinkNode = tailLinkNode.next;
					}
				}
				if (layerLinkNode.right!=null) {//右孩子
					if (!findFirst) {//本行第一个
						findFirst = true;//找到下一行最左节点
						hasNextLine = true;
						leftesTreeLinkNode = layerLinkNode.right;
						tailLinkNode = layerLinkNode.right;
					}else {//本行前面已经有节点
						tailLinkNode.next = layerLinkNode.right;
						tailLinkNode = tailLinkNode.next;
					}
				}
				layerLinkNode = layerLinkNode.next;
			}
			
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

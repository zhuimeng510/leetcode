package hard;
/*
 * ��Ŀ����

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
		TreeLinkNode leftesTreeLinkNode = root;//ָ����һ������ڵ�
		boolean hasNextLine = true;//�Ƿ�����һ��
		
		while (hasNextLine) {
			hasNextLine = false;
			TreeLinkNode layerLinkNode = leftesTreeLinkNode;//�����ұ���
			boolean findFirst = false;
			TreeLinkNode tailLinkNode = null;//������һ�е�β�ڵ�
			while (layerLinkNode!=null) {
				if (layerLinkNode.left!=null) {//����
					if (!findFirst) {//���е�һ��
						findFirst = true;//�ҵ���һ������ڵ�
						hasNextLine = true;
						leftesTreeLinkNode = layerLinkNode.left;
						tailLinkNode = layerLinkNode.left;
					}else {//����ǰ���Ѿ��нڵ�
						tailLinkNode.next = layerLinkNode.left;
						tailLinkNode = tailLinkNode.next;
					}
				}
				if (layerLinkNode.right!=null) {//�Һ���
					if (!findFirst) {//���е�һ��
						findFirst = true;//�ҵ���һ������ڵ�
						hasNextLine = true;
						leftesTreeLinkNode = layerLinkNode.right;
						tailLinkNode = layerLinkNode.right;
					}else {//����ǰ���Ѿ��нڵ�
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

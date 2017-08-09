package easy;
/*
 * ��Ŀ����

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path1->2->3which represents the number123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.
Return the sum = 12 + 13 =25.
 */
public class SumRootToLeafNumbers {
	private int sum = 0;//����ܺ�
	private int curVal = 0;//��ǰֵ
	public int sumNumbers(TreeNode root) {
        if (root == null) {
			return 0;
		}
        curVal = curVal*10+root.val;//�ս���ĳ�ڵ�
        if (root.left!=null)  sumNumbers(root.left);//����������
        if (root.right!=null) sumNumbers(root.right);//����������
        if (root.left==null && root.right==null) {//����������Ϊ�գ���Ҷ��
        	sum+=curVal;
		}
        curVal = (curVal-root.val)/10;//�뿪ĳ�ڵ�
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

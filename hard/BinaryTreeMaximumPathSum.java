package hard;
/*
 * ��Ŀ����

Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3

Return6.

 */
public class BinaryTreeMaximumPathSum {	
	/*����һ���������
	 * public int maxPathSum(TreeNode root) {
        if (root==null) {
			return 0;		
		}
        if (root.left==null && root.right==null) {//���Ҷ�Ϊ��
			return root.val;
		}
        int endCur = maxPathSumToCur(root);//�Ե�ǰ�ڵ�Ϊβ
        int leftTree = Integer.MIN_VALUE;
        if (root.left!=null) {
        	leftTree = maxPathSum(root.left);//������
		}
        int rightTree = Integer.MIN_VALUE;
        if (root.right!=null) {
        	rightTree = maxPathSum(root.right);//������
		}         
        int leftCurRight = Integer.MIN_VALUE; 
        if(root.left!=null && root.right!=null){
        	leftCurRight = maxPathSumToCur(root.left)+maxPathSumToCur(root.right)+root.val;//��+��+��
        }
       
        int ans = endCur>leftTree?endCur:leftTree;
        ans = ans>rightTree?ans:rightTree;
        ans = ans>leftCurRight?ans:leftCurRight;
        return ans;
    }
	//�Ե�ǰ�ڵ�Ϊβ�ڵ�����·��
	public int maxPathSumToCur(TreeNode root) {
	    if (root==null) {
			return 0;
		}
	    if (root.left==null && root.right==null) {
			return root.val;
		}
	    int left = Integer.MIN_VALUE;
	    int right = Integer.MIN_VALUE;
	    if (root.left!=null) {
	    	left = maxPathSumToCur(root.left)+root.val;
		}
	    if (root.right!=null) {
	    	right = maxPathSumToCur(root.right)+root.val;
		}		    
	    int ans = left>right?left:right;
	    return ans>root.val?ans:root.val;	    
	}*/
	//��������
	/*
	 * ˼·:

	�������Ƿ���һ�¶���ָ��ĳ���ڵ�Ϊ��ʱ������·�����п�������Щ���:
	��һ������������·�����ϵ�ǰ�ڵ㣬
	�ڶ�������������·�����ϵ�ǰ�ڵ㣬
	������������������·�����ϵ�ǰ�ڵ㣨�൱��һ����統ǰ�ڵ��·������
	��������ֻ���Լ���·����
	
	էһ���ƺ��Դ�Ϊ�����������¶��ϵݹ�����ˣ�Ȼ�����������ֻ��
	���������Ե�ǰ�ڵ�������·���������ǰ�ڵ����滹�нڵ㣬
	�����ĸ��ڵ��ǲ����ۼӵ���������ġ���������Ҫ�����������ֵ��
	һ���ǵ�ǰ�ڵ������·���ͣ���һ�������Ҫ���Ӹ��ڵ�ʱ����·���͡�
	������ǰ�߸���ȫ����������ú��߷��صݹ�ֵ�����ˡ�
	 */
	int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;    
    }
    private int maxPathDown(TreeNode node){
        if(node==null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
	public static void main(String[] args) {
		TreeNode treeNode0 = new TreeNode(-1);
		TreeNode treeNode1 = new TreeNode(-2);
		TreeNode treeNode2 = new TreeNode(7);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(9);
		treeNode0.left = treeNode1;
		treeNode0.right = treeNode2;
		treeNode1.left = treeNode3;
		treeNode1.right = treeNode4;
		treeNode2.right = treeNode5;
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(treeNode0));
	}

}

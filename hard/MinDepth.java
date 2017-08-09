package hard;

import hard.TreeNode;

import java.util.LinkedList;


/**
 * minimum-depth-of-binary-tree
题目描述
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepth {

	public static int run(TreeNode root) {
		/*//方法一：递归
		if (root == null) {
			return 0;
		}
		if (root.left==null && root.right==null) {
			return 1;
		}
		if (root.left==null) {
			return run(root.right)+1;
		}
		if (root.right==null) {
			return run(root.left)+1;
		}
		return Math.min(run(root.left)+1,run(root.right)+1);
		*/
		//方法二：非递归
		if(root==null){
            return 0;
        }
        int num =1;
        LinkedList<TreeNode> prelist = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
 
        list.add(root);
        while (true){
 
            boolean flag = false;
            prelist.clear();
            prelist.addAll(list);
            list.clear();
            while(!prelist.isEmpty()){
                TreeNode node = prelist.remove();
                if(node.left==null && node.right==null){
                    flag = true;
                    break;
                }
                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }
            }
             
 
            if(flag == true){
                break;
            }
             
            num++;
 
        }
 
 
        return num;
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tNode0 = new TreeNode(0);
		TreeNode tNode1 = new TreeNode(1);
		TreeNode tNode2 = new TreeNode(2);
		TreeNode tNode3 = new TreeNode(3);
		TreeNode tNode4 = new TreeNode(4);
		TreeNode tNode5 = new TreeNode(5);
		tNode0.left = tNode1;
		tNode0.right = tNode2;
		tNode2.left = tNode3;
		tNode2.right = tNode4;
		tNode3.left = tNode5;
		System.out.println("二叉树最小深度为："+run(tNode0));

	}

}

package easy;

import java.util.ArrayList;

/*
 * 题目描述

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class PathSumII {
	int curSum = 0;
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null){
        	return resultArrayList;
        }
		curSum+=root.val;
		arrayList.add(root.val);
		if (root.left!=null) {
			pathSum(root.left, sum);
		}
		if (root.right!=null) {
			pathSum(root.right, sum);
		}
		if (root.left==null && root.right==null) {
			if (curSum==sum) {//找到和为sum的路径
				ArrayList<Integer> list = new ArrayList<Integer>(arrayList);
	    		resultArrayList.add(list);
	    	}
		}
		arrayList.remove(arrayList.size()-1);
		curSum-=root.val;
		return resultArrayList;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

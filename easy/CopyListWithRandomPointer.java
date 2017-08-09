package easy;

import java.util.HashMap;

/*
 * 题目描述

A linked list is given such that each node contains an additional random pointer which could point
to any node in the list or null.
Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode node = head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		//建立节点间对应关系
        while (node!=null) {
			RandomListNode copyListNode = new RandomListNode(node.label);
			map.put(node, copyListNode);
			node = node.next;			
		}
        node = head;
        while (node!=null) {
			RandomListNode curNode = map.get(node);
			curNode.next = map.get(node.next);
			curNode.random = map.get(node.random);
			node = node.next;
			
		}
        return map.get(head);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

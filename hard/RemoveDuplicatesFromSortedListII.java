package hard;
/*
 *题目描述

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.
 */
public class RemoveDuplicatesFromSortedListII {

	public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
			return head;
		}
        ListNode addHead = new ListNode(-1);//添加一个头节点，便于处理
        ListNode tailListNode = addHead;//用于连接链表
        ListNode lateListNode = head;  //用于指示相同节点的开始
        ListNode preListNode = lateListNode;//用于指示相同节点的结束
        while (lateListNode!=null) {
			while (preListNode!=null && preListNode.next!=null) {
				if (preListNode.next.val==lateListNode.val) {
					preListNode = preListNode.next;
				}else {
					break;
				}
				
			}
			if (preListNode == lateListNode) {//无重复节点
				tailListNode.next = lateListNode;
				tailListNode = tailListNode.next;
			}
			lateListNode = preListNode.next;
			preListNode = lateListNode;//从同一位置开始
			
			
		}
        tailListNode.next = null;//结束
        return addHead.next;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode0 = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(3);
		listNode0.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		System.out.println(deleteDuplicates(listNode0).val);
	}

}

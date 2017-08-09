package easy;
/*
 * 题目描述

You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class 链表两数和 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int added = 0;
		ListNode dummy = new ListNode(-1);
		ListNode taiListNode = dummy;
        while (l1!=null && l2!=null) {
			int val = l1.val+l2.val+added;
			ListNode tmpListNode = new ListNode(val%10);
			added = val/10;
			taiListNode.next = tmpListNode;
			taiListNode = taiListNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}
        while (l1!=null) {
        	int val = l1.val+added;
			ListNode tmpListNode = new ListNode(val%10);
			added = val/10;
			taiListNode.next = tmpListNode;
			taiListNode = taiListNode.next;
			l1 = l1.next;			
		}
        while (l2!=null) {
        	int val = l2.val+added;
			ListNode tmpListNode = new ListNode(val%10);
			added = val/10;
			taiListNode.next = tmpListNode;
			taiListNode = taiListNode.next;
			l2 = l2.next;			
		}
        if (added!=0) {
        	ListNode tmpListNode = new ListNode(1);
        	taiListNode.next = tmpListNode;
			taiListNode = taiListNode.next;
		}
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

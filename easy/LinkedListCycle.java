package easy;
/*
 * 题目描述

Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if (head==null) {
			return false;
		}
        ListNode oneStepNode = head;
        ListNode twoStepNode = head;
        while (oneStepNode!=null && twoStepNode!=null) {
			oneStepNode = oneStepNode.next;//走一步
			if(twoStepNode.next!=null){
				twoStepNode = twoStepNode.next.next;//走两步
			}else {
				return false;
			}
			if (oneStepNode==twoStepNode && oneStepNode!=null) {//再次相遇，有环
				return true;
			}
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

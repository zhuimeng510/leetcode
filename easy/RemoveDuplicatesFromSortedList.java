package easy;
/*
 * ÌâÄ¿ÃèÊö

Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
Given1->1->2, return1->2.
Given1->1->2->3->3, return1->2->3.
 */
public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
			return head;
		}
        ListNode slowListNode = head;
        ListNode fastListNode = head.next;
        while (fastListNode!=null) {
			if (slowListNode.val==fastListNode.val) {
				fastListNode = fastListNode.next;
				slowListNode.next = fastListNode;
			}else {
				slowListNode = fastListNode;
				fastListNode = fastListNode.next;
			}			
		}
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

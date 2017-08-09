package hard;
/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.

 */
public class ReorderList {
	//快慢指针找中间节点
	public ListNode findCenter(ListNode head){
		if (head==null || head.next==null) {
			return head;
		}
		ListNode slowListNode = head;
		ListNode fastListNode = head;
		while (fastListNode!=null && fastListNode.next!=null) {
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;			
		}
		return slowListNode;
	}
	//链表反转
	public ListNode reverseList(ListNode head){
		if (head==null || head.next==null) {
			return head;
		}
		//利用首插法进行反转
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		while (head.next!=null) {
			ListNode nextNode = head.next;
			head.next = nextNode.next;
			nextNode.next = dummy.next;
			dummy.next = nextNode;
			
		}
		return dummy.next;
	}
	//两个链表进行合并
	public void mergeList(ListNode head,ListNode head2){
		if (head==null) return;
		ListNode tailListNode = head;
		while (head2!=null) {
			ListNode nextListNode = head2.next;//短链中头的下一个节点
			head2.next = tailListNode.next;
			tailListNode.next = head2;
			head2 = nextListNode;
			tailListNode = tailListNode.next.next;
		}
		
		
	}
	public void reorderList(ListNode head) {
		 if (head==null || head.next==null) {
		 	 return;
		 }
	     ListNode centerListNode = findCenter(head);//找中间节点
	     ListNode nextListNode = centerListNode.next;
	     centerListNode.next = null;//断开链
	     ListNode head2 = reverseList(nextListNode);//反转后面链表
	     mergeList(head,head2);//合并两个链表
	     
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode0 = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(5);
		listNode0.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		new ReorderList().reorderList(listNode0);		
		while (listNode0!=null) {
			System.out.print(listNode0.val+" ");
			listNode0 = listNode0.next;
		}
		System.out.println();
		
	}

}

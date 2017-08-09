package easy;
/*
 * 题目描述

Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given1->2->3->4->5->NULL, m = 2 and n = 4,
return1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListii {
	//方法二：利用首插法
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head==null) return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode tail = dummy;
		int cur = 1;
		//tail指向第m个节点的前一个
		for (; cur < m; cur++) {
			tail = tail.next;
		}
		ListNode subHead = tail.next;//要反转的初始头
		for (; cur < n; cur++) {
			ListNode nextNode = subHead.next;
			subHead.next = nextNode.next;
			nextNode.next = tail.next;
			tail.next = nextNode;
		}
		return dummy.next;
	}
	 	/*public ListNode reverse(ListNode subHead,ListNode nextHead){
	        ListNode tail = nextHead;
	        ListNode cur = subHead;
	        while(cur!=nextHead){
	            ListNode next = cur.next;
	            cur.next = tail;
	            tail = cur;
	            cur = next;
	        } 
	        return tail;
	    }
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;
	        ListNode tail = dummy;
	        ListNode cur = head;
	        ListNode nextHead = null;
	        ListNode subHead = head;
	        for(int i=1;i<=n;i++){
	            if(i==m-1){
	                tail = cur;
	                subHead = cur.next;
	            }
	            if(i==n){
	                nextHead = cur.next;
	            }
	            cur = cur.next;
	        }
	        tail.next = reverse(subHead,nextHead);
	        return dummy.next;
	    }*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l0 = new ListNode(3);
		ListNode l1 = new ListNode(5);
		l0.next = l1;
		ListNode newHead = new ReverseLinkedListii().reverseBetween(l0, 1, 2);
		while (newHead!=null) {
			System.out.print(newHead.val+" ");
			newHead = newHead.next;
		}
		System.out.println();
	}

}

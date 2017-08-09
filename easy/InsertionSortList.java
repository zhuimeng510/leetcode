package easy;
/*
 * 题目描述
Sort a linked list using insertion sort.

 */
public class InsertionSortList {

	public static ListNode insertionSortList(ListNode head) {
		//方法二：增加辅助空间
		if (head==null || head.next==null) {
			return head;
		}
		ListNode h = new ListNode(-1);//增加一个头，避免处理头变化的情况
		h.next = new ListNode(head.val);
		for (head=head.next; head!=null; head=head.next) {
			ListNode pre = h;
			ListNode cur = pre.next;
			while (cur!=null && cur.val<=head.val) {
				pre = cur;
				cur = pre.next;				
			}
			if (cur==null) {
				pre.next = new ListNode(head.val);
			}else {
				ListNode listNode = new ListNode(head.val);
				listNode.next = cur;
				pre.next = listNode;
			}
		}
		return h.next;
		/*//方法一：无辅助空间
		if (head==null || head.next==null) {
			return head;
		}
		ListNode h = new ListNode(-1);//增加一个头，避免处理头的情况
		h.next = head;
		ListNode preCur = head;//要插入节点的前一个节点
		ListNode cur = preCur.next;//要插入的节点
		while (cur!=null) {
			ListNode preq = h;
			ListNode q = preq.next;
			for (; q!=cur; preq=q,q=preq.next) {
				if (q.val>cur.val) {
					preCur.next = cur.next;
					cur.next = q;
					preq.next = cur;
					break;
				}
			}
			if (q!=cur) {//cur前面有比它大的
				cur = preCur.next;
			}else {//cur前面都比它小
				preCur = cur;
				cur = preCur.next;
			}
			
			
		}
		
	    return h.next;*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode0 = new ListNode(4);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(3);
		listNode0.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		ListNode l = insertionSortList(listNode0);
		while (l!=null) {
			System.out.print(l.val+" ");
			l=l.next;
		}
		System.out.println();
	}

}

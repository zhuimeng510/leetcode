package easy;
/*
 * ��Ŀ����
Sort a linked list using insertion sort.

 */
public class InsertionSortList {

	public static ListNode insertionSortList(ListNode head) {
		//�����������Ӹ����ռ�
		if (head==null || head.next==null) {
			return head;
		}
		ListNode h = new ListNode(-1);//����һ��ͷ�����⴦��ͷ�仯�����
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
		/*//����һ���޸����ռ�
		if (head==null || head.next==null) {
			return head;
		}
		ListNode h = new ListNode(-1);//����һ��ͷ�����⴦��ͷ�����
		h.next = head;
		ListNode preCur = head;//Ҫ����ڵ��ǰһ���ڵ�
		ListNode cur = preCur.next;//Ҫ����Ľڵ�
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
			if (q!=cur) {//curǰ���б������
				cur = preCur.next;
			}else {//curǰ�涼����С
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

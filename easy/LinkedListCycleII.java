package easy;
/*
 * ��Ŀ����

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Follow up:
Can you solve it without using extra space?

 */
public class LinkedListCycleII {
	/*//����һ��
	 //����Ƿ��л�
	public boolean hasCycle(ListNode head){
		if(head==null || head.next==null){
			return false;
		}
		ListNode oneStepNode = head;
		ListNode twoStepNode = head;
		while (twoStepNode!=null) {
			if (twoStepNode.next!=null) {
				twoStepNode = twoStepNode.next.next;
				oneStepNode = oneStepNode.next;
			}else {
				return false;
			}
			if (oneStepNode == twoStepNode) {
				return true;
			}
		}
		return false;
	}
	public ListNode detectCycle(ListNode head) {
        if (hasCycle(head)) {
			ListNode preListNode = head;
			ListNode nowListNode = head.next;
			while (nowListNode!=null) {
				preListNode.next = null;
				preListNode = nowListNode;
				nowListNode = nowListNode.next;				
			}
			return preListNode;
		}
        return null;
    }*/
	//��������
	public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) {
			return null;
		}
        ListNode slowNode = head;
        ListNode fastNode = head;
        ListNode meet = null;
        while (fastNode!=null) {
			if (fastNode.next!=null) {
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}else {
				return null;
			}
			if (fastNode == slowNode) {
				meet = fastNode;//�����ڵ�
				break;
			}
		}
        if (fastNode == null) {//�޻�
			return null;
		}
        ListNode way1 = head;//��ͷ�����
        ListNode way2 = meet;//����������
        while (way1!= way2) {
			way1 = way1.next;
			way2 = way2.next;			
		}
        return way1;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package hard;


/*
 * ��Ŀ����

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list:1->2->3->4->5
For k = 2, you should return:2->1->4->3->5
For k = 3, you should return:3->2->1->4->5
 */
public class ReverseNodesInKGroup {
	public static ListNode reverse(ListNode preNode,ListNode endNext) {
		ListNode head = preNode.next;
		while (head.next!=endNext) {
			ListNode nextNode = head.next;
			head.next = nextNode.next;
			nextNode.next = preNode.next;
			preNode.next = nextNode;
			
		}
		//ָ��������һ���ڵ�
		return head;
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head==null)  return null;
        ListNode dummy = new ListNode(-1);//���һ�������ͷ�ڵ�
        dummy.next = head;
        ListNode preNode = dummy;//����ǰһ���ڵ�
        int i=0;
        ListNode cur = head;
        while(cur!=null){
        	i++;//��i���ڵ�
        	if (i%k==0) {//һ�������ķ���
				preNode = reverse(preNode,cur.next);
				///////////////////ע��
				cur = preNode.next;//��ת��ȡ��һ���ڵ�
			}else {
				cur = cur.next;
			}
        	
        }
        return dummy.next;	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l0 = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		ListNode head = reverseKGroup(l0, 2);
		while (head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		
	}

}

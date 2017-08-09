package hard;
/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 本题综合利用快慢指针与归并排序，收藏了。
 */
public class SortList {
	//快慢指针找中间节点
	public ListNode findCenterNode(ListNode head){
		if (head==null || head.next==null) {
			return head;
		}
		ListNode slowNode = head;
		ListNode fastNode = head;
		while (fastNode.next!=null && fastNode.next.next!=null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;			
		}
		return slowNode;
	}
	
	//合并两个链表
	public ListNode merge(ListNode left,ListNode right){
		if (left==null || right==null) {
			return left==null?right:left;
		}
		ListNode head = new ListNode(-1);
		ListNode tail = head;
		while (left!=null && right!=null) {
			if (left.val<=right.val) {
				tail.next = left;
				left = left.next;
			}else {
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		
		}
		tail.next = (left!=null)?left:right;
		return head.next;
	}
	public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
		ListNode centerNode = findCenterNode(head);
		ListNode nextNode = centerNode.next;
		centerNode.next = null;
		ListNode leftNode = sortList(head);
		ListNode rightNode = sortList(nextNode);
		return merge(leftNode,rightNode);
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(5);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(6);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode head = new SortList().sortList(node0);
		while (head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}

}

package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 题目描述

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
	//使用堆排序，假设每个列表平均长度为n，则复杂度为插入一个log(k),删除一个log(k),共有kn个元素，所有复杂度为o(nklog(k))
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists==null || lists.size()==0) {
			return null;
		}
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if (o1.val<o2.val) {
					return -1;
				}else if (o1.val>o2.val) {
					return 1;
				}else {
					return 0;
				}
				
			}
		};
		//创建优先队列用于进行堆排序
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), comparator);		
		//把各链表最小的加入优先队列
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i)!=null) {
				queue.add(lists.get(i));
			}			
		}
		if (queue.size()!=0) {
			ListNode head = queue.remove();//新链表的头节点
			ListNode cur = head;//用于连接节点
			if (cur.next!=null) {
				queue.add(cur.next);
			}
			while (queue.size()!=0) {
				cur.next = queue.remove();
				cur = cur.next;//指向刚移除的节点
				if (cur.next!=null) {
					queue.add(cur.next);
				}
				
			}
			return head;
		}else {//每个队列均为空情况
			return null;
		}
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
		ListNode l11=new ListNode(2);
		ListNode l12=new ListNode(3);
		ListNode l13=new ListNode(7);
		l11.next=l12;
		l12.next=l13;
		arrayList.add(l11);
		ListNode l21=new ListNode(4);
		ListNode l22=new ListNode(5);
		l21.next=l22;
		arrayList.add(l21);
		ListNode l31=new ListNode(1);
		ListNode l32=new ListNode(2);
		l31.next=l32;
		arrayList.add(l31);
		ListNode result = mergeKLists(arrayList);
		while (result!=null) {
			System.out.print(result.val+" ");
			result = result.next;
			
		}
		System.out.println();
	}

}

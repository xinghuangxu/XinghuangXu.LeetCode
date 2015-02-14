package xinghuangxu.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public void add(ListNode listNode) {
		listNode.next = this.next;
		this.next = listNode;
	}
}

public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		int pivot = head.val;
		ListNode l1 = new ListNode(0), l2 = l1, r1 = new ListNode(0), r2 = r1, m1=head,m2=m1, temp = head.next;
		while (temp != null) {
			if (temp.val < pivot) {
				l2.next = temp;
				l2 = temp;
			} else if(temp.val>pivot){
				r2.next = temp;
				r2 = temp;
			}else{
				m2.next=temp;
				m2=temp;
			}
			temp = temp.next;
		}
		l2.next = null;
		r2.next = null;
		m2.next = null;
		temp = m1;
		if (l1.next != null) {
			l1 = sortList(l1.next);
			temp = l1;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = m1;
			temp = l1;
		}
		if (r1.next != null) {
			r1 = sortList(r1.next);
			m2.next = r1;
		}
		// merge
		return temp;
	}

	public static void main(String[] arg) {
		ListNode ln = new ListNode(4);
		int[] num={19,14,5,-3,1,8,5,11,15};
		for(int n:num){
			ln.add(new ListNode(n));
		}
		
		SortList sl = new SortList();
		// for(int i=7;i>4;i--){
		// ln.add(new ListNode(i));
		// }
		ListNode temp = sl.sortList(ln);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		// System.out.println(sl.sortList(ln).val);
	}
}

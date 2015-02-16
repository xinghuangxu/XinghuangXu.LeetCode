package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.ListNode;



public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if(head==null)return null;
		ListNode nl = new ListNode(0), p1, temp = head,tnext;
		while (temp != null) {
			p1 = nl;
			tnext=temp.next;
			while (true) {
				if(p1.next==null){
					p1.next=temp;
					temp.next=null;
					break;
				}
				if (p1.next.val > temp.val) {
					temp.next = p1.next;
					p1.next = temp;
					break;
				}else{
					p1=p1.next;
					
				}
			}
			temp = tnext;
		}
		return nl.next;

	}

	public static void main(String[] arg) {
		ListNode ln = new ListNode(4);
		int[] num = {  };
		for (int n : num) {
			ln.add(new ListNode(n));
		}

		InsertionSortList sl = new InsertionSortList();
		// for(int i=7;i>4;i--){
		// ln.add(new ListNode(i));
		// }
		ListNode temp = sl.insertionSortList(ln);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		// System.out.println(sl.sortList(ln).val);
	}
}

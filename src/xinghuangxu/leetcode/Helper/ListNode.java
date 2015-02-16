package xinghuangxu.leetcode.Helper;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public void add(int val){
		ListNode temp=new ListNode(val);
		temp.next=next;
		next=temp;
	}

	public void add(ListNode temp) {
		temp.next=next;
		next=temp;
	}
}

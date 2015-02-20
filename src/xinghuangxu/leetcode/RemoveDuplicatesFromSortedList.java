package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.ListNode;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList rfs = new RemoveDuplicatesFromSortedList();
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null)return head;
		ListNode newHead = new ListNode(0),prev=newHead,cur = head;
		prev.next=cur;
		while (cur != null) {
			if(cur.next!=null&&cur.val==cur.next.val){//remove duplicate
				int dvalue=cur.val;
				while(cur!=null&&cur.val==dvalue){
					cur=cur.next;
				}
				prev.next=cur;
			}else{
				prev=prev.next;
				cur=cur.next;
			}
		}
		return newHead.next;
	}

}

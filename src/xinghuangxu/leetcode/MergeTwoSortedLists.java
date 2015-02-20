package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp=new ListNode(0),tail=temp;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				tail.next=l1;
				tail=l1;
				l1=l1.next;
			}else{
				tail.next=l2;
				tail=l2;
				l2=l2.next;
			}
		}
		while(l1!=null){
			tail.next=l1;
			tail=l1;
			l1=l1.next;
		}
		while(l2!=null){
			tail.next=l2;
			tail=l2;
			l2=l2.next;
		}
		return temp.next;
	}

}

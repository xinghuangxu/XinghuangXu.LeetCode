package xinghuangxu.leetcode;

public class IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a=headA,b=headB;
		while(a!=null&&b!=null){
			if(a.val==b.val){
				return a;
			}else if (a.val>b.val){
				b=b.next;
			}else{
				a=a.next;
			}
		}
		return null;
	}
}

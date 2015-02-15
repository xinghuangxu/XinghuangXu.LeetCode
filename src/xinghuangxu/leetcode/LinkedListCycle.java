package xinghuangxu.leetcode;

public class LinkedListCycle {
	public static void main(String[] arg) {
		int[] num={7032,15013,6890,8877,11344,320,13037,9414};
		ListNode[] all=new ListNode[num.length];
		ListNode list=new ListNode(0);
		ListNode temp;
		for(int i=0;i<num.length;i++){
			temp=new ListNode(num[i]);
			list.add(temp);
			all[i]=temp;
		}
		all[0].next=all[num.length-1];
		
		LinkedListCycle llc=new LinkedListCycle();
		temp=llc.detectCycle(list);
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode fast = head.next, slow = head;
		while (fast != null) {
			if (fast.val == slow.val) {
				return true;
			}
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				break;
			}
		}
		return false;
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode fast = head, slow = head,p1;
		while (true) {
			slow = slow.next;
			fast = fast.next;
			if(slow!=null&&fast != null&&fast.next!=null){
				fast=fast.next;
				if (fast == slow) {
					p1=head;
					while(p1!=slow){
						p1=p1.next;
						slow=slow.next;
					}
					return p1;
				}
			} else {
				break;
			}
		}
		return null;
	}
}

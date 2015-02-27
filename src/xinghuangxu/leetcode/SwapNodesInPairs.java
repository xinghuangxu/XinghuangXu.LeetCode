package xinghuangxu.leetcode;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		SwapNodesInPairs snp=new SwapNodesInPairs();
		ListNode head=snp.swapPairs(l4);
		System.out.println();
	}

	public ListNode swapPairs(ListNode head) {
		if(head==null)return head;
		ListNode temp=new ListNode(0),start,prev,cur;
		temp.next=head;
		start=temp;
		prev=start.next;
		cur=prev.next;
		while(cur!=null){
			prev.next=cur.next;
			cur.next=prev;
			start.next=cur;
			//move forward
			start=prev;
			prev=start.next;
			if(prev!=null){
				cur=prev.next;
			}else{
				cur=null;
			}
		}
		return temp.next;
	}

}

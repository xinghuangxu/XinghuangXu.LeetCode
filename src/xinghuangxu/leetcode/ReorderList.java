package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.ListNode;
public class ReorderList {
	
	public static void main(String[] arg) {
		int[] num={1};
		ListNode ln=new ListNode(0);
		for(int n:num){
			ln.add(n);
		}
		ReorderList rl=new ReorderList();
		rl.reorderList(ln.next);
		ListNode temp=ln.next;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
	}

	public void reorderList(ListNode head) {
		if(head==null)return ;
		ListNode l1=head,l2,p1=head,p2=head;
		int count=0,half;
		while(p1!=null){
			count++;
			p1=p1.next;
		}
		half=count%2==0?count/2-1:count/2;
		p1=head;
		p2=head.next;
		while(half>0){
			p1=p1.next;
			p2=p2.next;
			half--;
		}
		p1.next=null;
		l2=p2;
		
		//reverse l2
		if(l2!=null){
			p1=null;p2=l2;
			ListNode tnext=null;
			while(p2.next!=null){
				tnext=p2.next;
				p2.next=p1;
				p1=p2;
				p2=tnext;
			}
			p2.next=p1;
			l2=p2;
			
			//combine the two list
			p1=l1;p2=l2;
			while(p2!=null){
				tnext=p2.next;
				p2.next=p1.next;
				p1.next=p2;
				//moving foward
				p1=p1.next.next;
				p2=tnext;
			}
		}
		
		
		System.out.println("");
	}
}

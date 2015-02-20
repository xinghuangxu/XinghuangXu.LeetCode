package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.ListNode;

public class ReversedLinkedListII {

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		ReversedLinkedListII rll=new ReversedLinkedListII();
		ListNode rel=rll.reverseBetween(l1, 3, 4);
		System.out.println();
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n)return head;
		int index=1;
		ListNode prev=null,cur,next,end=null,start=null,newList=null,newEnd=null;
		boolean reverse=false;
		cur=head;
		while(cur!=null){
			next=cur.next;
			if(reverse){
				cur.next=prev;
			}
			if(index==m){
				newEnd=cur;
				start=prev;
				reverse=true;
			}
			if(index==n){
				newList=cur;
				end=next;
				reverse=false;
				break;
			}
			prev=cur;
			cur=next;
			index++;
		}
		if(start!=null){
			start.next=newList;
		}
		if(newEnd!=null){
			newEnd.next=end;
		}
		if(m==1){ //if the head has been changed
			return newList;
		}
		return head;

	}

}

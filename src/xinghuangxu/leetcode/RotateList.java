package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.ListNode;

public class RotateList {

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		l1.next=l2;
		RotateList rl=new RotateList();
		ListNode rel= rl.rotateRight(l1, 1);
		System.out.println();
	}
	
	public ListNode rotateRight(ListNode head, int n) {
        int count=0;
        ListNode temp=head,prev=null;
        while(temp!=null){
        	prev=temp;
        	temp=temp.next;
        	count++;
        }
        if(count<=1)return head;
        prev.next=head;
        int rotateCount=count-n%count;
        prev=null;
        temp=head;
        while(rotateCount!=0){
        	prev=temp;
        	temp=temp.next;
        	rotateCount--;
        }
        prev.next=null;
        return temp;
    }

}

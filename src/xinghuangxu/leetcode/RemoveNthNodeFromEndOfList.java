package xinghuangxu.leetcode;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList rm=new RemoveNthNodeFromEndOfList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		l1.next=l2;
		ListNode head=rm.removeNthFromEnd(l1, 1);
		System.out.println();
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=n+1; //want temp to point at the node before the delete node
        ListNode temp=null,end=head;
        while(end!=null){
        	if(temp!=null)temp=temp.next;
        	end=end.next;
        	count--;
        	if(count==0){
        		temp=head;
        	}
        }
        if(temp==null){
        	return head.next;
        }
        temp.next=temp.next.next;
        return head;
    }

}

package xinghuangxu.leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1=new ListNode(5);
		ListNode l2=new ListNode(5);
//		l1.next=l2;
		AddTwoNumbers atw=new AddTwoNumbers();
		ListNode rel=atw.addTwoNumbers(l1, l2);
		System.out.println();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result=new ListNode(0),tail=result,temp;
		ListNode t1=l1,t2=l2;
		int increment=0;
		while(t1!=null&&t2!=null){
			int tval=t1.val+t2.val+increment;
			increment=tval/10;
			temp=new ListNode(tval%10);
			tail.next=temp;
			tail=temp;
			t1=t1.next;
			t2=t2.next;
		}
		t1=t1==null?t2:t1;
		while(t1!=null){
			int tval=t1.val+increment;
			increment=tval/10;
			temp=new ListNode(tval%10);
			tail.next=temp;
			tail=temp;
			t1=t1.next;
		}
		if(increment!=0){
			temp=new ListNode(increment);
			tail.next=temp;
			tail=temp;
		}
		return result.next;
	}

}

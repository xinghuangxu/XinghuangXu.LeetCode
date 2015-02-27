package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		int[] data={1,2,3};
		List<ListNode> l=new ArrayList<ListNode>();
		for(int i=0;i<data.length;i++){
			l.add(new ListNode(data[i]));
			if(i!=0)l.get(i-1).next=l.get(i);
		}
		ReverseNodesInKGroup rng=new ReverseNodesInKGroup();
		ListNode rel=rng.reverseKGroup(l.get(0), 2);
		System.out.println(rel.val);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode end=head,begin=null,temp,newStart=null,newTail=null;
		int count=1;
		while(end!=null){
			if(count==k){
				if(begin==null){
					begin=head;
				}
				temp=end.next;
				if(newStart==null){
					newTail=begin;
					newStart=reverseList(begin,end);
				}else{
					newTail.next=reverseList(begin,end);
					while(newTail.next!=null){
						newTail=newTail.next;
					}
				}
				begin=temp;
				end=temp;
				count=1;
			}
			if(end!=null)end=end.next;
			count++;
		}
		if(newTail!=null)newTail.next=begin;
		return newStart==null?head:newStart;
		
	}

	private ListNode reverseList(ListNode begin, ListNode end) {
		if(begin==end)return begin;
		ListNode newList=new ListNode(0),tail=begin;
		newList.next=tail;
		begin=begin.next;
		while(begin!=end){
			ListNode temp=begin.next;
			begin.next=newList.next;
			newList.next=begin;
			begin=temp;
		}
		end.next=newList.next;
		newList.next=end;
		tail.next=null;
		return newList.next;
	}
}

package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(3);
		l1.next=l2;
		ListNode l3=new ListNode(2);
		MergeKSortedLists mksl=new MergeKSortedLists();
		List<ListNode> ls=new ArrayList<ListNode>();
		ls.add(l1);
		ls.add(l3);
		ListNode rel=mksl.mergeKLists(ls);
		System.out.println();
	}
	
	class Node implements Comparable<Node>{
		ListNode head;
		int size;
		Node(ListNode head){
			size=0;
			this.head=head;
			ListNode temp=head;
			while(temp!=null){
				temp=temp.next;
				size++;
			}
		}
		Node(ListNode head,int size){
			this.head=head;
			this.size=size;
		}
		@Override
		public int compareTo(Node o) {
			if(o.size<this.size){
				return 1;
			}else if(o.size==this.size){
				return 0;
			}
			return -1;
		}
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size()==0)return null;
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		for(int i=0;i<lists.size();i++){
			pq.add(new Node(lists.get(i)));
		}
		while(pq.size()>=2){
			Node t1=pq.poll();
			Node t2=pq.poll();
			pq.add(mergeTwoLists(t1,t2));
		}
		return pq.peek().head;
	}

	private Node mergeTwoLists(Node t1, Node t2) {
		ListNode p1=t1.head;
		ListNode p2=t2.head;
		ListNode newList=new ListNode(0),tail=newList;
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				tail.next=p1;
				tail=p1;
				p1=p1.next;
			}else{
				tail.next=p2;
				tail=p2;
				p2=p2.next;
			}
		}
		while(p1!=null){
			tail.next=p1;
			tail=p1;
			p1=p1.next;
		}
		while(p2!=null){
			tail.next=p2;
			tail=p2;
			p2=p2.next;
		}
		return new Node(newList.next,t1.size+t2.size);
	}
}

package xinghuangxu.leetcode;

import java.util.HashMap;
import java.util.Stack;

import xinghuangxu.leetcode.Helper.*;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		int[] num={-1,-1};
		RandomListNode root = new RandomListNode(0);
		for(int i=0;i<40000;i++){
			root.add(i, root);
		}
		CopyListWithRandomPointer clrp=new CopyListWithRandomPointer();
		RandomListNode copy=clrp.copyRandomList(root.next);
		System.out.println("sdf");
	}
	
	private HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)return null;
		RandomListNode p2=new RandomListNode(0),tail=p2,p1=head,copy;
		while(p1!=null){
			copy=new RandomListNode(p1.label);
			map.put(p1, copy);
			tail.next=copy;
			tail=copy;
			p1=p1.next;
		}
		p1=head;
		tail=p2.next;
		while(p1!=null){
			tail.random=map.get(p1.random);
			p1=p1.next;
			tail=tail.next;
		}
		return p2.next;
	}


}

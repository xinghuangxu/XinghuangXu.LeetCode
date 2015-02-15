package xinghuangxu.leetcode.Helper;

public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}
	
	public void add(int val,RandomListNode r){
		RandomListNode temp=new RandomListNode(val);
		temp.next=next;
		next=temp;
		temp.random=r;
	}
};

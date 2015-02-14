package xinghuangxu.leetcode;

import java.util.HashMap;


public class LRUCache {

	public static void main(String[] args) {
		LRUCache lru=new LRUCache(3000);
		for(int i=0;i<5000000;i++){
			lru.set(i, i);
		}
		System.out.println("Done");
//		lru.set(2,1);
//		lru.get(2);
//		lru.set(3, 2);
//		lru.get(2);
//		lru.get(3);
	}
	
	class Node{
		public Node prev;
		public Node next;
		public int val;
		public int key;
		public Node(Node prev,Node next,int key,int val){
			this.prev=prev;
			this.next=next;
			this.val=val;
			this.key=key;
		}
	}

	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private int capacity;
	private int current = 0;
	private Node head;
	private Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head=this.tail=new Node(null,null,0,0);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node temp=map.get(key);
			removeNode(temp);
			addNode(temp);
			System.out.println(temp.val);
			return temp.val;
		}
		System.out.println( -1);
		return -1;
	}

	private void addNode(Node temp) {
		tail.next=temp;
		temp.prev=tail;
		temp.next=null;
		tail=temp;
	}

	public void set(int key, int value) {
		Node temp=map.get(key);
		if(temp==null){
			if (current == capacity) {
				removeListUsedItem();
			}
			current++;
			temp=new Node(null,null,key,value);
			addNode(temp);
		}else{
			removeNode(temp);
			addNode(temp);
			temp.val=value;
		}
	}

	private void removeListUsedItem() {
		Node temp=head.next; //get least used item
		removeNode(temp);
		map.remove(temp.key);
		current--;
	}

	private void removeNode(Node temp) {
		temp.prev=temp.next;
		if(temp.next!=null){
			temp.next.prev=temp.prev;
		}
	}

}

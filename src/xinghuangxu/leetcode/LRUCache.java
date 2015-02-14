package xinghuangxu.leetcode;

import java.util.HashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

	public static void main(String[] args) {
		LRUCache lru=new LRUCache(1);
//		for(int i=0;i<5000000;i++){
//			lru.set(i, i);
//		}
//		System.out.println("Done");
		lru.set(2,1);
		lru.get(2);
		lru.set(3, 2);
		lru.get(2);
		lru.get(3);
		
//		lru.set(2,1);
//		lru.set(1,1);
//		lru.get(2);
//		lru.set(4, 1);
//		lru.get(1);
//		lru.get(2);
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
		Node temp=map.get(key);
		if (temp!=null) {
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
			temp=new Node(null,null,key,value);
			addNode(temp);
			map.put(key,temp);
			current++;
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
		temp.prev.next=temp.next;
		if(temp.next!=null){
			temp.next.prev=temp.prev;
		}else{
			tail=temp.prev; //reconnect the tail
		}
	}

}

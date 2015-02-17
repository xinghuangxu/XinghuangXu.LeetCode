package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

import xinghuangxu.leetcode.Helper.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode pnrpen = new PopulatingNextRightPointersInEachNode();
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		pnrpen.connect(root);
		System.out.println();
	}

	public void connect(TreeLinkNode root) {
		if(root==null)return;
		TreeLinkNode empty=new TreeLinkNode(0),temp,next;
		Queue<TreeLinkNode> queue=new ArrayDeque<TreeLinkNode>();
		queue.add(root);
		queue.add(empty);
		while(!queue.isEmpty()){
			temp=queue.poll();
			if(temp==empty)break;
			next=queue.peek();
			if(temp.left!=null)queue.add(temp.left);
			if(temp.right!=null)queue.add(temp.right);
			if(next!=empty){
				temp.next=next;
			}else{
				queue.poll();
				queue.add(empty);
			}
		}
	}

}

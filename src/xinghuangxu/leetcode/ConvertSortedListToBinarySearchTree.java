package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

import xinghuangxu.leetcode.Helper.TreeNode;
import xinghuangxu.leetcode.Helper.ListNode;

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		int[] num={9,5,0,-3};
		ListNode ln=new ListNode(-10);
		for(int n:num){
			ln.add(n);
		}
		ConvertSortedListToBinarySearchTree cslbs=new ConvertSortedListToBinarySearchTree();
		TreeNode tn=cslbs.sortedListToBST(ln);
		
		TreeNode result=cslbs.sortedArrayToBST(num);
		System.out.println();

	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if(num==null||num.length==0)return null;
		return buildTree(0,num.length-1,num);
    }
	private TreeNode buildTree(int i, int j, int[] num) {
		if(i==j)return new TreeNode(num[i]);
		int mid=(i+j)/2;
		TreeNode m=new TreeNode(num[mid]);
		if(mid>i)m.left=buildTree(i,mid-1,num);
		if(mid<j)m.right=buildTree(mid+1,j,num);
		return m;
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)return null;
		List<ListNode> nodes=new ArrayList<ListNode>();
		ListNode temp=head;
		while(temp!=null){
			nodes.add(temp);
			temp=temp.next;
		}
		int N=nodes.size();
		return buildTree(0,N-1,nodes);
    }

	private TreeNode buildTree(int i, int j, List<ListNode> nodes) {
		if(i==j)return new TreeNode(nodes.get(i).val);
		int mid=(i+j)/2;
		TreeNode m=new TreeNode(nodes.get(mid).val);
		if(mid>i)m.left=buildTree(i,mid-1,nodes);
		if(mid<j)m.right=buildTree(mid+1,j,nodes);
		return m;
	}

}

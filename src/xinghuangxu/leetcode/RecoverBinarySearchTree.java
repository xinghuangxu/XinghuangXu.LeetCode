package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import xinghuangxu.leetcode.Helper.TreeNode;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
//		root.right=new TreeNode(1);
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right=new TreeNode(3);
		RecoverBinarySearchTree rbs=new RecoverBinarySearchTree();
		rbs.recoverTree(root);
		System.out.println();
	}
	
	/* 
	 * (lgn) space solution
	 */
	TreeNode prev,first,second;
	public void recoverTree(TreeNode root) {
		inorderFind(root);
		int temp=first.val;
		first.val=second.val;
		second.val=temp;
	}
	
	private void inorderFind(TreeNode n) {
		if(n==null)return;
		inorderFind(n.left);
		if(prev!=null&&prev.val>n.val&&first==null){
			first=prev;
		}
		if(first!=null&&prev.val>n.val){
			second=n;
		}
		prev = n;
		inorderFind(n.right);
	}
	
	/*
	 * Straight forward O(n) space solution
	
	List<TreeNode> nodes=new ArrayList<TreeNode>();
	List<Integer> num=new ArrayList<Integer>();
	public void recoverTree(TreeNode root) {
		findMisplacedTreeNode(root);
		Collections.sort(num);
		for(int i=0;i<nodes.size();i++){
			nodes.get(i).val=num.get(i);
		}
	}
	
	private void findMisplacedTreeNode(TreeNode root) {
		if(root==null)return;
		findMisplacedTreeNode(root.left);
		nodes.add(root);
		num.add(root.val);
		findMisplacedTreeNode(root.right);
	}
	 */

}

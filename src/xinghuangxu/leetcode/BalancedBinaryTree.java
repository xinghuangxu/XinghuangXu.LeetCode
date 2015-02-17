package xinghuangxu.leetcode;

import java.util.HashMap;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		root.left = new TreeNode(-2);
		root.left.right = new TreeNode(3);
		BalancedBinaryTree mdb = new BalancedBinaryTree();
		boolean rel = mdb.isBalanced(root);
		System.out.println(rel);
	}
	
	HashMap<TreeNode,Integer> depth = new HashMap<TreeNode,Integer>();
	public boolean isBalanced(TreeNode root) {
		getTreeDepth(root);
		return isTreeBalanced(root);
	}
	private boolean isTreeBalanced(TreeNode node) {
		if(node==null)return true;
		int left=0,right=0;
		if(node.left!=null){
			left=depth.get(node.left);
		}
		if(node.right!=null){
			right=depth.get(node.right);
		}
		if(Math.abs(left-right)>1)return false;
		if(isTreeBalanced(node.left)&&isTreeBalanced(node.right)){
			return true;
		}
		return false;
	}
	private int getTreeDepth(TreeNode node) {
		if(node==null)return 0;
		Integer d=depth.get(node);
		if(d==null){
			int leftDepth=getTreeDepth(node.left);
			int rightDepth=getTreeDepth(node.right);
			d=Math.max(leftDepth,rightDepth)+1;
			depth.put(node, d);
		}
		return d;
	}

}

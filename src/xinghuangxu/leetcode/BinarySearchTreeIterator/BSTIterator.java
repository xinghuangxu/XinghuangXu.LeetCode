package xinghuangxu.leetcode.BinarySearchTreeIterator;

import java.util.Stack;


public class BSTIterator {
	
	private Stack<TreeNode> stack=new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		processTreeNode(root);
	}
	

	private void processTreeNode(TreeNode node) {
		TreeNode temp=node;
		while(temp!=null){
			stack.push(temp);
			temp=temp.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(stack.isEmpty())
			return false;
		return true;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp=stack.pop();
		if(temp.right!=null){
			processTreeNode(temp.right);
		}
		return temp.val;
	}
}
package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import xinghuangxu.leetcode.Helper.*;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(2);
		SymmetricTree st=new SymmetricTree();
		System.out.println(st.isSymmetric(root));
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null)return true;
		if(root.left==null&&root.right==null)return true;
		if(root.left==null||root.right==null)return false;
		Stack<TreeNode> queue1=new Stack<TreeNode>();
		Stack<TreeNode> queue2=new Stack<TreeNode>();
		queue1.add(root.left);//stack 1 represent the left tree
		queue2.add(root.right);
		TreeNode temp1,temp2,empty=new TreeNode(0);
		while(!queue2.isEmpty()&&!queue1.isEmpty()){
			temp1=queue1.pop();
			temp2=queue2.pop();
			if(temp1.val!=temp2.val)return false;
			
			if(temp1.left!=null){
				queue1.push(temp1.left);
			}else if(temp1.right!=null){
				queue1.push(empty);
			}
			if(temp1.right!=null){
				queue1.push(temp1.right);
			}else if(temp1.left!=null){
				queue1.push(empty);
			}
			
			if(temp2.right!=null){
				queue2.push(temp2.right);
			}else if(temp2.left!=null){
				queue2.push(empty);
			}
			if(temp2.left!=null){
				queue2.push(temp2.left);
			}else if(temp2.right!=null){
				queue2.push(empty);
			}
		}
		if(queue2.isEmpty()&&queue1.isEmpty()){
			return true;
		}
		return false;
	}
	
	
	/*
	 * Recursive solution
	 */
//	public boolean isSymmetric(TreeNode root) {
//		if(root==null)return true;
//		return isTwoTreeSymmetric(root.left,root.right);
//	}
//
//	private boolean isTwoTreeSymmetric(TreeNode left, TreeNode right) {
//		if(left==null&&right==null)return true;
//		if(left==null||right==null)return false;
//		if(left.val!=right.val)return false;
//		return isTwoTreeSymmetric(left.left,right.right)&&isTwoTreeSymmetric(left.right, right.left);
//	}

}

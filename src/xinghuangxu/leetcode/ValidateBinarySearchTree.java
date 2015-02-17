package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2147483647);
//		root.left = new TreeNode(2);
//		root.right=new TreeNode(3);
		ValidateBinarySearchTree vbs=new ValidateBinarySearchTree();
		System.out.println(vbs.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root,Long min,Long max) {
		if(root==null)return true;
		if(min.compareTo((long) root.val)==-1&&max.compareTo((long) root.val)==1){
			return isValidBST(root.left,min,(long) root.val)&&isValidBST(root.right,(long) root.val,max);
		}
		return false;
	}
	

}

package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

import xinghuangxu.leetcode.Helper.TreeNode;

public class FlatternBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<TreeNode> nodes=new ArrayList<TreeNode>();
	public void flatten(TreeNode root) {
		if(root==null)return;
		preorder(root);
		for(int i=0;i<nodes.size()-1;i++){
			nodes.get(i).right=nodes.get(i+1);
			nodes.get(i).left=null;
		}
	}
	private void preorder(TreeNode node) {
		if(node==null)return;
		nodes.add(node);
		preorder(node.left);
		preorder(node.right);
	}
}

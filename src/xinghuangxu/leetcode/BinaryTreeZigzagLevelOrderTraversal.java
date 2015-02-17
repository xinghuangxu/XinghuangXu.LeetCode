package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		BinaryTreeZigzagLevelOrderTraversal btz=new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> rel=btz.zigzagLevelOrder(root);
		System.out.println();
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		if(root==null)return rel;
		Stack<TreeNode> stack1=new Stack<TreeNode>();
		Stack<TreeNode> stack2=new Stack<TreeNode>();
		boolean isStack=false;
		stack1.add(root);
		TreeNode temp;
		List<Integer> list=new ArrayList<Integer>();
		while(!stack2.isEmpty()||!stack1.isEmpty()){
			if(isStack&&stack2.isEmpty()){
				isStack=false;
				rel.add(list);
				list=new ArrayList<Integer>();
			}else if(!isStack&&stack1.isEmpty()){
				isStack=true;
				rel.add(list);
				list=new ArrayList<Integer>();
			}
			if(isStack){
				temp=stack2.pop();
				list.add(temp.val);
				if(temp.right!=null){
					stack1.add(temp.right);
				}
				if(temp.left!=null){
					stack1.add(temp.left);
				}
			}else{
				temp=stack1.pop();
				list.add(temp.val);
				if(temp.left!=null){
					stack2.add(temp.left);
				}
				if(temp.right!=null){
					stack2.add(temp.right);
				}
			}
		}
		if(list.size()>0)
			rel.add(list);
		return rel;
	}

}

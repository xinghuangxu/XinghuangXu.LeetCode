package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		int[] num = { 34, 12, 45, 6, 98, 23, 567 };
		TreeNode tn = new TreeNode(30);
		for(int i=0;i<num.length;i++){
			tn.add(num[i]);
		}
		BinaryTreePreorderTraversal btpt=new BinaryTreePreorderTraversal();
		List<Integer> l=btpt.preorderTraversal(tn);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
	}
	

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> nodes=new ArrayList<Integer>();
		if(root==null)return nodes;
		Stack<TreeNode> unexplored=new Stack<TreeNode>();
		unexplored.push(root);
		TreeNode temp;
		while(!unexplored.isEmpty()){
			temp=unexplored.pop();
			nodes.add(temp.val);
			if(temp.right!=null){
				unexplored.push(temp.right);
			}
			if(temp.left!=null){
				unexplored.push(temp.left);
			}
		}
		return nodes;
	}

}

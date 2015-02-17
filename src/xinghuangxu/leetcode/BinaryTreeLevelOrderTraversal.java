package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		root.left = new TreeNode(-2);
		root.left.right = new TreeNode(3);
		BinaryTreeLevelOrderTraversal btot=new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> rel=btot.levelOrderBottom(root);
		System.out.println();
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		if(root==null)return rel;
		Queue<TreeNode> queue =new ArrayDeque<TreeNode>();
		TreeNode temp,empty=new TreeNode(0),next;
		queue.add(root);
		queue.add(empty);
		List<Integer> seq=new ArrayList<Integer>();
		while(!queue.isEmpty()){
			temp=queue.poll();
			next=queue.peek();
			if(temp.left!=null)queue.add(temp.left);
			if(temp.right!=null)queue.add(temp.right);
			if(next==empty){
				seq.add(temp.val);
				rel.add(seq);
				seq=new ArrayList<Integer>();
				queue.poll();
				queue.add(empty);
			}else{
				seq.add(temp.val);
			}
		}
		List<List<Integer>> f=new ArrayList<List<Integer>>();
		for(int i=rel.size()-1;i>-1;i--){
			f.add(rel.get(i));
		}
		return f;
		
	}
}

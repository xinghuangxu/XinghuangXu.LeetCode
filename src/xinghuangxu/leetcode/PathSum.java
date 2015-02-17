package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

import xinghuangxu.leetcode.Helper.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(-3);
		root.left=new TreeNode(-2);
		root.right=new TreeNode(3);
		PathSum ps=new PathSum();
		 List<List<Integer>>  rel=ps.pathSum(root, -5);
		 System.out.println();
	}

	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		if(root==null)return rel;
		List<Integer> seq=new ArrayList<Integer>();
		findPathWithSum(root,sum,seq,rel);
		return rel;
	}


	private void findPathWithSum(TreeNode node, int res, List<Integer> seq,
			List<List<Integer>> rel) {
		if(node.val==res&&node.left==null&&node.right==null){
			seq.add(node.val);
			rel.add(new ArrayList<Integer>(seq));
		}else{
			seq.add(node.val);
			if(node.left!=null){
				findPathWithSum(node.left,res-node.val,seq,rel);
			}
			if(node.right!=null){
				findPathWithSum(node.right,res-node.val,seq,rel);
			}
		}
		seq.remove(seq.size()-1);
		
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		if(root==null)return false;
		List<Integer> seq=new ArrayList<Integer>();
		findPathWithSum(root,sum,seq,rel);
		if(rel.size()==0)return false;
		return true;
    }

}

package xinghuangxu.leetcode;

import java.util.HashMap;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	HashMap<TreeNode,Integer> map=new HashMap<TreeNode,Integer>();
	int maxSum;
	public int maxPathSum(TreeNode root) {
		maxSum=Integer.MIN_VALUE;
		preorder(root);
		return maxSum;
	}

	private void preorder(TreeNode node) {
		if(node==null)return;
		int sum=getMaxPathSumForSingleNode(node);
		if(sum>maxSum){
			maxSum=sum;
		}
		preorder(node.left);
		preorder(node.right);
//		sum.put(node,getMaxPathSumForSingleNode(node));
	}

	private int getMaxPathSumForSingleNode(TreeNode node) {
		int left=getMaxPathSum(node.left);
		int right=getMaxPathSum(node.right);
		return Math.max(Math.max(node.val, node.val+left+right), Math.max(node.val+left, node.val+right));
	}
	
	private int getMaxPathSum(TreeNode node) {
		if(node==null)return 0;
		Integer sum=map.get(node);
		if(sum==null){
			int left=getMaxPathSum(node.left);//null, positive, negative
			int right=getMaxPathSum(node.right);
			sum= Math.max(node.val+Math.max(left, right), Math.max(node.val, 0));
			map.put(node,sum);
		}
		return sum;
	}

}

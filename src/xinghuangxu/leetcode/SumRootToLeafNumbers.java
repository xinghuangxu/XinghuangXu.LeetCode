package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.TreeNode;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.add(2);
		root.add(3);
		SumRootToLeafNumbers srtln=new SumRootToLeafNumbers();
		System.out.println(srtln.sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
		return findSum(root,"");
	}

	private int findSum(TreeNode node, String sb) {
		if(node==null) return 0;
		sb=sb+node.val;
		if(node.left==null&&node.right==null){
			return Integer.parseInt(sb.toString());
		}else{
			return findSum(node.left,sb)+findSum(node.right,sb);
		}
	}
}

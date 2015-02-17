package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import xinghuangxu.leetcode.Helper.TreeNode;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(3);
		MinimumDepthOfBinaryTree mdb = new MinimumDepthOfBinaryTree();
		int rel = mdb.minDepth(root);
		System.out.println(rel);
	}

	public int minDepth(TreeNode root) {
		if(root==null)return 0;
		TreeNode empty = new TreeNode(0), temp, next;
		int level = 0;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		queue.add(empty);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			next = queue.peek();
			if (temp == empty) {
				level++;
			} else if (temp.left == null && temp.right == null) {
				break;
			}
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
			if (next == empty) {
				queue.add(empty);
			}
		}
		return level+1;
	}

}

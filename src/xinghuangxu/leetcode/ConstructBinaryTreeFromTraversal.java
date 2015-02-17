package xinghuangxu.leetcode;

import xinghuangxu.leetcode.Helper.TreeNode;

public class ConstructBinaryTreeFromTraversal {

	public static void main(String[] args) {
		int[] inorder = { 1, 2,3 };
		int[] postorder = { 3,2,1 };
		ConstructBinaryTreeFromTraversal cbtft = new ConstructBinaryTreeFromTraversal();
		TreeNode tn = cbtft.buildTreePreIn(inorder, postorder);
		System.out.println();
	}

	/*
	 * inorder: left mid right preorder: mid left right
	 */
	public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
		if (inorder.length == 0 || preorder.length == 0)
			return null;
		return buildTreeNodePreIn(0, inorder.length - 1, inorder, 0,
				preorder.length - 1, preorder);
	}

	private TreeNode buildTreeNodePreIn(int i, int j, int[] inorder, int k,
			int l, int[] preorder) {
		if (i == j)
			return new TreeNode(inorder[i]);
		int mid = preorder[k], mid1Index = j;
		// find mid in inorder list
		for (int m = i; m <= j; m++) {
			if (inorder[m] == mid) {
				mid1Index = m;
				break;
			}
		}
		int rightLength = j - mid1Index;
		TreeNode rel = new TreeNode(mid);
		if (mid1Index > i)
			rel.left = buildTreeNodePreIn(i, mid1Index - 1, inorder, 1+k, l
					- rightLength, preorder);
		if (rightLength != 0)
			rel.right = buildTreeNodePreIn(mid1Index + 1, j, inorder, l
					- rightLength + 1, l, preorder);
		return rel;
	}

	/*
	 * inorder: left mid right postorder: left right mid
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0)
			return null;
		return buildTreeNode(0, inorder.length - 1, inorder, 0,
				postorder.length - 1, postorder);
	}

	private TreeNode buildTreeNode(int i, int j, int[] inorder, int k, int l,
			int[] postorder) {
		if (i == j)
			return new TreeNode(inorder[i]);
		int mid = postorder[l], mid1Index = j;
		// find mid in inorder list
		for (int m = i; m <= j; m++) {
			if (inorder[m] == mid) {
				mid1Index = m;
				break;
			}
		}
		int rightLength = j - mid1Index;
		TreeNode rel = new TreeNode(mid);
		if (mid1Index > i)
			rel.left = buildTreeNode(i, mid1Index - 1, inorder, k, l
					- rightLength - 1, postorder);
		if (rightLength != 0)
			rel.right = buildTreeNode(mid1Index + 1, j, inorder, l
					- rightLength - 1, l - 1, postorder);
		return rel;
	}

}

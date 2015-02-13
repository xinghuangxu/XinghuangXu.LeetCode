package xinghuangxu.leetcode.BinarySearchTreeIterator;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 */

public class BinarySearchTreeIterator {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(12);
		int[] numlist={10,9,7,8,11,23,76,192,4,0};
		for(int i=0;i<numlist.length;i++){
			root.add(numlist[i]);
		}
		BSTIterator iterator = new BSTIterator(root);
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}
}

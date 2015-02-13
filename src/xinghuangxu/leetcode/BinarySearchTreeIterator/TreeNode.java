package xinghuangxu.leetcode.BinarySearchTreeIterator;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public void add(int i) {
		if(i>val){
			if(right!=null){
				right.add(i);
			}else{
				right=new TreeNode(i);
			}
		}else{
			if(left!=null){
				left.add(i);
			}else{
				left=new TreeNode(i);
			}
		}
	}
}
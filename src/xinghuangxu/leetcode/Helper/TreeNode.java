package xinghuangxu.leetcode.Helper;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public void add(int val){
		if(this.val>val){
			if(this.right==null){
				this.right=new TreeNode(val);
			}else{
				this.right.add(val);
			}
		}else{
			if(this.left==null){
				this.left=new TreeNode(val);
			}else{
				this.left.add(val);
			}
		}
	}
}

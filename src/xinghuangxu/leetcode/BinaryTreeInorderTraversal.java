package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right=new TreeNode(3);
		
		BinaryTreeInorderTraversal btit=new BinaryTreeInorderTraversal();
		List<Integer> rel=btit.inorderTraversal(root);
		System.out.println();
	}
	
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> rel=new ArrayList<Integer>();
		if(root==null)return rel;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        TreeNode temp;
        stack.push(root);
        while(!stack.isEmpty()){
        	 temp=stack.pop();
        	 if(temp.left==null||visited.contains(temp.left)){
        		 rel.add(temp.val);
        		 visited.add(temp);
        		 if(temp.right!=null){
        			 stack.push(temp.right);
        		 }
        	 }else{
        		 stack.push(temp);
        		 stack.push(temp.left);
        	 }
        }
        return rel;
    }

}

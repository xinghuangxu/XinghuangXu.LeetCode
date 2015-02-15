package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import xinghuangxu.leetcode.Helper.TreeNode;

public class BinarTreePostorderTraversal {

	public static void main(String[] arg) {
		int[] num = { 34, 12, 45, 6, 98, 23, 567 };
		TreeNode tn = new TreeNode(30);
		for(int i=0;i<num.length;i++){
			tn.add(num[i]);
		}
		BinarTreePostorderTraversal btpt=new BinarTreePostorderTraversal();
		List<Integer> l=btpt.postorderTraversal(tn);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i));
		}
	}
	
	

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> nodes=new ArrayList<Integer>();
		if(root==null)return nodes;
		Stack<TreeNode> unexplored=new Stack<TreeNode>();
		HashMap<TreeNode,Boolean> visited=new HashMap<TreeNode, Boolean>();
		unexplored.push(root);
		TreeNode temp;
		Boolean isLeft,isRight;
		while(!unexplored.isEmpty()){
			temp=unexplored.peek();
			isLeft=temp.left==null||visited.containsKey(temp.left);
			isRight=temp.right==null||visited.containsKey(temp.right);
			if(!isLeft){
				unexplored.push(temp.left);
			}else if (!isRight){
				unexplored.push(temp.right);
			}
			if(isLeft&&isRight){
				visited.put(temp, true);
				unexplored.pop();
				nodes.add(temp.val);
			}
		}
		return nodes;
	}
}

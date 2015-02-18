package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

import xinghuangxu.leetcode.Helper.TreeNode;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		UniqueBinarySearchTrees ubs = new UniqueBinarySearchTrees();
		List<TreeNode> rel=ubs.generateTrees(2);
		System.out.print(ubs.numTrees(2));

	}

	public List<TreeNode> generateTrees(int n) {
		int[] num = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			num[i] = i;
		}
		if(n==0){
			List<TreeNode> rel = new ArrayList<TreeNode>();
			rel.add(null);
			return rel;
		}
			
		return createTrees(1, n, num);
	}

	private List<TreeNode> createTrees(int i, int j, int[] num) {
		List<TreeNode> rel = new ArrayList<TreeNode>();
		List<TreeNode> leftTrees = null;
		List<TreeNode> rightTrees = null;
		TreeNode temp;
		for (int m = i; m <= j; m++) {
			leftTrees=null;
			rightTrees=null;
			if (m != i) {
				leftTrees = createTrees(i, m - 1, num);
			}
			if (m != j) {
				rightTrees = createTrees(m + 1, j, num);
			}
			if (leftTrees == null && rightTrees == null) {
				temp = new TreeNode(m);
				rel.add(temp);
			} else if (leftTrees == null) {
				for (int k = 0; k < rightTrees.size(); k++) {
					temp = new TreeNode(m);
					temp.right = rightTrees.get(k);
					rel.add(temp);
				}
			} else if (rightTrees == null) {
				for (int k = 0; k < leftTrees.size(); k++) {
					temp = new TreeNode(m);
					temp.left = leftTrees.get(k);
					rel.add(temp);
				}
			} else {
				for (int k = 0; k < leftTrees.size(); k++) {
					for (int z = 0; z < rightTrees.size(); z++) {
						temp = new TreeNode(m);
						temp.left = leftTrees.get(k);
						temp.right = rightTrees.get(z);
						rel.add(temp);
					}
				}
			}
		}
		return rel;
	}
	
	
	public int numTrees(int n) {
		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				num[i] += num[j - 1] * num[i - j];
			}
		}
		return num[n];
	}

}

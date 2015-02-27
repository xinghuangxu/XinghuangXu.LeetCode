package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] num = { -3, -1, 0, 2, 4, 5 };
		int target = 0;
		fs.fourSum(num, target);
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		Integer prevNum = null;
		Arrays.sort(num);
		for (int i = num.length - 1; i > 2; i--) {
			if (prevNum == null || prevNum != num[i]) {
				List<List<Integer>> list = threeSum(num, 0, i - 1, target
						- num[i]);
				for (List<Integer> l : list) {
					l.add(num[i]);
					rel.add(l);
				}
				prevNum = num[i];
			}
		}
		return rel;
	}

	public List<List<Integer>> threeSum(int[] num, int left, int right,
			int target) {
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		Integer prevNum = null;
		for (int i = left; i <= right - 2; i++) {
			if (prevNum == null || prevNum != num[i]) {

				int start = i + 1;
				int end = right;
				Integer preStart = null;
				while (start < end) {
					int sum = num[start] + num[end];
					if (sum + num[i] == target) {
						if (preStart == null || preStart != num[start]) {
							List<Integer> temp = new ArrayList<Integer>(3);
							temp.add(num[i]);
							temp.add(num[start]);
							temp.add(num[end]);
							rel.add(temp);
							preStart = num[start];
						}
						start++;
						end--;
					} else if (sum + num[i] > target) {
						end--;
					} else {
						start++;
					}

				}
			}
			prevNum = num[i];
		}
		return rel;
	}

}

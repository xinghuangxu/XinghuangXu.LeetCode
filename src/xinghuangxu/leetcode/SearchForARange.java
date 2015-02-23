package xinghuangxu.leetcode;

public class SearchForARange {

	public static void main(String[] args) {
		SearchForARange sfar = new SearchForARange();
		int[][] A = { { 5, 7, 7, 8, 8, 10 },{1} };
		int[] target = {6,1};
		for(int i=0;i<A.length;i++){
			int[] rel = sfar.searchRange(A[i], target[i]);
			for (int in : rel) {
				System.out.println(in + " ");
			}
		}
	}

	public int[] searchRange(int[] A, int target) {
		int left, right;
		left = binarySearch(0, A.length - 1, A, target, true);
		if (left != -1) {
			right = binarySearch(left, A.length - 1, A, target, false);
		} else {
			return new int[] { -1, -1 };
		}
		return new int[] { left, right };
	}

	private int binarySearch(int lo, int hi, int[] A, int target,
			boolean findLeft) {
		if (lo > hi) {
			return -1;
		}
		int mid = (lo + hi) / 2;
		if (A[mid] == target) {
			if (findLeft) {
				if (mid - 1 < 0 || A[mid - 1] != target) {
					return mid;
				} else {
					return binarySearch(lo, mid - 1, A, target, findLeft);
				}
			} else {
				if (mid + 1 >= A.length || A[mid + 1] != target) {
					return mid;
				} else {
					return binarySearch(mid + 1, hi, A, target, findLeft);
				}
			}
		} else if (A[mid] > target) {
			return binarySearch(lo, mid - 1, A, target, findLeft);
		} else {
			return binarySearch(mid + 1, hi, A, target, findLeft);
		}
	}

}

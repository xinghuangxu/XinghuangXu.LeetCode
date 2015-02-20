package xinghuangxu.leetcode;

public class Sqrtx {

	public static void main(String[] args) {
		Sqrtx s = new Sqrtx();
		System.out.println(s.sqrt(2147395600));
	}

	public int sqrt(int x) {
		int lo = 1, p = x / 4;
		while (p != 0 && p != 1) {
			lo = lo * 2;
			p = p / 4;
		}
		if (p == 1) {
			lo = lo * 2;
		}
		return binarySearch(x, lo, lo * 2);
	}
	
	/*
	 * use divide instead of multiplication
	 */
	private int binarySearch(int x, int lo, int hi) {
		if (lo > hi)
			return 0;
		int mid = (lo + hi) / 2;
		long rel = (long) mid * mid;
		long upperBound = (long) (mid + 1) * (mid + 1);
		if (rel <= x && upperBound > x) {
			return mid;
		} else if (rel > x) {
			return binarySearch(x, lo, mid - 1);
		} else {
			return binarySearch(x, mid + 1, hi);
		}

	}

	// public int sqrt(int x) {
	// return binarySearch(x,0,50000);
	//
	// }
	//
	// private int binarySearch(int x, int lo, int hi) {
	// if(lo>hi)return lo;
	// int mid=(lo+hi)/2;
	// long rel=mid*mid;
	// long upperBound=(mid+1)*(mid+1);
	// if(rel<=x&&upperBound>x){
	// return mid;
	// }else if (rel>x){
	// return binarySearch(x,lo,mid-1);
	// }else{
	// return binarySearch(x,mid+1,hi);
	// }
	//
	// }

}

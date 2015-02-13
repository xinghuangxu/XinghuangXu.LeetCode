package xinghuangxu.leetcode;

public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		System.out.println(ftz.trailingZeroes(0));
	}

	public int trailingZeroes(int n) {
		int zeros = 0;
		int m=n;
		while (m != 0) {
			m = m / 5;
			zeros = zeros + m;
		}
		return zeros;
	}

}

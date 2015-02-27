package xinghuangxu.leetcode;

import java.util.HashMap;

public class IntegerToRoman {
	public static void main(String[] args) {
		IntegerToRoman rti = new IntegerToRoman();
		System.out.println(rti.intToRoman(2345));
	}

	public String intToRoman(int num) {
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			if (num >= values[i]) {
				num = num - values[i];
				sb.append(symbols[i]);
				i--;
			}
		}
		return sb.toString();
	}
}

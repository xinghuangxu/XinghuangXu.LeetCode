package xinghuangxu.leetcode;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLastWord(String s) {
		int prev = 0, count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (count != 0) {
					prev = count;
					count = 0;
				}
			} else {
				count++;
			}
		}
		if (count == 0)
			return prev;
		return count;
	}

}

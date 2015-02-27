package xinghuangxu.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lstr = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lstr.lengthOfLongestSubstring("bbbbbbabbbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		int length = 0, start = 0;
		int[] fre = new int[256];
		for (int i = 0; i < s.length(); i++) {
			fre[s.charAt(i)]++;
			while (fre[s.charAt(i)] != 1) {
				fre[s.charAt(start)]--;
				start++;
			}
			if (i - start + 1 > length) {
				length = i - start + 1;
			}
		}
		return length;
	}

}

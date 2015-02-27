package xinghuangxu.leetcode;

import java.util.HashSet;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
//		 System.out.println(rem.isMatch("aa", "a")==false);
//		 System.out.println(rem.isMatch("aa", "aa")==true);
//		 System.out.println(rem.isMatch("aaa", "aa")==false);
		 System.out.println(rem.isMatch("aa", "a*")==true);
		 System.out.println(rem.isMatch("aa", ".*")==true);
		 System.out.println(rem.isMatch("ab", ".*")==true);
		 System.out.println(rem.isMatch("aab", "c*a*b")==true);
		 System.out.println(rem.isMatch("ab", ".*c")==false);
		 System.out.println(rem.isMatch("aaa", "ab*a")==false);
		System.out.println(rem.isMatch("a", "ab*") == true);
	}

	boolean found = false;

	public boolean isMatch(String s, String p) {
		found = false;
		visited=new HashSet<Integer>();
		checkMatch(s, 0, p, 0);
		return found;
	}
	HashSet<Integer> visited;

	private void checkMatch(String s, int sIndex, String p, int pIndex) {
		if(visited.contains(sIndex*31+pIndex))return;
		if (found)
			return;
		if (sIndex == s.length() && pIndex == p.length()) {
			found = true;
		}
		if (pIndex < p.length()) {
			if (pIndex + 1 >= p.length()) { // last pattern char or not
				if (sIndex < s.length()
						&& (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p
								.charAt(pIndex))) {
					checkMatch(s, sIndex + 1, p, pIndex + 1);
				}
			} else {
				int next = pIndex + 1;
				if (p.charAt(next) == '*') {
					// jump or not jump
					checkMatch(s, sIndex, p, pIndex + 2); // skip the whole
															// match
					// if character is needed can jump too
					if (sIndex < s.length()&&(p.charAt(pIndex) == '.'
							|| s.charAt(sIndex) == p.charAt(pIndex))) {
						checkMatch(s, sIndex + 1, p, pIndex); // jump don't
						checkMatch(s, sIndex + 1, p, pIndex + 2); // jump jump
					}
				} else {
					if (sIndex < s.length()&&(p.charAt(pIndex) == '.'
							|| s.charAt(sIndex) == p.charAt(pIndex))) {
						checkMatch(s, sIndex + 1, p, pIndex + 1);
					}
				}
			}
		}
		visited.add(sIndex*31+pIndex);
	}

}

package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> rel = pp.partition("amanaplanacanalpanama");
//		System.out.println(pp.minCut("ababababababababababababcbabababababababababababa"));

	}
	
	   HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		public int minCut(String s) {
			List<List<String>> rel=partition(s);
			int minCut=Integer.MAX_VALUE;
			for(List<String> l:rel){
				if(l.size()-1<minCut){
					minCut=l.size()-1;
				}
			}
			return minCut;
			
		}

		public List<List<String>> partition(String s) {
			List<List<String>> palindromes = new ArrayList<List<String>>();
			List<String> ls = breakPalindrome(s);
			for (String el : ls) {
				palindromes.add(Arrays.asList(el.split("\\s")));
			}
			return palindromes;

		}

		private List<String> breakPalindrome(String s) {
			List<String> palindromes = map.get(s);
			if (palindromes == null) {
				palindromes = new ArrayList<String>();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < s.length(); i++) {
					sb.append(s.charAt(i));
					if (isPalindrome(sb)) {
						if (sb.toString().equals(s)) {
							palindromes.add(s);
						} else {
							List<String> list = breakPalindrome(s.substring(i + 1));
							for (String cp : list) {
								palindromes.add(sb.toString() + " " + cp);
							}
						}
					}
				}
				map.put(s, palindromes);
			}
			return palindromes;
		}

		private boolean isPalindrome(StringBuilder sb) {
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
					return false;
				}
			}
			return true;
		}
}

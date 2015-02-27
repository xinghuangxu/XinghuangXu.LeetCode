package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		LongestPalindromicSubString lps = new LongestPalindromicSubString();
		System.out.println(lps.longestPalindrome("abb"));
	}
	
	/*
	 * Approach With Constant Space, Palindrome center around one or two letter(s)
	 */
	public String longestPalindrome(String s) {
		int size=s.length();
		int max=0,start=0;
		for(int l=1;l<=2;l++){
			for(int i=0;i<=size-l;i++){
				int begin=i, end=i+l-1;
				boolean isPalindrome=false;
				if(s.charAt(begin)==s.charAt(end)){
					isPalindrome=true;
				}
				while(begin>0&&end<size-1&&s.charAt(begin-1)==s.charAt(end+1)){
					begin--;
					end++;
				}
				if(isPalindrome&&end-begin+1>max){
					max=end-begin+1;
					start=begin;
				}
			}
		}
		return s.substring(start, start+max);
	}
	
	/*
	 * Dynamic Programming Approach
	 */
	public String longestPalindrome4(String s) {
		int size=s.length();
		boolean[][] dp=new boolean[size][size];
		for(int i=0;i<size;i++){
			dp[i][i]=true;
		}
		int L=2;
		int start=0,end=0;
		while(L<=size){
			for(int i=0;i<=size-L;i++){
				int j=i+L-1;
				if(s.charAt(i)==s.charAt(j)){
					if(j-i==1||dp[i+1][j-1]){
						dp[i][j]=true;
						start=i;
						end=j;
					}
				}else{
					dp[i][j]=false;
				}
			}
			L++;
		}
		return s.substring(start, end+1);
	}

	class Location implements Comparable<Location> {
		int x, y;
		int length;

		public Location(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}

		@Override
		public int compareTo(Location o) {
			if (this.length == o.length)
				return 0;
			if (this.length > o.length) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public String longestPalindrome3(String s) {
		// reverse string
		int size = s.length();
		int[][] L = new int[size + 1][size + 1];
		PriorityQueue<Location> pq = new PriorityQueue<Location>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (s.charAt(j) == s.charAt(size-i-1)) {
					L[i+1][j+1] = L[i ][j ] + 1;
				}
				if (L[i+1][j+1] > 0) {
					pq.add(new Location(i, j, L[i][j]));
				}
			}
		}
		while (!pq.isEmpty()) {
			Location temp = pq.poll();
			if (isPalindrome(s, temp.x-temp.length, temp.x)) {
				return s.substring(temp.x-temp.length, temp.x+1);
			}
		}
		return "";
	}
	
	private boolean isPalindrome(String s, Integer start, Integer end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	

	public String longestPalindrome1(String s) {
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		HashMap<Character, Boolean> visited = new HashMap<Character, Boolean>();
		List<Integer> list;
		for (int i = 0; i < s.length(); i++) {
			list = map.get(s.charAt(i));
			if (list == null) {
				list = new ArrayList<Integer>();
				map.put(s.charAt(i), list);
				visited.put(s.charAt(i), false);
			}
			list.add(i);
		}
		int maxLen = 0, start = 0;

		for (int i = 0; i < s.length(); i++) {
			if (visited.containsKey(s.charAt(i)) && !visited.get(s.charAt(i))) {
				list = map.get(s.charAt(i));
				for (int m = list.size() - 1; m > 0; m--) {
					for (int n = 0; n < m; n++) {
						if (list.get(m) - list.get(n) >= maxLen) {
							if (isPalindrome(s, list.get(n) + 1,
									list.get(m) - 1)) {
								maxLen = list.get(m) - list.get(n) + 1;
								start = list.get(n);
							}
						}
					}
				}
				visited.put(s.charAt(i), true);
			}
		}
		return s.substring(start, start + maxLen);
	}

	

}

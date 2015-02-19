package xinghuangxu.leetcode;

public class ScrambleString {

	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("hobobyrqd", "hbyorqdbo"));

	}

	public boolean isScramble(String s1, String s2) {
		int N = s1.length();
		if (N == 1 && s1.equals(s2)) {
			return true;
		} else if (N == 2
				&& (s2.equals(s1) || s2
						.equals(s1.charAt(1) + "" + s1.charAt(0)))) {
			return true;
		} else {
			String left;
			boolean rel=false;
			for (int i = 0; i < N-1; i++) {
				left = s1.substring(0, i + 1);
				if (isAnagram(left, s2.substring(0, i + 1))) {// if left
																// contains
					rel= isScramble(left, s2.substring(0, i + 1))
							&& isScramble(s1.substring(i + 1, N),
									s2.substring(i + 1, N));
				} else if (isAnagram(left, s2.substring(N - i - 1, N))) {
					rel= isScramble(left, s2.substring(N - i - 1, N))
							&& isScramble(s1.substring(i + 1, N),
									s2.substring(0, N - i - 1));
				}
				if(rel)return true;
			}
		}
		return false;
	}

	private boolean isAnagram(String s1, String s2) {
		while (s1.length() > 0) {
			char c = s1.charAt(0);
			for (int i = 0; i < s2.length(); i++) {
				if (c == s2.charAt(i)) {
					s2 = s2.substring(0, i) + s2.substring(i + 1);
					break;
				}
			}
			if (s2.length() == s1.length())
				return false;
			s1 = s1.substring(1);
		}
		return true;
	}

	/*
	 * HashMap<String,List<String>> scrambles=new
	 * HashMap<String,List<String>>(); public boolean isScramble(String s1,
	 * String s2) { findALlScrambles(s1); List<String> slist=scrambles.get(s1);
	 * if(slist.contains(s2)){ return true; } return false; } private
	 * List<String> findALlScrambles(String s1) { List<String>
	 * list=scrambles.get(s1); if(list==null){ list=new ArrayList<String>(); int
	 * N=s1.length(); if(N==1){ list.add(s1); }else if(N==2){ list.add(s1);
	 * list.add(s1.charAt(1)+""+s1.charAt(0)); }else{ List<String> left,right;
	 * for(int i=0;i<N-1;i++){ if(i==0){
	 * right=findALlScrambles(s1.substring(i+1)); for(String s:right){
	 * list.add(s1.charAt(i)+s); list.add(s+s1.charAt(i)); } }else if(i==N-2){
	 * left=findALlScrambles(s1.substring(0, i+1)); for(String s:left){
	 * list.add(s+s1.charAt(i+1)); list.add(s1.charAt(i+1)+s); } }else{
	 * left=findALlScrambles(s1.substring(0, i+1));
	 * right=findALlScrambles(s1.substring(i+1)); for(String t:left){ for(String
	 * s:right){ list.add(t+s); list.add(s+t); } } } } } scrambles.put(s1,
	 * list); } return list;
	 * 
	 * }
	 */

}

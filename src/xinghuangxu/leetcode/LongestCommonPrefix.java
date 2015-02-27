package xinghuangxu.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			prefix=getLongestCommonPrefix(prefix, strs[i]);
		}
		return prefix;
	}

	private String getLongestCommonPrefix(String prefix, String str) {
		StringBuilder sb=new StringBuilder();
		int length=Math.min(prefix.length(), str.length());
		for(int i=0;i<length;i++){
			if(prefix.charAt(i)==str.charAt(i)){
				sb.append(prefix.charAt(i));
			}else{
				break;
			}
		}
		return sb.toString();
	}

}

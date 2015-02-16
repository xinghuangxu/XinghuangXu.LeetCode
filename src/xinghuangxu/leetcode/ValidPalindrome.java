package xinghuangxu.leetcode;

public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome vp=new ValidPalindrome();
		Boolean result=vp.isPalindrome("1aA2");
		System.out.println(result.toString());
	}

	public boolean isPalindrome(String s) {
		StringBuilder sb=new StringBuilder();
		int N=s.length();
		for(int i=0;i<N;i++){
			char c=s.charAt(i);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
				sb.append(Character.toLowerCase(c));
			}
		}
		if(sb.length()==0)return true;
		for(int i=0;i<sb.length();i++){
			if(sb.charAt(i)!=sb.charAt(sb.length()-i-1)){
				return false;
			}
		}
		return true;
	}

}

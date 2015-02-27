package xinghuangxu.leetcode;

public class ImplementStrStr {

	public static void main(String[] args) {
		ImplementStrStr iss=new ImplementStrStr();
		System.out.println(iss.strStr("thefuck", "the"));
	}

	public int strStr(String haystack, String needle) {
		for(int i=0;i<=haystack.length()-needle.length();i++){
			int count=0;
			for(int j=0;j<needle.length();j++){
				if(haystack.charAt(i+j)==needle.charAt(j)){
					count++;
				}else{
					break;
				}
			}
			if(count==needle.length())return i;
		}
		return -1;
	}
	
	

}

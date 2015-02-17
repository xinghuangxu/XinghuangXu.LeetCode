package xinghuangxu.leetcode;

import java.util.HashMap;

public class InterleavingString {
	public static void main(String[] arg) {
		String s1 = "a";
		String s2 = "";
		String s3 = "a";
		
		InterleavingString is=new InterleavingString();
		System.out.println(is.isInterleave(s1, s2, s3));
	}
	
	HashMap<String,Boolean> mem=new HashMap<String, Boolean>();
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length())return false; //length not equal must be wrong
		if(s3.equals(""))return true;
		Boolean rel=mem.get(s1+":"+s2);
		if(rel==null){
			boolean left=false,right=false;
			if(s1.length()>0&&s1.charAt(0)==s3.charAt(0)){
				left=isInterleave(s1.substring(1), s2, s3.substring(1));
			}
			if(s2.length()>0&&s2.charAt(0)==s3.charAt(0)){
				right=isInterleave(s1, s2.substring(1), s3.substring(1));
			}
			rel= left||right;
			mem.put(s1+":"+s2, rel);
		}
		return rel;
		
	}
}

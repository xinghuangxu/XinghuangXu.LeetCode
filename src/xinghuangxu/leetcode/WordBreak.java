package xinghuangxu.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> set = new HashSet<String> ();
		String[] words={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for(String w: words){
			set.add(w);
		}
		System.out.println(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", set));
	}
	
	/*
	 * Need a revised solution
	 */
	private Set<String> dict;
	private HashMap<String, Boolean> record=new HashMap<String,Boolean>();

	public boolean wordBreak(String s, Set<String> dict) {
		this.dict=dict;
		return isWordConcat(s);
	}

	private boolean isWordConcat(String s) {
		if(record.containsKey(s))return record.get(s);
		StringBuilder part= new StringBuilder();
		for(int i=0;i<s.length();i++){
			part.append(s.charAt(i));
			if(dict.contains(part.toString())){
				if(i+1==s.length()||isWordConcat(s.substring(i+1))){
					record.put(s, true);
					return true;
				}
			}
		}
		record.put(s, false);
		return false;
	}
	
	

}

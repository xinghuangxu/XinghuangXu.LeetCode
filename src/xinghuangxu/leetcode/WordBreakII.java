package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		Set<String> set = new HashSet<String> ();
		String[] words={"cat", "cats", "and", "sand", "dog"};
		for(String w: words){
			set.add(w);
		}
		List<String> result=wb.wordBreak("catsanddog", set);
		for(String r:result){
			System.out.println(r);
		}
	}
	
	/*
	 * Need a revised solution
	 */
	private Set<String> dict;
	private HashMap<String, List<String>> record=new HashMap<String,List<String>>();

	public List<String> wordBreak(String s, Set<String> dict) {
		this.dict=dict;
		return getWords(s);
	}

	private List<String> getWords(String s) {
		if(record.containsKey(s))return record.get(s);
		List<String> l=new ArrayList<String>(),temp;
		StringBuilder part= new StringBuilder();
		for(int i=0;i<s.length();i++){
			part.append(s.charAt(i));
			if(dict.contains(part.toString())){
				if(i+1==s.length()){
					l.add(s);
				}else{
					temp=getWords(s.substring(i+1));
					for(String substr:temp){
						l.add(part.toString()+" "+substr);
					}
				}
			}
		}
		record.put(s , l);
		return l;
	}
	
}

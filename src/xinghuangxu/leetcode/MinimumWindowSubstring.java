package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String S="ADOBECODEBANC";
		String T="ABC";
		MinimumWindowSubstring mws=new MinimumWindowSubstring();
		System.out.println(mws.minWindow(S, T));
	}

	public String minWindow(String S, String T) {
		if(T.length()==0||S.length()==0)return "";
		HashMap<Character,List<Integer>> map=new HashMap<Character,List<Integer>>();
		for(int i=0;i<S.length();i++){
			List<Integer> count=map.get(S.charAt(i));
			if(count==null){
				count=new ArrayList<Integer>();
				map.put(S.charAt(i), count);
			}
			count.add(i);
		}
		char head=T.charAt(0);
		List<Integer> temp=map.get(head);
		String rel="",cur;
		for(int i=0;i<temp.size();i++){
			cur=findWindowWithStart(temp.get(i),map,T);
			if(rel==""||cur.length()<rel.length()){
				rel=cur;
			}
		}
		return rel;
	}

	private String findWindowWithStart(Integer index,
			HashMap<Character, List<Integer>> map, String T) {
		int lo=index,hi=index;
		List<Integer> temp;
		int max;
		for(int i=1;i<T.length();i++){
			max=Integer.MAX_VALUE;
			temp=map.get(T.charAt(i));
			if(temp==null){
				return "";
			}
			for(int j=0;j<temp.size();j++){
				
			}
		}
		return null;
	}

}

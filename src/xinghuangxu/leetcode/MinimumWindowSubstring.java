package xinghuangxu.leetcode;

import java.util.HashMap;



public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String S="cabwefgewcwaefgcf";
		String T="cae";
		MinimumWindowSubstring mws=new MinimumWindowSubstring();
		System.out.println(mws.minWindow(S, T));
	}
	
	public String minWindow(String S, String T) {
		int N=S.length(),M=T.length();
		HashMap<Character,Integer> needFilled=new HashMap<Character,Integer>();
		HashMap<Character,Integer> window=new HashMap<Character,Integer>();
		for(int i=0;i<M;i++){
			Integer fre=needFilled.get(T.charAt(i));
			if(fre==null){
				fre=0;
			}
			needFilled.put(T.charAt(i), ++fre);
			window.put(T.charAt(i),0);
		}
		int count=0,start=0,end=0,minLen=Integer.MAX_VALUE,minStar=0,minEnd=0,len;
		char c,d;
		while(end<N){
			c=S.charAt(end);
			if(needFilled.containsKey(c)){
				if(window.get(c)<needFilled.get(c)){ //missing from the window
					count++;
				}
				window.put(c, window.get(c)+1); //update the window count
				
				if(count==M){
					d=S.charAt(start);
					while(!needFilled.containsKey(d)||(needFilled.get(d)<window.get(d))){
						if(window.containsKey(d)){
							window.put(d, window.get(d)-1);
						}
						start++;
						d=S.charAt(start);
					}
					len=end-start;
					if(minLen>len){
						minStar=start;
						minEnd=end;
						minLen=len;
					}
				}
			}
			end++;
		}
		if(count!=0&&count==T.length())
			return S.substring(minStar, minEnd+1);
		return "";
	}

	
	/*
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
	*/

}

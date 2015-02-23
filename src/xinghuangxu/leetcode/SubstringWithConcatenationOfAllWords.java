package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords caw = new SubstringWithConcatenationOfAllWords();
		String S = "aaa";
		String[] L = { "a", "a"};
		List<Integer> rel = caw.findSubstring(S, L);
		for (Integer i : rel) {
			System.out.println(i);
		}
	}

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> rel = new ArrayList<Integer>();
		int N = L[0].length();
		if (S.length() < L.length * N)
			return rel;
		HashMap<String, Integer> origin = new HashMap<String, Integer>(),map;
		for (int i = 0; i < L.length; i++) {
			Integer temp = origin.get(L[i]);
			if (temp == null) {
				origin.put(L[i], 1);
			} else {
				origin.put(L[i], temp + 1);
			}
		}
		int total;
		for (int i = 0; i < N; i++) {
			Integer left = null, right = i;
			total = L.length;
			map=new HashMap<String,Integer>(origin);
			while (right + N <= S.length()) {
				String temp = S.substring(right, right + N);
				if (map.containsKey(temp)) {
					if (map.get(temp) > 0) {//found
						if(left==null){
							left=right;
						}
						map.put(temp, map.get(temp) - 1);
						total--;
						if(total==0){
							rel.add(left);
						}
					} else if (left != null && S.substring(left,left+N).equals(temp)) { //shrink the window
						left = left + N;
						if(total==0){
							rel.add(left);
						}
					}else{ //already has one, go back in time
						left=null;
						map=new HashMap<String,Integer>(origin);
						total = L.length;
						right=right-N;
					}
				}else {
					left=null;
					map=new HashMap<String,Integer>(origin);
					total = L.length;
				}
				right = right + N;
			}
		}
		return rel;
	}

	/*
	 * Slow Solution
	 * 
	 * int N; public List<Integer> findSubstring(String S, String[] L) {
	 * List<Integer> rel=new ArrayList<Integer>(); N=L[0].length();
	 * if(S.length()<L.length*N)return rel; //preprocessing String[] kgrams=new
	 * String[S.length()]; HashMap<String,List<Integer>> kgramMap=new
	 * HashMap<String,List<Integer>>(); for(int i=0;i<S.length()-N+1;i++){
	 * kgrams[i]=S.substring(i, i+N); List<Integer>
	 * list=kgramMap.get(kgrams[i]); if(list==null){ list=new
	 * ArrayList<Integer>(); kgramMap.put(kgrams[i],list); } list.add(i); }
	 * //relate word with index HashMap<String,Integer> lIndex=new
	 * HashMap<String,Integer>(); for(int i=0;i<L.length;i++){ Integer
	 * temp=lIndex.get(L[i]); if(temp==null){ lIndex.put(L[i],1); }else{
	 * lIndex.put(L[i],temp+1); } } //get a word as start int count=0,start;
	 * List<String> visitedK; for(int i=0;i<L.length;i++){ List<Integer>
	 * temp=kgramMap.get(L[i]); if(temp!=null){ lIndex.put(L[i],
	 * lIndex.get(L[i])-1); for(int j=0;j<temp.size();j++){ count=L.length-1;
	 * start=temp.get(j); visitedK=new ArrayList<String>();
	 * while(count!=0&&start+N<kgrams.length){ String k=kgrams[start+N];
	 * if(lIndex.containsKey(k)&&lIndex.get(k)>0){ lIndex.put(k,
	 * lIndex.get(k)-1); visitedK.add(k); start=start+N; count--; }else{ break;
	 * } } //return the map to its original state for(int
	 * m=0;m<visitedK.size();m++){ lIndex.put(visitedK.get(m),
	 * lIndex.get(visitedK.get(m))+1); } if(count==0){ rel.add(temp.get(j)); } }
	 * lIndex.put(L[i], lIndex.get(L[i])+1); } kgramMap.remove(L[i]); } return
	 * rel; }
	 * 
	 * // private boolean isStartingPoint(Integer start, // String[] kgrams, //
	 * HashMap<String, Integer> lIndex, int count) { // if(count==0){ // return
	 * true; // } // //look 3 steps ahead // if(start+N>=kgrams.length){ //
	 * return false; // } // String k=kgrams[start+N]; //
	 * if(lIndex.containsKey(k)&&lIndex.get(k)>0){ // lIndex.put(k,
	 * lIndex.get(k)-1); // if(isStartingPoint(start+N, kgrams, lIndex,
	 * count-1)){ // lIndex.put(k, lIndex.get(k)+1); // return true; // } //
	 * lIndex.put(k, lIndex.get(k)+1); // } // return false; // }
	 */
}

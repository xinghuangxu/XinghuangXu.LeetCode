package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords caw = new SubstringWithConcatenationOfAllWords();
		String S = "aaaaaaaa";
		String[] L = { "aa", "aa", "aa" };
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
		HashMap<String, Integer> origin = new HashMap<String, Integer>(), map = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			Integer temp = origin.get(L[i]);
			if (temp == null) {
				origin.put(L[i], 1);
			} else {
				origin.put(L[i], temp + 1);
			}
			map.put(L[i], 0);
		}

		for (int i = 0; i < N; i++) {
			Integer left = i, total = 0;
			Iterator<Entry<String, Integer>> it = map.entrySet()
					.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it
						.next();
				map.put(pair.getKey(), 0);
			}
			for (int j = i; j + N <= S.length(); j = j + N) {
				String temp = S.substring(j, j + N);
				if (origin.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) <= origin.get(temp)) {
						total++;
					} else {
						while (map.get(temp) > origin.get(temp)) {
							String str1 = S.substring(left, left + N);
							map.put(str1, map.get(str1) - 1);
							if (map.get(str1) < origin.get(str1)) {
								total--;
							}
							left = left + N;
						}
					}
					if (total == L.length) {
						rel.add(left);
						String str = S.substring(left, left + N);
						map.put(str, map.get(str) - 1);
						left += N;
						total--;
					}
				} else {
					// reset when the word doesn't exist in the List
					left = j + N;
					// reset the map
					it = map.entrySet()
							.iterator();
					while (it.hasNext()) {
						Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it
								.next();
						map.put(pair.getKey(), 0);
					}
					total = 0;
				}
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

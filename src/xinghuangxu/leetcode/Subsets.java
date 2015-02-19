package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		Subsets ss=new Subsets();
		int[] S={0};
		List<List<Integer>> rel=ss.subsets(S);
		System.out.println(rel.size());
	}

	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S); //make sure the input list is sorted
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		List<Integer> temp=new ArrayList<Integer>(),newList;
		rel.add(temp);
		int el;
		for(int i=0;i<S.length;i++){
			el=S[i];
			int N=rel.size();
			for(int j=0;j<N;j++){
				temp=rel.get(j);
				newList=new ArrayList<Integer>(temp);
				newList.add(el);
				rel.add(newList);
			}
		}
		return rel;
	}

}

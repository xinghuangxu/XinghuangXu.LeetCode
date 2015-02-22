package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] num={2,2,1,1};
		Permutations p=new Permutations();
		List<List<Integer>> rel=p.permuteUnique(num);
		System.out.println(rel.size());
	}
	/*
	 * This is permutations II
	 */
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		List<Integer> pools=new ArrayList<Integer>();
		for(int i=0;i<num.length;i++){
			pools.add(num[i]);;
		}
		List<Integer> aSol=new ArrayList<Integer>();
		getPermutations(pools,aSol,rel);
		return rel;
	}

	private void getPermutations(List<Integer> pools,List<Integer> aSol,List<List<Integer>> rel) {
		if(pools.size()==0){
			rel.add(new ArrayList<Integer>(aSol));
		}else{
			HashSet<Integer> map=new HashSet<Integer>();
			for(int i=0;i<pools.size();i++){
				if(!map.contains(pools.get(i))){
					Integer temp=pools.remove(i);
					aSol.add(temp);
					getPermutations(pools, aSol, rel);
					pools.add(i,temp);
					aSol.remove(aSol.size()-1);
					map.add(temp);
				}
			}
		}
	}

	/*
	 * Permutations 1
	 */
	
	
}

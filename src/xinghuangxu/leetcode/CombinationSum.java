package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = { 10,1,2,7,6,1,5 };
		int target = 8;
		List<List<Integer>> rel = cs.combinationSum2(candidates, target);
		System.out.println(rel.size());
	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<num.length;i++){
			if(map.containsKey(num[i])){
				map.put(num[i], map.get(num[i])+1);
			}else{
				map.put(num[i], 1);
			}
		}
		List<Integer> aSol = new ArrayList<Integer>();
		findCombinationSum2(0, num, target, aSol, rel,map);
		return rel;
	}

	private void findCombinationSum2(int loc, int[] candidates, int target,
			List<Integer> aSol, List<List<Integer>> rel, HashMap<Integer, Integer> map) {
		if (target == 0) {
			rel.add(new ArrayList<Integer>(aSol));
		} else if (loc >= candidates.length || target < candidates[loc]) {
			return;
		} else {
			int temp = candidates[loc], t = target,max=map.get(temp),added=0;
			findCombinationSum2(loc + max, candidates, target, aSol, rel,map);
			while (t >= temp&&added<max) {
				aSol.add(temp);
				t -= temp;
				findCombinationSum2(loc + max, candidates, t, aSol, rel,map);
				added++;
			}
			while(added!=0){
				aSol.remove(aSol.size() - 1);
				added--;
			}
		}
		
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		List<Integer> aSol = new ArrayList<Integer>();
		findCombinationSum(0, candidates, target, aSol, rel);
		return rel;
	}

	private void findCombinationSum(int loc, int[] candidates, int target,
			List<Integer> aSol, List<List<Integer>> rel) {
		if (target == 0) {
			rel.add(new ArrayList<Integer>(aSol));
		} else if (loc >= candidates.length || target < candidates[loc]) {
			return;
		} else {
			findCombinationSum(loc + 1, candidates, target, aSol, rel);
			int temp = candidates[loc], t = target, added = 0;
			while (t >= temp) {
				aSol.add(temp);
				t -= temp;
				findCombinationSum(loc + 1, candidates, t, aSol, rel);
				added++;
			}
			while (added != 0) {
				aSol.remove(aSol.size() - 1);
				added--;
			}
		}
	}

}

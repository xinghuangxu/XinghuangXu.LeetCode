package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		// TODO Auto-generated method stub
		int[] num = { -9,14,-7,-8,9,1,-10,-8,13,12,6,9,3,-3,-15,-15,1,8,-7,-4,-6,8,2,-10,8,11,-15,3,0,-11,-1,-1,10,0,6,5,-14,3,12,-15,-7,-5,9,11,-1,1,3,-15,-5,11,-12,-4,-4,-2,-6,-10,-6,-6,0,2,-9,14,-14,-14,-9,-1,-2,-7,-12,-13,-15,-4,-3,1,14,3,-12,3,3,-10,-9,-1,-7,3,12,-6,0,13,4,-15,0,2,6,1,3,13,8,-13,13,11,11,13,14,-6 };
		List<List<Integer>> rel = threeSum.threeSum(num);
	}
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		Integer prevNum=null;
		for(int i=0;i<=num.length-3;i++){
			if(prevNum==null||prevNum!=num[i]){
				if(num[i]<=0){
					int start=i+1;
					int end=num.length-1;
					Integer preStart=null;
					while(start<end){
						int sum=num[start]+num[end];
						if(sum+num[i]==0){
							if(preStart==null||preStart!=num[start]){
								List<Integer> temp = new ArrayList<Integer>(3);
								temp.add(num[i]);
								temp.add(num[start]);
								temp.add(num[end]);
								rel.add(temp);
								preStart=num[start];
							}
							start++;
							end--;
						}else if(sum+num[i]>0){
							end--;
						}else{
							start++;
						}
					}
				}
			}
			prevNum=num[i];
		}
		return rel;
	}

	public List<List<Integer>> threeSum3(int[] num) {
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> positive = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> negative = new HashMap<Integer, Integer>();
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		List<Integer> pos = new ArrayList<Integer>();
		List<Integer> neg = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] >= 0) {
				if (positive.containsKey(num[i]) && positive.get(num[i]) <= 1) {
					positive.put(num[i], 2);
					pos.add(num[i]);
				} else if (!positive.containsKey(num[i])) {
					positive.put(num[i], 1);
					pos.add(num[i]);
				}
			} else {
				if (negative.containsKey(num[i]) && negative.get(num[i]) <= 1) {
					negative.put(num[i], 2);
					neg.add(num[i]);
				} else if (!negative.containsKey(num[i])) {
					negative.put(num[i], 1);
					neg.add(num[i]);
				}
			}
		}
		// get two positives and try to
		Collections.sort(pos);
		Collections.sort(neg);
		for (int i = 0; i < pos.size(); i++) {
			for (int j = i + 1; j < pos.size(); j++) {
				if (!visited.containsKey(pos.get(i) + ":" + pos.get(j))) {
					int left = -(pos.get(i) + pos.get(j));
					if (negative.containsKey(left)) {
						List<Integer> temp = new ArrayList<Integer>(3);
						temp.add(left);
						temp.add(pos.get(i));
						temp.add(pos.get(j));
						rel.add(temp);
					}
				}
				visited.put(pos.get(i) + ":" + pos.get(j), true);
			}
		}

		for (int i = 0; i < neg.size(); i++) {
			for (int j = i + 1; j < neg.size(); j++) {
				if (!visited.containsKey(neg.get(j) + ":" + neg.get(i))) {
					int left = -(neg.get(i) + neg.get(j));
					if (positive.containsKey(left)) {
						List<Integer> temp = new ArrayList<Integer>(3);
						temp.add(neg.get(j));
						temp.add(neg.get(i));
						temp.add(left);
						rel.add(temp);
					}
				}
				visited.put(neg.get(j) + ":" + neg.get(i), true);
			}
		}
		return rel;
	}

	public List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> rel = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		for (int i = 0; i < num.length; i++) {
			map.put(num[i], i);
		}
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				String key = num[i] > num[j] ? num[j] + ":" + num[i] : num[i]
						+ ":" + num[j];
				if (!visited.containsKey(key)) {
					int left = -(num[i] + num[j]);
					if (map.containsKey(left) && map.get(left) != i
							&& map.get(left) != j) {
						List<Integer> temp = new ArrayList<Integer>(3);
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[map.get(left)]);
						rel.add(temp);
					}

				}
				visited.put(key, true);
			}
		}
		return rel;
	}

}

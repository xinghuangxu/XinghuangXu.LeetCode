package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum ts=new TwoSum();
		int[] numbers={0,3,2,0};
		int target=0;
		int[] rel=ts.twoSum(numbers, target);
		for(int i:rel){
			System.out.println(i);
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> second=new HashMap<Integer,Integer>();
		int[] rel=new int[2];
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])){
				second.put(numbers[i], i);
			}else{
				map.put(numbers[i], i);
			}
		}
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(target-numbers[i])){
				if(map.get(target-numbers[i])==i){
					if(second.containsKey(target-numbers[i])){
						rel[0]=i+1;
						rel[1]=second.get(target-numbers[i])+1;
						return rel;
					}
				}else{
					rel[0]=i+1;
					rel[1]=map.get(target-numbers[i])+1;
					return rel;
				}
				
			}
		}
		return rel;
	}

}

package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetII ss=new SubsetII();
		int[] num={5,5,5,5,5};
		List<List<Integer>> rel=ss.subsetsWithDup(num);
		System.out.println();
	}

	HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();

	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> rel = new ArrayList<List<Integer>>(), temp;
		List<Integer> link = new ArrayList<Integer>(),copy;
		rel.add(link);// add empty set
		if (num.length == 0)
			return rel;
		int N = num.length,size,prevNum=Integer.MAX_VALUE,repeatCount = 0;
		for (int i = 0; i < N; i++) {
			if(prevNum==num[i]){
				repeatCount++;
			}else{
				repeatCount=1;
			}
			temp = map.get(num[i]);
			if (temp == null) {
				temp=new ArrayList<List<Integer>>();
				size=rel.size();
				for(int j=0;j<size;j++){
					copy= new ArrayList<Integer>(rel.get(j));
					copy.add(num[i]);
					temp.add(copy);
					rel.add(copy);
				}
				map.put(num[i],temp);
			} else {
				size=temp.size();
				for (int j=0;j<size;j++) {
					copy= new ArrayList<Integer>(temp.get(j));
					copy.add(num[i]);
					if(isValidRepeat(copy,num[i],repeatCount)){
						temp.add(copy);
						rel.add(copy);
					}
				}
			}
			prevNum=num[i];
		}
		return rel;
	}

	private boolean isValidRepeat(List<Integer> copy, int num, int repeatCount) {
		if(copy.size()>=repeatCount&&copy.get(copy.size()-repeatCount)==num)return true;
		return false;
	}

	/*
	 * HashMap<Integer,List<List<String>>> map=new
	 * HashMap<Integer,List<List<String>>>(); public List<List<Integer>>
	 * subsetsWithDup(int[] num) { HashMap<Integer,Integer> fre=new
	 * HashMap<Integer,Integer>(); for(int i=0;i<num.length;i++){
	 * if(fre.containsKey(num[i])){ fre.put(num[i],fre.get(num[i])); }else{
	 * fre.put(num[i],1); } } List<Integer> number=new ArrayList<Integer>();
	 * Iterator<Entry<Integer, Integer>> it = fre.entrySet().iterator(); while
	 * (it.hasNext()) { Map.Entry<Integer,Integer> pair =
	 * (Map.Entry<Integer,Integer>)it.next(); number.add(pair.getKey());
	 * it.remove(); // avoids a ConcurrentModificationException }
	 * Collections.sort( number ); List<List<Integer>> rel=new
	 * ArrayList<List<Integer>>(); List<Integer> temp=new ArrayList<Integer>();
	 * rel.add(temp);//add empty set
	 * 
	 * 
	 * return createSubset(0,number.size()-1,number); } private
	 * List<List<Integer>> createSubset(int low,int high,List<Integer> number) {
	 * List<List<Integer>> rel=new ArrayList<List<Integer>>();
	 * List<List<Integer>> temp; if(low==high){ List<Integer> list=new
	 * ArrayList<Integer>(); list.add(number.get(low)); rel.add(list); }else{
	 * int start=number.get(low); temp=createSubset(low+1, high, number); }
	 * return null; }
	 */
}

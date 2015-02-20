package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c=new Combinations();
		List<List<Integer>> rel=c.combine(5, 5);
		System.out.println(rel.size());
	}
	
	public List<List<Integer>> combine(int n, int k) {
		return createCominations(1,n,k);
	}

	private List<List<Integer>> createCominations(int lo,int hi, int k) {
		List<List<Integer>> ret,result=new ArrayList<List<Integer>>();
		if(lo>hi)return result;
		if(k==1){
			for(int i=lo;i<=hi;i++){
				List<Integer> list=new ArrayList<Integer>();
				list.add(i);
				result.add(list);
			}
			return result;
		}
		for(int i=lo;i<=hi;i++){
			ret=createCominations(i+1,hi,k-1);
			if(ret!=null){
				for(List<Integer> l:ret){
					l.add(0,i);
					result.add(l);
				}
			}
		}
		return result;
	}

//	public List<List<Integer>> combine(int n, int k) {
//		List<List<Integer>> rel=new ArrayList<List<Integer>>();
//		if(k==0)return rel;
//		Queue<Integer> temp=new ArrayDeque<Integer>();
//		for(int i=1;i<=n;i++){
//			temp.add(i);
//		}
//		return createCominations(temp,k);
//	}
//
//	private List<List<Integer>> createCominations(Queue<Integer> temp, int k) {
//		List<List<Integer>> ret,result=new ArrayList<List<Integer>>();
//		if(k==1){
//			while(!temp.isEmpty()){
//				List<Integer> list=new ArrayList<Integer>();
//				list.add(temp.poll());
//				result.add(list);
//			}
//			return result;
//		}
//		while(!temp.isEmpty()){
//			int el=temp.poll();
//			ret=createCominations(new ArrayDeque<Integer>(temp),k-1);
//			if(ret!=null){
//				for(List<Integer> l:ret){
//					l.add(0,el);
//					result.add(l);
//				}
//			}
//		}
//		return result;
//	}

}

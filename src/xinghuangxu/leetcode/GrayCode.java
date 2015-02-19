package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GrayCode {

	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		List<Integer> rel=gc.grayCode(3);
		for(Integer i:rel){
			System.out.println(i);
		}
	}

	public List<Integer> grayCode(int n) {
		if(n<=1){
			List<Integer> rel = new ArrayList<Integer>();
			if (n == 0) {
				rel.add(0);
				return rel;
			} else {
				rel.add(0);
				rel.add(1);
				return rel;
			}
		}
		 else {
			List<Integer> temp=grayCode(n-1);
			int N=temp.size();
			for(int i=N-1;i>-1;i--){
				temp.add(temp.get(i)|(1<<(n-1)));
			}
			return temp;
		}

	}
	/*
	 * 
	 * public List<Integer> grayCode(int n) { List<Stack<Integer>> count=new
	 * ArrayList<Stack<Integer>>(); Stack<Integer> temp=new Stack<Integer>();
	 * temp.add(0); if(n==0)return temp; count.add(temp); HashSet<Integer>
	 * hashset=new HashSet<Integer>(); int copy,newCopy; for(int i=1;i<n;i++){
	 * Stack<Integer> newList=new Stack<Integer>(); temp=count.get(i-1); for(int
	 * k=0;k<temp.size();k++){ copy=temp.get(k); for(int j=n-1;j>-1;j--){
	 * newCopy=setBit(copy,j); if(newCopy!=copy&&!hashset.contains(newCopy)){
	 * newList.add(newCopy); hashset.add(newCopy); } } } count.add(newList); }
	 * temp=new Stack<Integer>(); temp.add((int) (Math.pow(2, n)-1));
	 * count.add(temp);
	 * 
	 * List<Integer> rel=new ArrayList<Integer>(); Stack<Integer>
	 * l1=count.get(0),l2=count.get(1),tempStack; int nextIndex=2;
	 * while(!l1.isEmpty()){ rel.add(l1.pop()); tempStack=l1; l1=l2;
	 * l2=tempStack; if(l1.isEmpty()&&nextIndex<=n){ l1=count.get(nextIndex);
	 * nextIndex++; }else if (l2.isEmpty()&&nextIndex<=n){
	 * l2=count.get(nextIndex); nextIndex++; } } return rel; }
	 * 
	 * private int setBit(int copy, int j) { return (1<<j)|copy; }
	 */

	// private List<String> getGrayCode(int n) {
	// List<String> rel=new ArrayList<String>();
	// if(n==1){
	// rel.add("0");
	// rel.add("1");
	// }else{
	// List<String> temp=getGrayCode(n-1);
	// for(String t:temp){
	// rel.add('0'+t);
	// rel.add('1'+t);
	// }
	// }
	// return rel;
	// }
	//
	// int NumberOfSetBits(int i) {
	// i = i - ((i >> 1) & 0x55555555);
	// i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
	// return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
	// }

}

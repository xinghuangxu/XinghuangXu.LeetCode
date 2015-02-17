package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle pt=new PascalTriangle();
//		 List<List<Integer>> rel=pt.generate(5);
		List<Integer> rel=pt.getRow(3);
		 System.out.println();
	}
	
	 public List<Integer> getRow(int rowIndex) {
		 	List<Integer> prev=new ArrayList<Integer>(),cur;
			prev.add(1);
			 if(rowIndex==0)return prev;
			for(int i=1;i<rowIndex+1;i++){
				cur=new ArrayList<Integer>();
				cur.add(1);
				for(int j=1;j<i;j++){
					cur.add(prev.get(j-1)+prev.get(j));
				}
				cur.add(1);
				prev=cur;
			}
			return prev;
	    }

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rel=new ArrayList<List<Integer>>();
		if(numRows==0)return rel;
		List<Integer> temp=new ArrayList<Integer>(),newList;
		temp.add(1);
		rel.add(temp);
		for(int i=1;i<numRows;i++){
			temp=rel.get(i-1);
			newList=new ArrayList<Integer>();
			newList.add(1);
			for(int j=1;j<i;j++){
				newList.add(temp.get(j-1)+temp.get(j));
			}
			newList.add(1);
			rel.add(newList);
		}
		return rel;
	}

}

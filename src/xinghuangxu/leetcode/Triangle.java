package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		int[][] data = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		List<List<Integer>> triangle=new ArrayList<List<Integer>>();
		for(int i=0;i<data.length;i++){
			List<Integer> l=new ArrayList<Integer>();
			for(int j=0;j<data[i].length;j++){
				l.add(data[i][j]);
			}
			triangle.add(l);
		}
		Triangle t= new Triangle();
		System.out.println(t.minimumTotal(new ArrayList<List<Integer>>(triangle)));
	}
	
	 public int minimumTotal(List<List<Integer>> triangle) {
	        int N=triangle.size();
	        int[][] minp=new int[N][N];
	        for(int i=0;i<N;i++){
	        	minp[N-1][i]=triangle.get(N-1).get(i);
	        }
	        for(int i=N-2;i>-1;i--){
	        	for(int j=0;j<triangle.get(i).size();j++){
	        		minp[i][j]=triangle.get(i).get(j)+Math.min(minp[i+1][j], minp[i+1][j+1]);
	        	}
	        }
	        return minp[0][0];
	    }

}

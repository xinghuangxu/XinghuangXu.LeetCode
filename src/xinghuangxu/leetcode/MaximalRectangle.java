package xinghuangxu.leetcode;

import java.util.Arrays;
import java.util.Stack;



public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { { '1', '0', '1', '1' }, { '0', '1', '1', '1' },
				{ '0', '1', '1', '1' }, { '1', '1', '1', '1' } };
//		char[][] matrix = { {  '1', '1' } };
		MaximalRectangle mr = new MaximalRectangle();
		System.out.println(mr.maximalRectangle(matrix));
	}
	
	/*
	 * reuse the largest rectangle in Histogram solution
	 */
	public int maximalRectangle(char[][] matrix) {
		//build the height graph
		if(matrix==null||matrix.length==0)return 0;
		int m = matrix.length, n = matrix[0].length,max=0;
		int[][] height=new int[n][m];
		for(int i=n-1;i>-1;i--){
			for(int j=0;j<m;j++){
				if(matrix[j][i]=='1'){
					height[i][j]=i==n-1?1:height[i+1][j]+1;
				}
			}
		}
		
		//use the largest rectangle in histogram solution
		for(int i=0;i<n;i++){
			max=Math.max(max, largestRectangleArea(height[i]));
		}
		return max;
	}
	
	public int largestRectangleArea(int[] height) {
		int N = height.length, max=0,top=0;
		Stack<Integer> stack = new Stack<Integer>();
		int[] h=Arrays.copyOf(height, height.length+1);
		for (int i = 0; i <= N;) {
			if (stack.isEmpty() || h[i] > h[stack.peek()]) {
				stack.push(i++);
			} else {
				top = stack.pop();
				max = Math.max(max,
						h[top] * (stack.isEmpty()?i:i - stack.peek()-1));
			}
		}
		return max;
	}
	
	/*
	 * This is a bad solution
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix==null||matrix.length==0)return 0;
		int m = matrix.length, n = matrix[0].length,max=0,rel=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				max=expandNode(i,j,matrix,m,n);
				if(rel<max)
					rel=max;
			}
		}
		return rel;
	}
	private int expandNode(int i, int j, char[][] matrix, int m, int n) {
		int temp=0,max=0;
		for(int k=j;k<m;k++){
			if(matrix[k][i]=='1'){
				temp=getArea(i,j,matrix,m,n,k);
				if(temp>max){
					max=temp;
				}
			}else{
				return max;
			}
		}
		return max;
	}
	private int getArea(int i, int j, char[][] matrix, int m, int n, int k) {
		int sum=0;
		boolean allOne=true;
		for(int a=i;a<n;a++){
			for(int b=j;b<k+1;b++){
				if(matrix[b][a]!='1'){
					allOne=false;
				}
			}
			if(allOne==true){
				sum+=k-j+1;
			}else{
				return sum;
			}
		}
		return sum;
	}
	
	 */
	
	/*
	class Area{
		int x1,y1;
		int x2,y2;
		int area;
		boolean hasMerged;
		Area(int x1,int y1,int x2,int y2,int area){
			this.x1=x1;
			this.x2=x2;
			this.y1=y1;
			this.y2=y2;
			this.area=area;
			this.hasMerged=false;
		}
	}
	
	public int maximalRectangle(char[][] matrix) {
		// initialize a matrix to keep track of the count
				if(matrix==null||matrix.length==0)return 0;
				int m = matrix.length, n = matrix[0].length;
				int[][] counter = new int[m + 2][n + 2];
				List<Area> areas=new ArrayList<Area>();
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						if (matrix[i][j] == '1') {
							areas.add(new Area(i+1,j+1,i+1,j+1,1));
						}
					}
				}
				boolean foundNewMerge=true;
				while(foundNewMerge){
					foundNewMerge=false;
					for(int i=0;i<areas.size();i++){
						
					}
				}
	}
	
	/*
	 * Solution for max square
	 

	class Location {
		int i;
		int j;

		public Location(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public int maximalRectangle(char[][] matrix) {
		// initialize a matrix to keep track of the count
		if(matrix==null||matrix.length==0)return 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] counter = new int[m + 2][n + 2];

		Queue<Location> rel = new ArrayDeque<Location>();
		Queue<Location> temp = new ArrayDeque<Location>(),median;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					rel.add(new Location(i, j));
					counter[i][j] = 1;
				}
			}
		}
		if (rel.size() == 0)
			return 0;
		int currentMax = 2;
		Location location;
		while (rel.size() != 0) {
			while (rel.size() != 0) {
				location = rel.poll();
				if (isGrowing(location, currentMax, counter)) {
					counter[location.i][location.j] = currentMax;
					temp.add(location);
				}
			}
			if(temp.size()==0)break;
			currentMax++;
			median=temp;
			temp=rel;
			rel = median;
		}
		return currentMax - 1;
	}

	private boolean isGrowing(Location location, int currentMax, int[][] counter) {
		int prevMax = currentMax - 1;
		int i = location.i, j = location.j;
		if (currentMax % 2 == 0) {
			if ((counter[i - 1][j - 1] >= prevMax
					&& counter[i - 1][j] >= prevMax && counter[i][j - 1] >= prevMax)
					|| (counter[i - 1][j] >= prevMax
							&& counter[i - 1][j + 1] >= prevMax && counter[i][j + 1] >= prevMax)
					|| (counter[i][j - 1] >= prevMax
							&& counter[i + 1][j - 1] >= prevMax && counter[i + 1][j] >= prevMax)
					|| (counter[i][j + 1] >= prevMax
							&& counter[i + 1][j] >= prevMax && counter[i + 1][j + 1] >= prevMax)) {
				return true;
			}
		} else {
			prevMax--;
			if(currentMax!=3){
				if (counter[i - 1][j - 1] >= prevMax
						&& counter[i - 1][j + 1] >= prevMax
						&& counter[i + 1][j - 1] >= prevMax
						&& counter[i + 1][j + 1] >= prevMax)
					return true;
			}
			if (counter[i - 1][j - 1] >= prevMax
					&& counter[i - 1][j + 1] >= prevMax
					&& counter[i + 1][j - 1] >= prevMax
					&& counter[i + 1][j + 1] >= prevMax
					&& counter[i - 1][j] >= prevMax
					&& counter[i][j + 1] >= prevMax
					&& counter[i - 1][j] >= prevMax
					&& counter[i][j - 1] >= prevMax) {
				return true;
			}
		}
		return false;
	}
	*/
}

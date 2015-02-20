package xinghuangxu.leetcode;

import java.util.PriorityQueue;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid={
				{1,2,3},
				{3,6,1},
				{9,8,9}
		};
		MinimumPathSum mps=new MinimumPathSum();
		System.out.println(mps.minPathSum(grid));
	}
	
	class Node implements Comparable<Node>{
		int i,j,cost;
		Node(int i,int j,int cost){
			this.i=i;
			this.j=j;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node node) {
			if(this.cost>node.cost){
				return 1;
			}else if(this.cost==node.cost){
				return 0;
			}else{
				return -1;
			}
		}
	}

	public int minPathSum(int[][] grid) {
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		pq.add(new Node(0,0,grid[0][0]));
		int M=grid.length,N=grid[0].length;
		boolean[][] visited=new boolean[M][N];
		while(!pq.isEmpty()){
			Node temp=pq.poll();
			if(temp.i==M-1&&temp.j==N-1){
				return temp.cost;
			}
			if(temp.j+1<N&&!visited[temp.i][temp.j+1]){ //moving right
				visited[temp.i][temp.j+1]=true;
				pq.add(new Node(temp.i,temp.j+1,temp.cost+grid[temp.i][temp.j+1]));
			}
			if(temp.i+1<M&&!visited[temp.i+1][temp.j]){ //moving down
				visited[temp.i+1][temp.j]=true;
				pq.add(new Node(temp.i+1,temp.j,temp.cost+grid[temp.i+1][temp.j]));
			}
		}
		return 0;
	}

}

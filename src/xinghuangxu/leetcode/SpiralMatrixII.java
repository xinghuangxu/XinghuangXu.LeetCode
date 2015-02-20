package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SpiralMatrixII {

	public static void main(String[] args) {
		SpiralMatrixII sm=new SpiralMatrixII();
		int[][] rel=sm.generateMatrix(0);
		System.out.println();
	}

	class Direction {
		int x, y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		boolean[][] visited = new boolean[n + 2][n + 2];
		for (int i = 0; i < n + 2; i++) {
			visited[i][0] = true;
			visited[0][i] = true;
			visited[i][n + 1] = true;
			visited[n + 1][i] = true;
		}
		Queue<Direction> direction = new ArrayDeque<Direction>();
		direction.add(new Direction(1, 0));
		direction.add(new Direction(0, 1));
		direction.add(new Direction(-1, 0));
		direction.add(new Direction(0, -1));
		int i=0,j=-1,val=1;
		while(true){
			Direction d=direction.poll();
			if(visited[i+d.y+1][j+d.x+1]){
				break;
			}
			while(!visited[i+d.y+1][j+d.x+1]){
				i=i+d.y;
				j=j+d.x;
				visited[i+1][j+1]=true;
				matrix[i][j]=val;
				val++;
			}
			direction.add(d);
		}
		return matrix;
	}

}

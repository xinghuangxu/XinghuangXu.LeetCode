package xinghuangxu.leetcode;

public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(1, 2));
		int[][] obstacleGrid = {{1}};//{ { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] steps = new int[m + 1][n + 1];
		steps[0][1] = 1;
		for (int i = 1; i <= m; i++) {
			if (obstacleGrid[i - 1][0] == 1){
				steps[i][1] = 0;
			}else{
				steps[i][1] = steps[i-1][1];
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				if (obstacleGrid[i - 1][j - 1] == 1) {
					steps[i][j] = 0;
				} else {
					steps[i][j] = steps[i][j - 1] + steps[i - 1][j];
				}
			}
		}
		return steps[m][n];
	}

	public int uniquePaths(int m, int n) {
		int[][] steps = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			steps[i][1] = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				steps[i][j] = steps[i][j - 1] + steps[i - 1][j];
			}
		}
		return steps[m][n];
	}

}

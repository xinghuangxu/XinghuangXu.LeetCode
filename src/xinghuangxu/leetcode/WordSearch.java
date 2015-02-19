package xinghuangxu.leetcode;

import java.util.Stack;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		String a="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		char[][] board = new char[10][a.length()];
//		for(int i=0;i<10;i++){
//			for(int j=0;j<a.length();j++){
//				board[i][j]='a';
//			}
//		}
		char[][] board={
				{'a','b'},
				{'c','d'}
		};
		String word = "abcd";
		System.out.println(ws.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		int m = board.length, n = board[0].length;
		Stack<Character> stack = new Stack<Character>();
		for (int i = word.length() - 1; i > -1; i--) {
			stack.push(word.charAt(i));
		}
		char[][] newBoard = new char[m + 2][n + 2];
		visited = new boolean[m + 2][n + 2];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				newBoard[i][j] = board[i - 1][j - 1];
			}
		}
		char c=stack.pop();
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (newBoard[i][j] == c) {
					if (findIfExist(i, j, stack, newBoard)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	int[] xdirections = { 1, 0, -1, 0 };
	int[] ydirections = { 0, 1, 0, -1 };
	boolean[][] visited;
	int N = 4;

	private boolean findIfExist(int x, int y, Stack<Character> stack,
			char[][] board) {
		visited[x][y] = true;
		if (stack.isEmpty())
			return true;
		int nx, ny;
		char c = stack.pop();
		for (int i = 0; i < N; i++) {
			nx = x + xdirections[i];
			ny = y + ydirections[i];
			if ((!visited[nx][ny]) && board[nx][ny] == c) {
				if (findIfExist(nx, ny, stack, board)) {
					return true;
				}
			}
		}
		stack.push(c);
		visited[x][y] = false;
		return false;
	}

}

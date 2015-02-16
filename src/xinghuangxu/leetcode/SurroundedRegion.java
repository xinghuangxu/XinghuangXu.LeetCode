package xinghuangxu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegion {

	public static void main(String[] args) {
		// char[][] board = new char[][] { { 'X', 'X', 'X', 'X' },
		// { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'X' } };
		char[][] board = new char[][] { { 'O', 'X', 'X','O','X' }, { 'X','O','O', 'X', 'O' },
				{'X', 'O', 'X','O','X' } ,{'O', 'X', 'O','O','O' },{'X', 'X', 'O','X','O' }};
		SurroundedRegion sr = new SurroundedRegion();
		sr.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		
		List<Node> xmod=findBlocked(board, 'X');
		for(Node n:xmod){
			board[n.i][n.j]='X';
		}
	}

	private List<Node> findBlocked(char[][] board, char c) {
		List<Node> mod=new ArrayList<Node>();
		Boolean[][] block = new Boolean[board.length][board[0].length];
		Node temp;
		int rel;
		List<Node> secondCard=new ArrayList<Node>();
		Queue<Node> cards = new ArrayDeque<Node>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == c) {
					block[i][j] = true;
				} else {
					temp=new Node(i, j);
					cards.add(temp);
					secondCard.add(temp);
				}
			}
		}
		
		while (!cards.isEmpty()) {
			temp = cards.poll();
			rel = isBlock(temp.i, temp.j, board, block);
			if (rel == 1) {
				block[temp.i][temp.j] = true;
				mod.add(temp);
			} else {
				if (rel == -1) {
					block[temp.i][temp.j] = false;
				} else if (rel == 0) {
					block[temp.i][temp.j] = true;
					cards.add(temp);
				}
			}
		}
		boolean redo=true;
		while(redo){
			redo=false;
			for(Node t:secondCard){
				if(isBlock(t.i, t.j, board, block)==-1&&block[t.i][t.j]){
					block[t.i][t.j]=false;
					mod.remove(t);
					redo=true;
				}
			}
		}
		return mod;
	}

	private int isBlock(int i, int j, char[][] board, Boolean[][] block) {
		if (i <= 0 || i >= board.length - 1 || j <= 0
				|| j >= board[0].length - 1)
			return -1;

		if (block[i - 1][j] == null || block[i + 1][j] == null
				|| block[i][j - 1] == null || block[i][j + 1] == null) {
			return 0;
		}
		if (block[i - 1][j] == false || block[i + 1][j] == false
				|| block[i][j - 1] == false || block[i][j + 1] == false) {
			return -1;
		}
		if (block[i - 1][j] == true && block[i + 1][j] == true
				&& block[i][j - 1] == true && block[i][j + 1] == true) {
			return 1;
		}
		return 0;
	}

}

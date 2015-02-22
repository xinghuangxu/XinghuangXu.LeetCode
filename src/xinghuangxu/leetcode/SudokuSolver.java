package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
	}

	int N = 9;

	class Line {
		boolean[] used = new boolean[N];

		void use(int lo) {
			used[lo] = true;
		}

		void unuse(int lo) {
			used[lo] = false;
		}

		boolean isUnused(int num) {
			return used[num] == false;
		}
	}

	class Node {
		int i, j,val;
		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	class Block extends Line {
		List<Node> freeNodes = new ArrayList<Node>();
		List<Integer> nums = new ArrayList<Integer>();
		int i, j;

		Block(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public void addFreeNode(Node node) {
			freeNodes.add(node);
		}

		public void preprocess() {
			for (int i = 0; i < N; i++) {
				if (isUnused(i)) {
					nums.add(i);
				}
			}
		}
	}

	public void solveSudoku(char[][] board) {
		Line[] rows = new Line[N];
		for (int i = 0; i < N; i++) {
			rows[i] = new Line();
			for (int j = 0; j < N; j++) {
				if (board[i][j] != '.') {
					if (board[i][j] != '.')
						rows[i].use(board[i][j] - '1');
				}
			}
		}
		Line[] columns = new Line[N];
		for (int i = 0; i < N; i++) {
			columns[i] = new Line();
			for (int j = 0; j < N; j++) {
				if (board[j][i] != '.') {
					if (board[j][i] != '.')
						columns[i].use(board[j][i] - '1');
				}
			}
		}
		int BlockSize = 3;
		Block[] blocks = new Block[N];
		List<Node> allNode = new ArrayList<Node>();
		Node temp = null;
		for (int i = 0; i < N; i = i + 3) {
			for (int j = 0; j < N; j = j + 3) {
				blocks[3 * (i / 3) + j / 3] = new Block(i, j);
				for (int m = i; m < i + BlockSize; m++) {
					for (int n = j; n < j + BlockSize; n++) {
						if (board[m][n] != '.') {
							blocks[3 * (i / 3) + j / 3].use(board[m][n] - '1');
						} else {
							temp = new Node(m, n);
							allNode.add(temp);
							blocks[3 * (i / 3) + j / 3].addFreeNode(temp);
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			blocks[i].preprocess();
		}
		if (SearchForSolution(0, blocks, rows, columns)) {
			for(int i=0;i<allNode.size();i++){
				temp=allNode.get(i);
				board[temp.i][temp.j]=(char) (temp.val+'1');
			}
		}
	}

	private boolean SearchForSolution(int loc, Block[] blocks, Line[] rows,
			Line[] columns) {
		
		if (loc == 9)
			return true;
		List<Node> freeNodes = blocks[loc].freeNodes;
		boolean rel = false;
		int tNum = blocks[loc].nums.remove(0); // get num
		for (int j = 0; j < freeNodes.size(); j++) { // search for possible
														// locations
			Node tNode = freeNodes.get(j);
			if (rows[tNode.i].isUnused(tNum) && columns[tNode.j].isUnused(tNum)) {
				// put that number on that block,row and column
				tNode.val=tNum;
				freeNodes.remove(j);
				rows[tNode.i].use(tNum);
				columns[tNode.j].use(tNum);
				if (blocks[loc].nums.size() == 0) {
					rel = SearchForSolution(loc + 1, blocks, rows, columns);
				} else {
					rel = SearchForSolution(loc, blocks, rows, columns);
				}
				if (rel)
					return true;
				rows[tNode.i].unuse(tNum);
				columns[tNode.j].unuse(tNum);
				freeNodes.add(j, tNode);
			}
		}
		blocks[loc].nums.add(tNum);
		return false;
	}

}

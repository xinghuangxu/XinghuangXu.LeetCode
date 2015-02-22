package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import xinghuangxu.leetcode.NQueens.Location;

public class NQueensII {

	public static void main(String[] args) {
		NQueensII nqueen = new NQueensII();
		System.out.println(nqueen.totalNQueens(5));
		System.out.println();
	}

	class Location {
		int i, j;

		Location(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public int totalNQueens(int n) {
		boolean[][] visited = new boolean[n][n]; // keep track of visited rows
		List<Integer> rowNumber = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			rowNumber.add(i);
		}
		List<Location> locations = new LinkedList<Location>();
		placeQueens(rowNumber, n, locations, visited);
		return solution;
	}

	int solution =0;

	
	private void placeQueens(List<Integer> rowNumber, int n,
			List<Location> locations, boolean[][] visited) {
		if (n == 0) {
			solution++;
			// System.out.println(locations.size());
		} else {
			for (int i = 0; i < rowNumber.size(); i++) {
				int row = rowNumber.get(i);
				Location newLocation = new Location(row, n);
				if (setValidPosition(newLocation, visited, true)) {
					rowNumber.remove(i);
					locations.add(newLocation);
					placeQueens(rowNumber, n - 1, locations, visited);
					locations.remove(newLocation);
					rowNumber.add(i, row);
					setValidPosition(newLocation, visited, false);
				}
			}
		}

	}

	private boolean setValidPosition(Location temp, boolean[][] found, boolean set) {
		int size = found.length;
		if (set) {
			int i = temp.i - 2, j = temp.j - 2;
			while (i >= 0 && i < size && j >= 0 && j < size) { // check left up
																// diagnal
				if (found[i][j]) {
					return false;
				}
				i--;
				j--;
			}
			i = temp.i;
			j = temp.j;
			while (i >= 0 && i < size && j >= 0 && j < size) { // check right
																// down diagnal
				if (found[i][j]) {
					return false;
				}
				i++;
				j++;
			}
			i = temp.i;
			j = temp.j - 2;
			while (i >= 0 && i < size && j >= 0 && j < size) { // check left
																// down diagnal
				if (found[i][j]) {
					return false;
				}
				i++;
				j--;
			}

			i = temp.i - 2;
			j = temp.j;
			while (i >= 0 && i < size && j >= 0 && j < size) { // check right up
																// diagnal
				if (found[i][j]) {
					return false;
				}
				i--;
				j++;
			}
		}
		found[temp.i - 1][temp.j - 1] =set;
		return true;
	}

}

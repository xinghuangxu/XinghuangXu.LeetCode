package xinghuangxu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		NQueens nqueen = new NQueens();
		nqueen.solveNQueens(5);
		System.out.println();
	}

	class Location {
		int i, j;

		Location(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	List<List<Location>> solution = new ArrayList<List<Location>>();

	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<String[]>();
		int[][] visited = new int[n][n]; // keep track of visited rows
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		List<Integer> rowNumber = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			rowNumber.add(i);
		}
		List<Location> locations = new LinkedList<Location>();
		placeQueens(rowNumber, n, locations, visited);
		for(List<Location> sol:solution){
			String[] aSol=new String[n];
			for(Location l:sol){
				board[l.i-1][l.j-1]='Q';
			}
			for(int i=0;i<n;i++){
				aSol[i]=String.valueOf(board[i]);
			}
			for(Location l:sol){
				board[l.i-1][l.j-1]='.';
			}
			result.add(aSol);
		}
		return result;
	}

	private void placeQueens(List<Integer> rowNumber, int n,
			List<Location> locations, int[][] visited) {
		if (n == 0) {
			solution.add(new ArrayList<Location>(locations));
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

	private boolean setValidPosition(Location temp, int[][] found,
			boolean set) {
		int size = found.length;
		if (set) {
			int i=temp.i-2,j=temp.j-2;
			while(i>=0&&i<size&&j>=0&&j<size){ //check left up diagnal
				if(found[i][j]>0){
					return false;
				}
				i--;
				j--;
			}
			i=temp.i;
			j=temp.j;
			while(i>=0&&i<size&&j>=0&&j<size){ //check right down diagnal
				if(found[i][j]>0){
					return false;
				}
				i++;
				j++;
			}
			i=temp.i;
			j=temp.j-2;
			while(i>=0&&i<size&&j>=0&&j<size){ //check left down diagnal
				if(found[i][j]>0){
					return false;
				}
				i++;
				j--;
			}
			
			i=temp.i-2;
			j=temp.j;
			while(i>=0&&i<size&&j>=0&&j<size){ //check right up diagnal
				if(found[i][j]>0){
					return false;
				}
				i--;
				j++;
			}
		}
		found[temp.i-1][temp.j-1]=set?found[temp.i-1][temp.j-1]+1:found[temp.i-1][temp.j-1]-1;
		return true;
	}

	// private boolean setValidPosition(Location temp, boolean[][] found,
	// boolean set) {
	// int size = found.length;
	// if (set) {
	// if (temp.j + temp.i - size > 0
	// && found[size - 1][temp.j + temp.i - size - 1]) { // left
	// // bottom
	// return false;
	// }
	// if (temp.j - 1 - temp.i + size >= 0
	// && found[size - 1][temp.j - 1 - temp.i + size]) {// right
	// // bottom
	// return false;
	// }
	// if (temp.j - temp.i >= 0 && found[0][temp.j - temp.i]) { // left top
	// return false;
	// }
	// if (temp.i + temp.j - size > 0
	// && found[temp.i + temp.j - size - 1][size - 1]) { // right
	// // top
	// return false;
	// }
	// }
	// // set found
	// if (temp.j + temp.i - size > 0) { // left bottom
	// found[size - 1][temp.j + temp.i - size - 1] = set;
	// }
	// if (temp.j - 1 - temp.i + size >= 0) {// right bottom
	// found[size - 1][temp.j - 1 - temp.i + size] = set;
	// }
	// if (temp.j - temp.i >= 0) { // left top
	// found[0][temp.j - temp.i] = true;
	// }
	// if (temp.i + temp.j - size > 0) { // right top
	// found[temp.i + temp.j - size - 1][size - 1] = set;
	// }
	// found[temp.i - 1][temp.j - 1] = set;
	// return true;
	// }

	// private boolean isSolution(List<Location> locations) {
	// int size=locations.size();
	// boolean[][] found=new boolean[size+2][size+2];
	// for(int i=0;i<locations.size();i++){
	// Location temp=locations.get(i);
	// int dif=size-temp.i;
	// if(found[temp.i+dif][temp.j-dif]){ //left bottom
	// return false;
	// }
	// found[temp.i+dif][temp.j-dif]=true;
	// dif=size-temp.j;
	// if(found[temp.i+dif][temp.j+dif]){//right bottom
	// return false;
	// }
	// found[temp.i+dif][temp.j+dif]=true;
	// dif=temp.j-1;
	// if(found[temp.i-dif][temp.j-dif]){ //left top
	// return false;
	// }
	// found[temp.i-dif][temp.j-dif]=true;
	// dif=temp.i-1;
	// if(found[temp.i-dif][temp.j+dif]){ //right top
	// return false;
	// }
	// found[temp.i-dif][temp.j+dif]=true;
	// }
	// return true;
	// }

	private boolean isSolution(List<Location> locations) {
		int size = locations.size();
		boolean[][] found = new boolean[size][size];
		for (int i = 0; i < locations.size(); i++) {
			Location temp = locations.get(i);
			int dif = size - temp.i;
			if (found[temp.i - 1 + dif][temp.j - 1 - dif]) { // left bottom
				return false;
			}
			found[temp.i - 1 + dif][temp.j - 1 - dif] = true;
			dif = size - temp.j;
			if (found[temp.i - 1 + dif][temp.j - 1 + dif]) {// right bottom
				return false;
			}
			found[temp.i - 1 + dif][temp.j - 1 + dif] = true;
			dif = temp.j - 1;
			if (found[temp.i - dif][temp.j - dif]) { // left top
				return false;
			}
			found[temp.i - dif][temp.j - dif] = true;
			dif = temp.i - 1;
			if (found[temp.i - dif][temp.j + dif]) { // right top
				return false;
			}
			found[temp.i - dif][temp.j + dif] = true;
		}
		return true;
	}

}

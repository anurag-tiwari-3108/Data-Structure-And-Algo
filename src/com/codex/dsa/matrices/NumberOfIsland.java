package com.codex.dsa.matrices;
/**
 * Island from matrix using DFS and BFS *
 * Time complexity would be O(N)
 * Space Complexity would be O(1) Constant but in worst case it can be O(MN) where MN are matrix Row/Col Length
 */
public class NumberOfIsland {
	public static void main(String[] args) {
		NumberOfIsland islandObj = new NumberOfIsland();
		char[][] mat = {
				{ '1', '1', '1', '1', '0' }, 
				{ '1', '1', '0', '1', '0' }, 
				{ '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, 
				{ '0', '0', '0', '0', '0' } 
				};
		System.out.println("No of island is " + islandObj.getCountOfIsland(mat));
	}

	private int getCountOfIsland(char[][] islandGrid) {

		int row = islandGrid.length;
		if (row == 0)
			return 0;
		int col = islandGrid[0].length;
		int result = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (islandGrid[i][j] == '1') {
					DFS(islandGrid, i, j);
					result++;
				}
			}
		}
		return result;
	}

	private static void DFS(char[][] islandGrid, int row, int col) {

		int H = islandGrid.length;
		int L = islandGrid[0].length;

		if (row < 0 || col < 0 || row >= H || col >= L || islandGrid[row][col] != '1')
			return;
		islandGrid[row][col] = '2'; // marking it visited this can be anything but not 1 as we are processing only 1.
		DFS(islandGrid, row + 1, col); // go right
		DFS(islandGrid, row - 1, col); // go left
		DFS(islandGrid, row, col + 1); // go down
		DFS(islandGrid, row, col - 1); // go up
	}

}

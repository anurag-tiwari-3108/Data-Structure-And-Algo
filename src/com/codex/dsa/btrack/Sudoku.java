package com.codex.dsa.btrack;

/**
 * Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign
 * digits (from 1 to 9) to the empty cells so that every row, column, and
 * subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9.
 * 
 * @author anutiwar
 *
 */
public class Sudoku {

	static int N = 9;
	static int[][] sudoku;

	public static void main(String[] args) {

		sudoku = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		if (solveSudoko(sudoku))
			BacktrackUtil.printMatrix(sudoku, N);
		else
			System.out.println("No Solution Available");
	}

	public static int[] getBlankCellLocation() {
		int[] cell = new int[2]; // cell[0]-row cell[1] -column
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					cell[0] = i;
					cell[1] = j;
					return cell;
				}
			}
		}
		cell[0] = -1;
		cell[1] = -1;
		return cell; // means grid is full
	}

	private static boolean isSafe(int row, int col, int idx) {

		if (!UsedInRow(row, idx) && !UsedInColumn(col, idx) && !UsedInBox(row - row % 3, col - col % 3, idx)) {
			return true;
		}
		return false;
	}

	// check if n not in particular row
	public static boolean UsedInRow(int row, int n) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == n) {
				return true;
			}
		}
		return false;
	}

	// check if n not in particular column
	public static boolean UsedInColumn(int col, int n) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == n) {
				return true;
			}
		}
		return false;
	}

	// check if n not in particular box
	public static boolean UsedInBox(int boxStartRow, int boxStartCol, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[i + boxStartRow][j + boxStartCol] == n) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean solveSudoko(int[][] sudoku) {

		int row, col;
		int[] blankCell = getBlankCellLocation();

		row = blankCell[0];
		col = blankCell[1];

		if (row == -1) {
			// means will have filled the grid, return;
			return true;
		}

		for (int i = 1; i <= N; i++) {
			if (isSafe(row, col, i)) {
				sudoku[row][col] = i;

				if (solveSudoko(sudoku)) {
					return true;
				}

				sudoku[row][col] = 0;
			}
		}

		return false;
	}

}

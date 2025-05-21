package com.codex.dsa.matrices;
/**
 * you are given a matrix and you need to replace all the 2;s in that matrix
 * which is surrounded by 1 from upper-lower-left-right side.
 * 
 * {{1, 1, 1, 1}, {1, 2, 2, 1}, {1 ,1, 1, 1}, {1, 2, 1, 1}, {1, 2, 2, 2}};
 * 
 * this matrix should be converted to
 * 
 * {{1, 1, 1, 1}, {1, 1, 1, 1}, {1 ,1, 1, 1}, {1, 2, 1, 1}, {1, 2, 2, 2}};
 * 
 * @author anutiwar
 *
 */
public class ReplaceEncounteredElement {
	static int N = 4;
	static int M = 4;

	public static void main(String[] args) {
		int mat[][] = // { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 2, 2, 1 }, { 1, 1, 1, 1 }, { 1, 2, 1,
						// 1 } };
				{ { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 2, 1, 1 }, { 1, 2, 2, 2 } };

		maxtrix(mat);
		for (int i = 0; i < mat.length; i++) {
			System.out.println();
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + "  ");
			}
		}
	}

	public static void maxtrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (isAquire(i, j, mat)) {
					mat[i][j] = 1;
				}
			}
		}
	}

	private static boolean isAquire(int row, int col, int[][] mat) {

		if (mat[row][col] == 2) {
			if (isAquire(row - 1, col, mat) && isAquire(row + 1, col, mat) && isAquire(row, col - 1, mat)
					&& isAquire(row, col + 1, mat)) {
				return true;
			} else if (row > 0 && col > 0 && row < N + 1 && col < M + 1) {
				while (row > 0 && col > 0) {
					// if (isAquire(row--, col, mat)) {
					return true;
					// }
				}
				while (row < N) {
					if (isAquire(row++, col, mat)) {
						return true;
					}
				}
				while (col > 0 && row > 0) {
					if (isAquire(row, col++, mat)) {
						return true;
					}
				}
				while (col < M) {
					if (isAquire(row, col++, mat)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}

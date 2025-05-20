package com.codex.dsa.btrack;

import java.util.Arrays;

/**
 * Placing N-Queen in such a way that  no 2 Queen share  the same row/column/diagonal
 Q  –  –  –  –  –  –  –
  –  –  –  –  Q  –  –  –
  –  –  –  –  –  –  –  Q
  –  –  –  –  –  Q  –  –
  –  –  Q  –  –  –  –  –
  –  –  –  –  –  –  Q  –
  –  Q  –  –  –  –  –  –
  –  –  –  Q  –  –  –  –
  
 * @author anutiwar
 *
 */
public class NQueen {
	public static int N = 8;

	public static void main(String[] args) {
		char[][] mat = new char[N][N];
		for (int i = 0; i < 8; i++) {
			Arrays.fill(mat[i], '_');
		}
		placeNQueen(mat, 0);
	}
	// backtracking
	public static void placeNQueen(char[][] mat, int r) {
		if (N == r) {
			BacktrackUtil.printCharMatrix(mat);
		}

		for (int i = 0; i < N; i++) {
			if (isSafe(mat, r, i)) {
				mat[r][i] = 'Q';
				placeNQueen(mat, r + 1);
				mat[r][i] = '_';
			}
		}

	}

	public static boolean isSafe(char[][] mat, int r, int c) {

		for (int i = 0; i < r; i++) {
			if (mat[i][c] == 'Q') {
				return false;
			}
		}
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (mat[i][j] == 'Q') {
				return false;
			}
		}
		// return false if two queens share the same `/` diagonal
		for (int i = r, j = c; i > 0 && j < N; i--, j++) {
			if (mat[i][j] == 'Q') {
				return false;
			}
		}


		return true;
	}
}

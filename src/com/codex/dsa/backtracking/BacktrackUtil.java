package com.codex.dsa.btrack;

import java.util.Arrays;

public class BacktrackUtil {

	public static void printIntMatrix(int[][] sol, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + sol[i][j] + " ");

			System.out.println();
		}
	}

	public static void printCharMatrix(char[][] mat) {

		for (int i = 0; i < 8; i++) {
			System.out.println(Arrays.toString(mat[i]).replaceAll(",", ""));
		}
		System.out.println();

	}

	public static void printMatrix(int[][] grid, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print("  "+grid[i][j] + "  ");
			System.out.println();
		}
	}
}

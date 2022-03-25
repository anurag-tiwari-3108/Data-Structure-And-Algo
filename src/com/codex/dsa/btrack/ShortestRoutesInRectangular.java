package com.codex.dsa.btrack;

import java.util.Stack;

/**
 * Print all the shortest Paths in Matrix Grid
 * @author anutiwar
 *
 */
public class ShortestRoutesInRectangular {
	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("*******");
		BacktrackUtil.printIntMatrix(mat, 3);
		System.out.println("*******");
		printPaths(mat);
	}

	private static void printPaths(int[][] mat) {
		Stack<Integer> route = new Stack<>();
		printPaths(mat, route, 0, 0);
	}

	private static void printPaths(int[][] mat, Stack<Integer> route, int row, int col) {

		int M = mat.length;
		int N = mat[0].length;

		// include current cell in route
		route.add(mat[row][col]);

		// if the last cell is reached
		if (row == M - 1 && col == N - 1) {
			System.out.println(route);
		} else {

			if (row + 1 < M)
				printPaths(mat, route, row + 1, col);
			if (col + 1 < N)
				printPaths(mat, route, row, col + 1);
			if (row + 1 < M && col + 1 < N)
				printPaths(mat, route, row + 1, col + 1);

		}
		route.pop();
	}
}

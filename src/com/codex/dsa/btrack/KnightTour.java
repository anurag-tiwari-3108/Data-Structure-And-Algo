package com.codex.dsa.btrack;

import java.util.Arrays;

/**
 * Given a N*N board with the Knight placed on the first block of an empty
 * board. Moving according to the rules of chess knight must visit each square
 * exactly once. Print the order of each the cell in which they are visited.
 * 
 * A knight always moves in L shape
 * 
 * @author anutiwar
 *
 */
public class KnightTour {

	public static final int N = 5;
	public static final int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
	public static final int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };

	public static void main(String[] args) {
		int visited[][] = new int[N][N];
		int pos = 1;

		// start knight tour from corner square `(0, 0)`
		knightTour(visited, 0, 0, pos);

	}

	private static void print(int[][] visited) {
		for (int[] r : visited) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println();
	}

	public static void knightTour(int visited[][], int x, int y, int pos) {
		// mark the current square as visited
		visited[x][y] = pos;

		// if all squares are visited, print the solution
		if (pos >= N * N) {
			print(visited);
			// backtrack before returning
			visited[x][y] = 0;
			return;
		}

		// check for all eight possible movements for a knight
		// and recur for each valid movement
		for (int k = 0; k < 8; k++) {
			// get the new position of the knight from the current
			// position on the chessboard
			int newX = x + row[k];
			int newY = y + col[k];

			// if the new position is valid and not visited yet
			if (isValid(newX, newY) && visited[newX][newY] == 0) {
				knightTour(visited, newX, newY, pos + 1);
			}
		}

		// backtrack from the current square and remove it from the current path
		visited[x][y] = 0;
	}

	private static boolean isValid(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

}

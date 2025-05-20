package com.codex.dsa.btrack;

public class RatInMaze {
	public static int N;

	public static void main(String args[]) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		N = maze.length;
		solveRatMaze(maze);
	}

	public static void solveRatMaze(int[][] maze) {
		int[][] sol = new int[N][N];
		if (!solveRatMazeUtil(maze, 0, 0, sol)) {
			System.out.println("No Solution Available");
		}
		BacktrackUtil.printIntMatrix(sol, N);
	}

	private static boolean solveRatMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if (isSafe(maze, x, y)) {

			if (sol[x][y] == 1) {
				return false;
			}

			sol[x][y] = 1;

			if (solveRatMazeUtil(maze, x + 1, y, sol))
				return true;

			if (solveRatMazeUtil(maze, x, y + 1, sol))
				return true;
			if (solveRatMazeUtil(maze, x - 1, y, sol))
				return true;

			if (solveRatMazeUtil(maze, x, y - 1, sol))
				return true;

			sol[x][y] = 0;
			return false;
		}

		return false;
	}

	static boolean isSafe(int maze[][], int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	}
}

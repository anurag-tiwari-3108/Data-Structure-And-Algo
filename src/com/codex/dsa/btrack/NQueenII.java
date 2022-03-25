package com.codex.dsa.btrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Placing N-Queen in such a way that no 2 Queen share the same
 * row/column/diagonal Q – – – – – – – – – – – Q – – – – – – – – – – Q – – – – –
 * Q – – – – Q – – – – – – – – – – – Q – – Q – – – – – – – – – Q – – – –
 * 
 * @author anutiwar
 *
 *         The aim here is to count all the possible solution and store all the
 *         solutions in List<List<Integer>> result param
 */
public class NQueenII {
	static List<List<String>> res;
	public static void main(String[] args) {
		int N = 8;
		NQueenII queen = new NQueenII();
		int[][] board = new int[N][N];
		int[] count = new int[1]; // to store the count of available solutions
		res = new ArrayList<>();
		queen.dfs(board, N, 0, count);        
		System.out.println("Available Solutions are " + count[0]+"  "+res.size());
		
	}

	private void dfs(int[][] board, int n, int r, int[] count) {
		if (n == r) {			
			List<String> ans = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    sb.append(board[i][j]==0 ? "." : "Q");
                }
                ans.add(sb.toString());
            }
            res.add(ans);
			count[0]++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(board, r, i, n)) {
				board[r][i] = 1;
				dfs(board, n, r + 1, count);
				board[r][i] = 0;
			}
		}

	}

	boolean isValid(int[][] board, int row, int col, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					if (row == i || col == j) // same row or column
						return false;
					if (Math.abs(i - row) == Math.abs(j - col)) // same diagonal or anti-diagonal
						return false;
				}
			}
		}
		return true;
	}

}

package com.codex.dsa.backtracking;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board
 * where every cell has one character. Find all possible words that can be
 * formed by a sequence of adjacent characters. Note that we can move to any of
 * 8 adjacent characters, but a word should not have multiple instances of same
 * cell.
 * 
 * @author anutiwar
 *
 */
public class WordBoggle {
	static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
	static final int n = dictionary.length;
	static final int M = 3, N = 3;

	public static void main(String[] args) {
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

		System.out.println("Following words of dictionary are present");
		searchWord(boggle);
	}

	private static void searchWord(char[][] boggle) {
		boolean[][] isVisited = new boolean[M][N];
		String word = "";
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				searchWord(boggle, isVisited, i, j, word);
			}
		}

	}

	private static void searchWord(char[][] boggle, boolean[][] isVisited, int i, int j, String word) {
		isVisited[i][j] = true;

		word = word + boggle[i][j];

		if (isValidWord(word))
			System.out.println(word);

		for (int row = i - 1; row <= i + 1 && row < M; row++) {
			for (int col = j - 1; j <= j + 1 && col < N; col++) {
				if (row >= 0 && col >= 0 && !isVisited[row][col]) {
					searchWord(boggle, isVisited, row, col, word);
				}
			}

		}
		// backtrack is not found anything
		word = "" + word.charAt(word.length() - 1);
		isVisited[i][j] = false;
	}

	private static boolean isValidWord(String str) {
		for (int i = 0; i < N; i++)
			if (str.equals(dictionary[i]))
				return true;
		return false;
	}
}

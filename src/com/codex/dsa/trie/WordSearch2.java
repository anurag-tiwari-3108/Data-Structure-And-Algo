package com.codex.dsa.trie;
import java.util.ArrayList;
import java.util.List;

// implement the word search prob with one constraint that any cell can only be used at once only

public class WordSearch2 {
	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> response = new ArrayList<String>();
		TrieNode root = new TrieNode();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, response);
			}
		}

		return response;
	}

	private void dfs(char[][] board, int row, int col, TrieNode root, List<String> response) {

		char c = board[row][col];
		if (c == '#' || root.next[c - 'a'] == null) {
			return;
		}

		root = root.next[c - 'a'];
		if (root.word != null) {
			response.add(root.word);
			root.word = null;
		}

		board[row][col] = '#';
		if (row > 0)
			dfs(board, row - 1, col, root, response);
		if (col > 0)
			dfs(board, row, row - 1, root, response);
		if (row < board.length - 1)
			dfs(board, row + 1, col, root, response);
		if (col < board[0].length - 1)
			dfs(board, row, col + 1, root, response);
		board[row][col] = c;

	}

}

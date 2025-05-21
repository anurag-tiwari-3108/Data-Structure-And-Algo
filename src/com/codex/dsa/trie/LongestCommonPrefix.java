package com.codex.dsa.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class LongestCommonPrefix {

	public static void main(String[] ar) {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(5);
		l.add(1);
		l.add(10);
		System.out.println(l);
	}
	private static void insert(TrieNode head, String str) {
		TrieNode curr = head;
		for (char ch : str.toCharArray()) {
			curr.character.putIfAbsent(ch, new TrieNode());
			curr = curr.character.get(ch);
		}
		curr.isLeaf = Boolean.TRUE;
	}

	public void findLCS(List<String> dict) {
		TrieNode head = new TrieNode();
		for (String s : dict) {
			insert(head, s);
		}
		
		StringBuilder sb = new StringBuilder();
		TrieNode curr = head;
		while(curr != null && !curr.isLeaf && (curr.character.size() != 1)) {
			for(var entry:curr.character.entrySet()) {
				sb.append(entry.getKey());
				curr = entry.getValue();
			}
		}
	}

}

class TrieNode {
	boolean isLeaf = false; // set when the node is a leaf node
	Map<Character, TrieNode> character = new HashMap<>();
}

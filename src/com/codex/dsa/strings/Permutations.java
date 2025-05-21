package com.codex.dsa.strings;

public class Permutations {

	public static void main(String[] args) {
		String s = "ABCDE";
		System.out.println("****** Backtrack Approch ******");
		permutationBacktrack(s.toCharArray(), 0);
		System.out.println("****** Recursive Approch ******");
		permutationRecursive("", s);
	}

	private static void permutationRecursive(String candidate, String remaining) {
		if (remaining.length() == 0) {
			System.out.println(candidate);
		}
		for (int i = 0; i < remaining.length(); i++) {
			String newCandidate = candidate + remaining.charAt(i);
			String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
			permutationRecursive(newCandidate, newRemaining);
		}
	}

	private static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

	private static void permutationBacktrack(char[] ch, int start) {

		if (start == ch.length) {
			System.out.println(String.valueOf(ch));
		}
		for (int i = start; i < ch.length; i++) {
			swap(ch, start, i);// start =i and i=start
			permutationBacktrack(ch, start + 1);
			swap(ch, start, i);// reverting the things done in line no 28 for backtracking
		}

	}

}

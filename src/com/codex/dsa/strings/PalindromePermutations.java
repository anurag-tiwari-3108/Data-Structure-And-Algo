package com.codex.dsa.strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutations {

	public static void main(String[] args) {

		String ip = "racecap";

		System.out.println("The input String " + ip + " is palindrome permutation ? " + isPalindromePermutation(ip));
	}

	private static boolean isPalindromePermutation(String ip) {

		if (ip.length() == 0) {
			return false;

		}
		Set<Character> palinSet = new HashSet<>();

		for (Character c : ip.toCharArray()) {

			if (palinSet.contains(c)) {
				palinSet.remove(c);
			}

			else {
				palinSet.add(c);
			}

		}

		return palinSet.size() == 1;
	}
}

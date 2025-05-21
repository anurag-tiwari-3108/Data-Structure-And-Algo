package com.codex.dsa.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromePermutation {
	public static void main(String[] args) {
		String value = "Tact coa";
		System.out.println(isPalindrome(value));
	}

	public static boolean isPalindrome(String val) {
		Map<Character, Integer> table = buildCharacterFrequencyTable(val.toLowerCase().replace(" ", ""));
		return checkMaxOneOdd(table);
	}

	public static boolean checkMaxOneOdd(Map<Character, Integer> table) {
		Iterator<Character> itr = table.keySet().iterator();
		boolean foundOdd = false;
		while (itr.hasNext()) {
			if (table.get(itr.next()) % 2 != 0) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}

		return true;
	}

	public static Map<Character, Integer> buildCharacterFrequencyTable(String val) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < val.length(); i++) {
			map.put(val.charAt(i), map.getOrDefault(val.charAt(i), 0) + 1);
		}
		return map;
	}

	public static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		if (a <= Character.getNumericValue(c) && Character.getNumericValue(c) <= z) {
			return c - a;
		}
		return -1;
	}
}

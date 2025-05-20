package com.codex.dsa.string;

public class UniqueCharacter {

	static boolean uniqueCharacters(String str) {
		// Assuming string can have characters a-z this has 32 bits set to 0
		int checker = 0;

		for (int i = 0; i < str.length(); i++) {
			System.out.print("charat i = " + str.charAt(i));
			int bitAtIndex = str.charAt(i) - 'a';
			System.out.print(" | bitAtIndex = " + bitAtIndex);
			System.out.print(" | checker = " + checker);
			System.out.println();
			// if that bit is already set in checker,return false
			if ((checker & (1 << bitAtIndex)) > 0)
				return false;
			// otherwise update and continue by setting that bit in the checker
			checker = checker | (1 << bitAtIndex);
		}

		// no duplicates encountered, return true
		return true;
	}

	public static void main(String[] args) {
		System.out.println(uniqueCharacters("abcda"));
	}
}

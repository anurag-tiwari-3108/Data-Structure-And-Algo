package com.codex.dsa.string;

public class OneAwayStrings {

	public static void main(String[] args) {
		String a = "pale";
		String b = "bae";
		System.out.println(isOneAway(a, b));
	}

	private static boolean isOneAway(String a, String b) {
		if (a.equalsIgnoreCase(b)) {
			return true;
		}
		if (a.length() == b.length()) {
			return validateSameLengthStrings(a, b);
		} else if (a.length() == b.length() + 1) {
			return validateDiffLengthStrings(b, a);
		} else if (a.length() + 1 == b.length()) {
			return validateDiffLengthStrings(a, b);
		}
		return false;
	}

	public static boolean validateDiffLengthStrings(String smallLength, String biggerLength) {
		int i = 0;
		int j = 0;
		boolean foundOneDiff = false;

		while (i < biggerLength.length() - 1) {
			if (smallLength.charAt(i) != biggerLength.charAt(j)) {
				j++;
				if (foundOneDiff) {
					return false;
				}
				foundOneDiff = true;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

	public static boolean validateSameLengthStrings(String a, String b) {
		boolean foundOneDiff = false;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				if (foundOneDiff) {
					return false;
				}
				foundOneDiff = true;
			}
		}
		return true;
	}
}

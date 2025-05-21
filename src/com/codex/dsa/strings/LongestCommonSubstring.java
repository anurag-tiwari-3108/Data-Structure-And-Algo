package com.codex.dsa.strings;

/**
 * The longest common substring of ABABC and BABCA is BABC
 * 
 * @author anutiwar
 *
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		String ip1 = "ABABC";
		String ip2 = "BABCA";
		int m = ip1.length();
		int n = ip2.length();
		System.out.println("The longest Common Substring is " + getSubstring(ip1, ip2, m, n));
	}

	private static String getSubstring(String X, String Y, int m, int n) {
		int maxlen = 0; 
		int endingIndex = m; 
		int[][] lookup = new int[m + 1][n + 1];

		// fill the lookup table in a bottom-up manner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1] + 1;

					// update the maximum length and ending index
					if (lookup[i][j] > maxlen) {
						maxlen = lookup[i][j];
						endingIndex = i;
					}
				}
			}
		}

		// return longest common substring having length `maxlen`
		return X.substring(endingIndex - maxlen, endingIndex);
	}

}

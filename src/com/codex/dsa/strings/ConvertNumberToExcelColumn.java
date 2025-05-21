package com.codex.dsa.strings;

public class ConvertNumberToExcelColumn {
	// Function to convert a given number to an Excel column
	public static String getColumnName(int n) {
		// initialize output string as empty
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			// find the index of the next letter and concatenate the letter
			// to the solution

			// here index 0 corresponds to `A`, and 25 corresponds to `Z`
			int index = (n - 1) % 26;			
			result.append((char) (index + 'A'));
			System.out.println("N :" + n + "  index : " + index + " Result : " + result);
			n = (n - 1) / 26;
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// generate column names for 10 random numbers between 1–1000
		System.out.println(27 + " — " + getColumnName(704));
	}
}

package com.codex.dsa.string;

public class NumberCombinationDigisibleByN {

	public static void main(String[] args) {
		String digit = "1234";
		int[] number = new int[digit.length()];
		for (int i = 0; i < digit.length(); i++) {
			number[i] = digit.charAt(i) - '0';
		}
		System.out.println("No Of Supported Count " + getCountOfNumber(number));
	}

	private static int getCountOfNumber(int[] number) {
		int count = 0;
		int sum = getSum(number);
		for (int c : number) {
			int rem = sum - c;
			for (int i = 0; i < 10; i++) {
				int op = rem + i;
				System.out.println("Params op = " + op + "   rem = " + rem + "   sum = " + sum);
				if (c != i && op % 3 == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static int getSum(int[] number) {
		int sum = 0;
		for (int c : number) {
			sum = sum + c;
		}
		return sum;
	}

}

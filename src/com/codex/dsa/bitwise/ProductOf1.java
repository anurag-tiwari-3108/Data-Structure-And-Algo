package com.codex.dsa.bitwise;

public class ProductOf1 {

	private static int getProudctOfOne(int a, int b) {
		int count = 0;
		int product = a * b; // 2 * 3 = 6 -- Binaray of 6 = 0110 --> remove all zero -- 11 => binary of 3. so o/p 3
		while (product > 0) {
			product >>= 1;
			count++;
		}

		return count;

	}

	public static void main(String[] args) {
		System.out.println(getProudctOfOne(2,3));
	}

}

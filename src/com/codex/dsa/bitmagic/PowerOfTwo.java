package com.codex.dsa.bitmagic;

public class PowerOfTwo {
	private static boolean isPowerOfTwoBitMagic(int n) {
		return n > 0 && ((n & (n-1)) == 0);
	
	}
	
	private static boolean isPowerOfTwoBitManipulation(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwoBitMagic(8));
		System.out.println(isPowerOfTwoBitManipulation(8));
	}
}

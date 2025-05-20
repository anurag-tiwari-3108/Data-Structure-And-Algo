package com.codex.dsa.string;

public class StringToInt {
	public static void main(String[] args) {
		convert("1231232");
	}

	private static void convert(String string) {
		int out = 0;
		for (int i = 0; i < string.length(); i++) {
			out = out * 10 + (int) string.charAt(i) - 48;
			System.out.println(out);
		}
		System.out.println("Final Output Value is:: " + out);
	}

}

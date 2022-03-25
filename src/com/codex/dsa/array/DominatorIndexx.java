package com.codex.dsa.array;

import java.util.HashMap;

public class DominatorIndexx {

	public static void main(String[] args) {
		int[] ar = { 3, 3, 3, 0, 1 };
		System.out.println(sol(ar));
	}

	private static int sol(int[] ar) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < ar.length; i++) {
			map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
			if (map.get(ar[i]) > ar.length / 2) {
				return i;
			}
		}
		return -1;
	}
}

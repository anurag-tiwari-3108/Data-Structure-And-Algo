package com.codex.dsa.hashmaps;

import java.util.HashMap;


public class SizeOfMap {

	public static void main(String[] args) {
		HashMap<Number, String> aMap = new HashMap<Number, String>();
		for (int i = 1; i <= 100; i++) {
			aMap.put(i, getRandomStringValue(i));
		}
		System.out.println("Size of Map " + aMap.size());
		System.out.println("Hashcode of Map " + aMap.hashCode());
		System.out.println("Keyset of Map " + aMap.keySet());

		for (Number value : aMap.keySet()) {
			System.out.print(aMap.get(value) + " | ");

		}

	}

	private static String getRandomStringValue(int i) {
		String value = "ArrayIndex_" + i;
		return value;
	}

}

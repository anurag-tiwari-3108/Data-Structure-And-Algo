package com.codex.dsa.hashing;

import java.util.HashMap;

public class HashCodeImplemention {

	public static void main(String[] args) {
		HashMap<PriceForHashCodeImplementation, String> hm = new HashMap<PriceForHashCodeImplementation, String>();
		hm.put(new PriceForHashCodeImplementation("Banana", 20), "Banana");
		hm.put(new PriceForHashCodeImplementation("Apple", 40), "Apple");
		hm.put(new PriceForHashCodeImplementation("Orange", 30), "Orange");
		// creating new object to use as key to get value
		PriceForHashCodeImplementation key = new PriceForHashCodeImplementation("Banana", 20);
		System.out.println("Hashcode of the key: " + key.hashCode());
		System.out.println("Value from map: " + hm.get(key));
	}
}
package com.codex.dsa.strings;

/**
 *  Klarna OA : Need to return a list of transaction which are greater then the allowed credit limit
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RejectedTransaction {

	public static void main(String[] args) {
		findRejectedTransactions(Arrays.asList("Jane,Doe,jane@doe.com,199,TR0001", "Jane,Doe,jane@doe.com,2,TR0002"),
				200);
	}

	public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {

		if (transactions.size() <= 0) {
			return new ArrayList<String>();
		}
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < transactions.size(); i++) {
			String element = transactions.get(i);
			String[] elementAr = element.split(",");
			int amount = Integer.parseInt(elementAr[3]);
			String email = elementAr[2];
			String fName = elementAr[0];
			String lName = elementAr[1];

			String key = fName + lName + email;

			if (map.get(key) == null) {
				map.put(key, amount);
			} else {
				map.put(key, map.get(key) + amount);
			}
			if (map.get(key) > creditLimit) {
				map.put(key, map.get(key) - amount);
				res.add(elementAr[4]);
			}
		}
		return res;
	}
}

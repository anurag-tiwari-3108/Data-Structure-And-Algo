package com.codex.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Smoothie {

	static String[] Classic = { "strawberry", "banana", "pineapple", "mango", "peach", "honey", "ice", "yogurt" };
	static String[] Freezie = { "blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt" };
	static String[] Greenie = { "green apple", "kiwi", "lime", "avocado", "spinach", "ice", "apple juice" };
	static String[] Just_Desserts = { "banana", "ice cream", "chocolate", "peanut", "cherry" };

	public static void main(String[] args) {
		System.out.println(ingredients(null));

	}

	public static String ingredients(String order) {
        if(order == null || order.length() <=0) {
			throw new IllegalArgumentException();
		}
		String output = "";
		Map<String, String[]> ingredientsList = new HashMap<>();
		ingredientsList.put("Classic", Classic);
		ingredientsList.put("Freezie", Freezie);
		ingredientsList.put("Greenie", Greenie);
		ingredientsList.put("Just Desserts", Just_Desserts);

		String[] mainOrder = order.split(",");
		if (!ingredientsList.containsKey(mainOrder[0])) {
			throw new IllegalArgumentException();
		}		
      	if(!order.contains("-") && mainOrder.length>1) {
			throw new IllegalArgumentException();
		}

		List<String> res = new ArrayList<>(Arrays.asList(ingredientsList.get(mainOrder[0])));
      
		if (order.contains("-")) {
			for (int i = 1; i < Arrays.asList(mainOrder).size(); i++) {
				if (mainOrder[i].contains("-")) {
					String name = mainOrder[i].substring(1, mainOrder[i].length());
					res.remove(name);
				}
			}
		}
		Collections.sort(res);
		output = String.join(",", res);
		return output;
    }
}
package com.codex.dsa.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashmapIntro {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		int i = 10;
		while (i > 0) {
			map.put(i, "String_Value_For_Count_" + i);
			i--;
		}

		for (int j = 1; j <= 10; j++) {
			System.out.println("Getting " + j + " Value From Map : " + map.get(j));
		}
	}

}

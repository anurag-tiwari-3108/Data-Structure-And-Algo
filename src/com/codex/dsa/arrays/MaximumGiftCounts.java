package com.codex.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumGiftCounts {
	int N = 3;
	static int max = 0;

	public static void main(String[] args) {
		List<Item> itList = getList();
		MaximumGiftCounts o = new MaximumGiftCounts();
		int gifts = 0;
		o.backtrack(0, itList, 0, 0, gifts);
		System.out.println("Max Gift Count : "+max );

	}

	public static List<Item> getList() {
		List<Item> itList = new ArrayList<>();
		Item i1 = new Item(3, 3);
		Item i2 = new Item(5, 3);
		Item i3 = new Item(6, 4);
		itList.add(i1);
		itList.add(i2);
		itList.add(i3);
		return itList;

	}

	void backtrack(int start, List<Item> items, int availableCost, int prevCost, int gifts) {

		if (N == start) {
			max = Math.max(max,gifts);
			return;
		}

		for (int i = start; i < items.size(); i++) {
			int cost = items.get(i).cost;
			int day = items.get(i).day;
			availableCost = Math.abs(availableCost+day -prevCost);
			if (availableCost >= cost) {
				gifts++;
				availableCost -= cost;
				prevCost +=cost;
			}
			backtrack(start+1, items, availableCost, prevCost, gifts);
			gifts--;
		}
	}

}

class Item {
	int day;
	int cost;

	Item(int day, int cost) {
		this.day = day;
		this.cost = cost;
	}
}

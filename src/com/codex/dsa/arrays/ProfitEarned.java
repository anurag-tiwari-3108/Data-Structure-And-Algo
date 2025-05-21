package com.codex.dsa.arrays;

public class ProfitEarned {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.printf(" Max Profit Earned is %d\n", maxProfitEarned(prices));
		System.out.printf(" Total Profit Earned is %d\n", totalProfitEarned(prices));
	}

	private static int totalProfitEarned(int[] price) {
		int profit = 0;
		int j = 0;
		for (int i = 1; i < price.length; i++) {
			if (price[i - 1] > price[i]) {
				j = i; // setting up the minimum value point
			}
			if (price[i - 1] <= price[i] && (i + 1 == price.length || price[i] > price[i + 1])) {
				profit += (price[i] - price[j]); // getting the maximum value for that share
				System.out.printf(" Buy on day %d and sell on day %d\n", j + 1, i + 1);
			}
		}

		return profit;
	}

	private static int maxProfitEarned(int[] prices) {
		int min = prices[0];
		int cost = 0;
		int maxCost = 0;

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			cost = prices[i] - min;
			maxCost = Math.max(cost, maxCost);

		}
		return maxCost;
	}

}

package com.codex.dsa.dynamicprogramming;

import java.util.Arrays;

public class MinCoinChanges {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int sum = 11;
		System.out.println("Minimum No Of Coin Requires via DP : " + coinChange(coins, sum));
		System.out.println("Minimum No Of Coin Requires via Normal : " + coinChangeNormal(coins, sum));
	}

	private static  int coinChangeNormal(int[] S, int N) {
		int[] T = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			// initialize the minimum number of coins needed to infinity
			T[i] = Integer.MAX_VALUE;
			int result = Integer.MAX_VALUE;

			// do for each coin
			for (int c : S) {
				// check if the index doesn't become negative by including current coin `c`
				if (i - c >= 0) {
					result = T[i - c];
				}

				// if total can be reached by including current coin `c`,  update the minimum number of coins needed `T[i]`
				if (result != Integer.MAX_VALUE) {
					T[i] = Integer.min(T[i], result + 1);
				}
			}
		}

		return T[N] == Integer.MAX_VALUE ? -1 : T[N];

	}

	private static int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

}

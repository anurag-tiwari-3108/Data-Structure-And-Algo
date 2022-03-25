package com.codex.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of pairs of numbers of size N. In every pair, the first number
 * is always smaller than the second number. A pair (c, d) can follow another
 * pair (a, b) if b < c. The chain of pairs can be formed in this fashion. The
 * task is to find the length of the longest chain which can be formed from a
 * given set of pairs.
 * 
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40},
 * {50, 90} }, then the longest chain that can be formed is of length 3, and the
 * chain is {{5, 24}, {27, 40}, {50, 90}}
 * 
 * @author anutiwar
 *
 */
public class MaxLengthChain {
	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	};

	public static void main(String args[]) {

		// Declaration of array of structure
		Pair p[] = new Pair[5];

		p[0] = new Pair(5, 24);
		p[1] = new Pair(39, 60);
		p[2] = new Pair(15, 28);
		p[3] = new Pair(27, 40);
		p[4] = new Pair(50, 90);

		int n = p.length;

		System.out.println(maxChainLength(p, n));
	}

	private static int maxChainLength(Pair[] p, int n) {
		int l = 1; 
		Arrays.sort(p, new Comparator<Pair>() {
			@Override
			public int compare(Pair P1, Pair P2) {
				return P1.second - P2.second;
			}

		});
		
		int s = p[0].second; 
		for(int i = 1; i < n; i++)
	    { 	         
	        if (p[i].first > s)
	        { 
	            l++; 
	            s = p[i].second; 
	        } 
	    } 
	     
	    // Return maximum length 
	    return l; 
	}
}
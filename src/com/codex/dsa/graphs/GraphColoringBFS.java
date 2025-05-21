package com.codex.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphColoringBFS {
	public boolean isBipartite(int[][] graph) {
		int len = graph.length;
		int[] colors = new int[len];

		for (int i = 0; i < len; i++) {
			if (colors[i] != 0)
				continue;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			colors[i] = 1; // Blue: 1; Red: -1.

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph[cur]) {
					if (colors[next] == 0) { // If this node hasn't been coloured;
						colors[next] = -colors[cur]; // Colour it with a different color;
						queue.offer(next);
					} else if (colors[next] != -colors[cur]) { // If it is coloured and its colour is different, return
																// false;
						return false;
					}
				}
			}
		}

		return true;
	}
}

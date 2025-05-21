package com.codex.dsa.graphs;

// Bipartite Graph : if a graph is having odd length cycle then it would not be bipartite graph, 
// if its a even length graph then it would be bipartite graph

public class GraphColoringDFS {

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) { // This graph might be a disconnected graph. So check each unvisited node.
			if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
				return false;
			}
		}
		return true;
	}

	public boolean validColor(int[][] graph, int[] colors, int color, int node) {
		if (colors[node] != 0) {
			return colors[node] == color;
		}
		colors[node] = color;
		for (int next : graph[node]) {
			if (!validColor(graph, colors, -color, next)) {
				return false;
			}
		}
		return true;
	}
}

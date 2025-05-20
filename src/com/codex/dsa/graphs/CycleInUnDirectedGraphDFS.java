package com.codex.dsa.graph;

import java.util.Arrays;
import java.util.List;


// DFS Approach to check if there is any cycle in graph
public class CycleInUnDirectedGraphDFS {

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3), new Edge(2, 6),
				new Edge(3, 4), new Edge(3, 5), new Edge(8, 9), new Edge(8, 12), new Edge(9, 10), new Edge(9, 11),
				new Edge(11, 12));
		// total number of nodes in the graph
		final int N = 13;
		Graph graph = new Graph(edges, N);
		boolean[] discovered = new boolean[N];

		System.out.println("The given Undirected Graph has cycle ? " + isCyclePresentInGraph(graph, discovered, 1, -1));

	}

	private static boolean isCyclePresentInGraph(Graph graph, boolean[] discovered, int v, int parent) {
		// Modifired version of DFS
		discovered[v] = true;

		for (int u : graph.adjList.get(v)) {
			if (!discovered[u]) {
				if (isCyclePresentInGraph(graph, discovered, u, v))
					return true;
			} else if (u != parent) {
				return true;
			}
		}
		return false;

	}

}

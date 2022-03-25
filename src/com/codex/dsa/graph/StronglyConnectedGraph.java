package com.codex.dsa.graph;

import java.util.Arrays;
import java.util.List;

public class StronglyConnectedGraph {

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 4), new Edge(1, 0), new Edge(1, 2), new Edge(2, 1), new Edge(2, 4),
				new Edge(3, 1), new Edge(3, 2), new Edge(4, 3));
		final int N = 5;
		Graph graph = new Graph(edges, N);

		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			DFS(graph, i, visited);
			for (boolean bool : visited) {
				if (!bool) {
					System.out.println("Not Strongly Connected");
				}
			}
		}

		System.out.println("Strongly Connected");
	}

	private static void DFS(Graph graph, int vertice, boolean[] visited) {

		visited[vertice] = true;
		for (int u : graph.adjList.get(vertice)) {

			if (!visited[u]) {
				DFS(graph, u, visited);
			}
		}
	}

}

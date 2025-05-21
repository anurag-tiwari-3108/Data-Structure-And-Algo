package com.codex.dsa.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class GraphBFS {

	public static void main(String[] args) {
		Graph graph = Graph.getNewGraph();
		int node = Graph.nodes_of_graph;

		boolean[] isDiscovered = new boolean[node];

		for (int i = 0; i < node; i++) {

			if (!isDiscovered[i]) {
				BFS(graph, i, isDiscovered);
			}
		}

	}

	public static void BFS(Graph graph, int v, boolean[] isDiscovered) {
		isDiscovered[v] = Boolean.TRUE;
		Queue<Integer> graphQueue = new ArrayDeque<>();
		graphQueue.add(v);
		while (!graphQueue.isEmpty()) {
			v = graphQueue.poll();
			for (int u : graph.adjList.get(v)) {

				if (!isDiscovered[u]) {
					isDiscovered[u] = Boolean.TRUE;
					System.out.println("Visiting " + u);
					graphQueue.add(u);
				}

			}

		}
	}

}

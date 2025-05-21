package com.codex.dsa.graphs;

public class UndirectedGraphConnectedComponents {

	public static void main(String[] args) {
		Graph graph = Graph.getNewGraph();
		int node = Graph.nodes_of_graph;

		connectedComponents(node, graph);

	}

	private static void connectedComponents(int V, Graph graph) {

		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				// print all reachable vertices
				// from v
				graphDFS(v, visited, graph);
				System.out.println();
			}
		}

	}

	private static void graphDFS(int v, boolean[] visited, Graph graph) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");
		// Recur for all the vertices adjacent to this vertex
		for (int x : graph.adjList.get(v)) {
			if (!visited[x])
				graphDFS(x, visited, graph);
		}
	}
}

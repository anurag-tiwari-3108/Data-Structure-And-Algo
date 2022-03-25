package com.codex.dsa.graph;

public class GraphDFS {
	public static void main(String[] args) {
		Graph graph = Graph.getNewGraph();
		int nodes = Graph.nodes_of_graph;
		boolean[] isDiscovered = new boolean[nodes];

		for (int i = 0; i < nodes; i++) {
			if (!isDiscovered[i]) {
				DFS(graph, i, isDiscovered);
			}
		}
		
		System.out.println("\n Graph is strongly connected ? "+checkIfNodesAreStronglyConnected(isDiscovered));

	}

	private static boolean checkIfNodesAreStronglyConnected(boolean[] isDiscovered) {
		for (boolean b : isDiscovered) {
			if (!b) {
				return false;
			}
		}

		return true;
	}

	public static void DFS(Graph graph, int v, boolean[] isDiscovered) {
		isDiscovered[v] = Boolean.TRUE;
		System.out.println("Current Node " + v);

		for (int u : graph.adjList.get(v)) {
			if (!isDiscovered[u]) {
				DFS(graph, u, isDiscovered);
			}

		}	

	}

}

package com.codex.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
	int src, dest;

	public Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}

class Graph {
	public static boolean isDAG = false;
	public static int nodes_of_graph = 15;

	List<List<Integer>> adjList = null;

	Graph(List<Edge> edges, int count) {
		adjList = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			adjList.add(new ArrayList<>());
		}

		for (Edge edge : edges) {
			int src = edge.src;
			int dest = edge.dest;

			adjList.get(src).add(dest);
			if(!isDAG)
				adjList.get(dest).add(src);
		}
	}


	public static Graph getNewGraph() {
		List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3), new Edge(2, 6),
				new Edge(3, 4), new Edge(3, 5), new Edge(8, 9), new Edge(8, 12), new Edge(9, 10), new Edge(9, 11),
				new Edge(10, 11), new Edge(10, 12), new Edge(11, 12));
		return new Graph(edges, nodes_of_graph);

	}
	
	public static Graph getNewGraph(List<Edge> edges, int nodes, boolean isDAGGraph) {
		isDAG= isDAGGraph;
		nodes_of_graph = nodes;
		return new Graph(edges, nodes);
	}

	public static Graph getNewGraph(List<Edge> edges, int nodes) {		
		nodes_of_graph = nodes;
		return new Graph(edges, nodes);
	}
}

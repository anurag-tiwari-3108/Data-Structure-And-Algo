package com.codex.dsa.graph;

import java.util.Arrays;
import java.util.List;

/**
 * Example : To get the build order of a project Data serialisations Scheduling
 * Job from given dependencies Applicable only for DAG not for any other type of
 * Graph
 * 
 * 
 * Process with given data build a Graph Apply Topological Sort on that Graph
 * 
 * @author CodeX Developer
 * 
 *  Article to read about the topological sorting and its technique 
 *  		https://www.geeksforgeeks.org/topological-sorting/
 *
 */
public class TopologicalSort {
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6), new Edge(3, 0),
				new Edge(3, 4), new Edge(5, 1), new Edge(7, 0), new Edge(7, 1));

		Graph graph = Graph.getNewGraph(edges, 8, Boolean.TRUE);
		int nodes = 8;
		doTopologicalSort(graph, nodes);
		TopologicalSortStack.doTopologicalSortUsingStack(graph, nodes);
	}

	public static void doTopologicalSort(Graph graph, int N) {

		int[] departure = new int[2 * N];
		Arrays.fill(departure, -1);

		boolean[] discovered = new boolean[N];
		int time = 0;

		for (int i = 0; i < N; i++) {
			if (!discovered[i]) {
				time = DFSWithTime(graph, i, discovered, time, departure);
			}

		}
		for (int i = 2 * N - 1; i >= 0; i--) {
			if (departure[i] != -1) {
				System.out.print(departure[i] + " ");
			}
		}
	}

	public static int DFSWithTime(Graph graph, int v, boolean[] isDiscovered, int time, int[] departure) {

		isDiscovered[v] = Boolean.TRUE;
		time++;

		for (int u : graph.adjList.get(v)) {

			if (!isDiscovered[u]) {
				DFSWithTime(graph, u, isDiscovered, time, departure);
			}
		}

		departure[v] = time;
		time++;

		return time;

	}
}

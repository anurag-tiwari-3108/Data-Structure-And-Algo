package com.codex.dsa.graphs;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortStack {

	public static void topologicalSortUtil(Graph graph, int V, boolean[] visited, Stack<Integer> stack) {
		// modified DFS
		Integer i;
		visited[V] = true;

		Iterator<Integer> itr = graph.adjList.get(V).iterator();
		while (itr.hasNext()) {
			i = itr.next();
			if (!visited[i]) {
				topologicalSortUtil(graph, i, visited, stack);
			}
		}

		stack.push(V);

	}

	public static void doTopologicalSortUsingStack(Graph graph, int V) {

		Stack<Integer> stack = new Stack<Integer>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to store Topological Sort starting from
		// all vertices one by one
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(graph, i, visited, stack);

		// Print contents of stack
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

}

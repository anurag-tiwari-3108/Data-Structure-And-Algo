package com.codex.dsa.graph;

public class GraphColoring {
	private int V, numOfColors;
	private int[] color;
	private int[][] graph;

	/** Function to assign color **/
	public void graphColor(int[][] g, int noc) {
		V = g.length;
		numOfColors = noc;
		color = new int[V];
		graph = g;

		try {
			solve(0);
			System.out.println("No solution");
		} catch (Exception e) {
			System.out.println("\nSolution exists ");
			display();
		}
	}

	/** function to assign colors recursively **/
	public void solve(int v) throws Exception {
		/** base case - solution found **/
		if (v == V)
			throw new Exception("Solution found");
		/** try all colours **/
		for (int c = 1; c <= numOfColors; c++) {
			if (isPossible(v, c)) {
				/** assign and proceed with next vertex **/
				color[v] = c;
				solve(v + 1);
				/** wrong assignement **/
				color[v] = 0;
			}
		}
	}

	/** function to check if it is valid to allot that color to vertex **/
	public boolean isPossible(int v, int c) {
		for (int i = 0; i < V; i++)
			if (graph[v][i] == 1 && c == color[i])
				return false;
		return true;
	}

	/** display solution **/
	public void display() {
		System.out.print("\nColors : ");
		for (int i = 0; i < V; i++)
			System.out.print(color[i] + " ");
		System.out.println();
	}

	/** Main function **/
	public static void main(String[] args) {
		System.out.println("Graph Coloring Algorithm Test\n");
		GraphColoring gc = new GraphColoring();

		int[][] graph = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int V = 4;
		int c = 3;
		gc.graphColor(graph, c);

	}
}

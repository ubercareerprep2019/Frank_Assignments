package part_3;

import java.util.List;

public interface Graph {
	/** Return the number of nodes in the graph */
	int numNodes();

	/** Return a list of edges in the graph */
	List<Pair> getEdges();

	/** Check whether an edge exists */
	boolean hasEdge(int u, int v);

	/**
	 * Return a list of neighbors of n.
	 */
	List<Integer> getNeighbors(int n);

	/**
	 * Print the graph.
	 */
	void printGraph();
}

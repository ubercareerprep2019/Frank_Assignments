package part_3;

import java.util.LinkedList;
import java.util.List;

/**
 * This is my own personal implementaion that does not necessarily follow the
 * directions given in the assignment description, but it still beautifully
 * follows the adjacency list guidelines and implements faster search. Added it
 * here just for practice
 **/

public class ListGraph implements Graph {

	private class Node {
		int value; // unique identifier
		List<Node> neighbors; // neighbors of node

		boolean visited; // bookkeeping for OO-style dfs()

		/**
		 * Visit all nodes reachable on unvisited paths from this node. Precondition:
		 * this node is unvisited.
		 */
		public void dfs() {
			visited = true;
			for (Node n : neighbors) {
				if (!n.visited)
					n.dfs();
			}
		}
	}

	public Node[] nodes;

	public int n; // number of nodes
	public int m; // number of edges

	/**
	 * A graph with n nodes numbers 0..n-1 and edges given by edges. All nodes are
	 * unvisited.
	 */
	public ListGraph(int numNodes, Pair[] edges) {
		n = numNodes;
		m = edges.length;

		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i].value = i;
		}
		for (Pair p : edges) {
			nodes[p.one].neighbors.add(nodes[p.two]);
		}
	}

	/** Return the number of nodes in the graph */
	@Override
	public int numNodes() {
		return n;
	}

	/** Return a list of edges in the graph */
	@Override
	public List<Pair> getEdges() {
		List<Pair> edges = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (Node nb : nodes[i].neighbors) {
				edges.add(new Pair(i, nb.value));
			}
		}
		return edges;
	}

	/** Check whether an edge exists */
	@Override
	public boolean hasEdge(int u, int v) {
		for (Node nb : nodes[u].neighbors) {
			if (nb.value == v) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Integer> getNeighbors(int n) {
		List<Integer> ls = new LinkedList<>();
		for (Node nb : nodes[n].neighbors) {
			ls.add(nb.value);
		}
		return ls;
	}

	@Override
	public void printGraph() {
		System.out.println("Adjacency list");
		for (int i = 0; i < n; i++) {
			String row = n + " -> [ ";
			for (Node node : nodes[i].neighbors) {
				row += node.value + " ";
			}
			System.out.println(row + "]");
		}

	}

	/** Visit all nodes reachable on unvisited paths from node i. */
	public void dfs(int start) {
		for (int i = 0; i < n; i++) {
			nodes[n].visited = false;
		}
		nodes[start].dfs();
	}

}

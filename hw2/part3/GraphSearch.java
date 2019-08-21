package part_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {
	private Graph g;
	private boolean[] visited;

	public GraphSearch(Graph graph) {
		g = graph;
		visited = new boolean[graph.numNodes()];
	}

	/**
	 * Visit every node that is reachable along a path of unvisited nodes starting
	 * at node n. Precondition: n is not visited. print each node visited
	 */
	public void DFS(int n) {
		visit(n);
		List<Integer> nbs = g.getNeighbors(n);
		for (Integer nb : nbs) {
			if (!visited(nb)) {
				DFS(nb);
			}
		}
	}

	/**
	 * Visit every node that is reachable along a path of unvisited nodes starting
	 * at node n.
	 */
	public void DFSIterative(int n) {
		// clearVisited();
		Stack<Integer> st = new Stack<>();
		st.push(n);
		// assumption: Every node initially reachable from n along
		// a path of unvisited nodes is reachable along such
		// a path from some node in st.
		while (!st.isEmpty()) {
			int node = st.pop();
			if (!visited(node)) {
				visit(node);

				List<Integer> nes = g.getNeighbors(node);
				for (Integer ne : nes) {
					st.add(ne);
				}
			}
		}
	}

	/**
	 * Visit every node that is reachable along a path of unvisited nodes starting
	 * at node n in breadth-first order. Print each visited node
	 */
	public void BFS(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		// inv: Every node initially reachable from n along
		// a path of unvisited nodes is reachable along such
		// a path from some node in st.
		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (!visited(node)) {
				visit(node);

				List<Integer> nes = g.getNeighbors(node);
				for (Integer ne : nes) {
					queue.add(ne);
				}
			}
		}
	}

	/** make node n visited */
	public void visit(int n) {
		visited[n] = true;
		System.out.print(n + " ");
	}

	/** check whether node n has been visited */
	public boolean visited(int n) {
		return visited[n];
	}

	/** clear visited --make all nodes unvisited. */
	public void clearVisited() {
		for (int k = 0; k < visited.length; k = k + 1) {
			visited[k] = false;
		}
	}
}

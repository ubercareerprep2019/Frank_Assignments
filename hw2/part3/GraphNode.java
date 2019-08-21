package part_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphNode {
	public int data;

	public GraphNode(int data) {
		this.data = data;

	}

	class GraphWithAdjacencyList {
		private Map<GraphNode, List<GraphNode>> adjNodes;

		void addNode(int key) {
			adjNodes.putIfAbsent(new GraphNode(key), new ArrayList<Integer>());
		}

		public GraphNode getNode(int key) {
			for (GraphNode g : adjNodes.keySet()) {
				if (g.data == key) {
					return g;
				}
			}
			return null;
		}

		void removeNode(int key) {
			GraphNode V = new GraphNode(key);
			adjNodes.values().stream().forEach(e -> e.remove(V)); // iterate and remove
			adjNodes.remove(new GraphNode(key));
		}

		void addEdge(int node1, int node2) {
			GraphNode v1 = new GraphNode(node1);
			GraphNode v2 = new GraphNode(node2);
			adjNodes.get(v1).add(v2);
			adjNodes.get(v2).add(v1);
		}

		void removeEdge(int node1, int node2) {
			GraphNode v1 = new GraphNode(node1);
			GraphNode v2 = new GraphNode(node2);
			List<GraphNode> ev1 = adjNodes.get(v1);
			List<GraphNode> ev2 = adjNodes.get(v2);
			if (ev1 != null) {
				ev1.remove(v2);
			}
			if (ev2 != null) {
				ev2.remove(v1);
			}

		}

		List<GraphNode> getAdjNodes(int key) {
			GraphNode n = getNode(key);
			return adjNodes.get(n);

		}

	}
}

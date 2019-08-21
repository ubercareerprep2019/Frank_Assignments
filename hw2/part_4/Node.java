package part_4;

import java.util.Objects;
import java.util.Set;

public class Node {

	/** The unique numerical identifier of this Node */
	private long id;
	/** Represents the edges outgoing from this Node */
	private Set<Edge> edges;
	private Set<Node> neighbors;

	private Set<Edge> unmodifiableEdges;
	private Set<Node> unmodifiableNeighbors;

	/* package */ void addEdge(Edge e) {
		edges.add(e);
		neighbors.add(e.getOther(this));
	}

	/** Return the unique Identifier of this Node. */
	public long getId() {
		return id;
	}

	/**
	 * Return the Edge of this Node that connects to Node q. Throw an
	 * IllegalArgumentException if edge doesn't exist
	 */
	public Edge getEdge(Node q) {
		for (Edge e : edges) {
			if (e.getDest().equals(q)) {
				return e;
			}
		}
		throw new IllegalArgumentException("getEdge: Node must be a neighbor of this Node");
	}

	/** Return an unmodifiable view of the Edges leaving this Node. */
	public Set<Edge> getExits() {
		return unmodifiableEdges;
	}

	/** Return an unmodifiable view of the Nodes neighboring this Node. */
	public Set<Node> getNeighbors() {
		return unmodifiableNeighbors;
	}

	/** Return true iff ob is a Node with the same id as this one. */
	@Override
	public boolean equals(Object ob) {
		if (ob == this)
			return true;
		if (!(ob instanceof Node))
			return false;
		return id == ((Node) ob).id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

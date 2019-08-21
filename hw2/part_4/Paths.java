package part_4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Paths {
	/**
	 * Return the shortest path from node v to node end <br>
	 * ---or the empty list if a path does not exist. <br>
	 * Classes Graph and Edge are helper classes that i created to ease implementing
	 * the shortest path problem
	 */

	public static List<Node> shortest(Node v, Node end) {
		/**
		 * I chose the frontier set to be a min heap where the nodes are values and the
		 * priority of node F is its shortest path distance from the the start node
		 * implemented the min heap using the priority queues from java util;
		 **/
		PriorityQueue<Node> F = new PriorityQueue<>();
		// Every node in the frontier and settled sets need the distance and backpointer
		// maintained.Used a hashmap for this.
		HashMap<Node, DB> dbSF = new HashMap<>();

		F.add(v, 0);
		dbSF.put(v, new DB(0, null));

		while (F.size() != 0) {
			Node f = F.poll();
			if (f == end)
				return path(dbSF, end);
			int fDist = dbSF.get(f).dist;
			// for each neighbor w of f
			for (Edge e : f.getExits()) {
				Node w = e.getOther(f);
				int newDist = fDist + e.length;
				DB wDB = dbSF.get(w);
				// if w not in F or S
				if (wDB == null) {
					dbSF.put(w, new DB(newDist, f));
					F.add(w, newDist);

				} else if (newDist < wDB.dist) {
					wDB.dist = newDist;
					wDB.bkptr = f;
					F.changePriority(w, newDist);
				}
			}
		}
		// no path from v to end
		return new LinkedList<>();

	}

	/**
	 * This class instance contains the distance of a shortest path to a node and
	 * the back pointer for that node
	 */

	public static class DB {
		private int dist;
		private Node bkptr;

		private DB(int d, Node p) {
			dist = d;
			bkptr = p;
		}

		@Override
		public String toString() {
			return "dist" + dist + "bckptr" + bkptr;

		}

	}

	// Return the path from the start node to node end

	public static List<Node> path(HashMap<Node, DB> DBdata, Node end) {
		List<Node> path = new LinkedList<>();
		Node p = end;
		while (p != null) {
			path.add(0, p);
			p = DBdata.get(p).bkptr;
		}
		return path;
	}

}

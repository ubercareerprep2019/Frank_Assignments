package part_4;

public class nbOfIslands {
	public int[][] visited;

	public int numIslands(char[][] islandMap) {
		if (islandMap.length == 0) {
			return 0;
		}
		visited = new int[islandMap.length][islandMap[0].length];
		int islands = 0;
		for (int i = 0; i < islandMap.length; i++) {
			for (int j = 0; j < islandMap[0].length; j++) {
				if (islandMap[i][j] == '0')// this is covered by water, so ignore
					continue;
				if (visited[i][j] != 0) // this is a new island but has been visited already, so ignore
					continue;
				visit(islandMap, i, j, ++islands);// new island is found so we visit all its neighbors
			}
		}
		return islands;
	}

	// dfs search
	public void visit(char[][] islandMap, int i, int j, int num) {

		// check that this island has not been visited
		if (visited[i][j] != 0)
			return;
		// mark as visited
		visited[i][j] = num;

		// iteratively visit the whole map

		if (i > 0 && islandMap[i - 1][j] == '1') {
			visit(islandMap, i - 1, j, num);
		}

		if (j > 0 && islandMap[i][j - 1] == '1') {
			visit(islandMap, i, j - 1, num);
		}
		if (i < islandMap.length - 1 && islandMap[i + 1][j] == '1') {
			visit(islandMap, i + 1, j, num);
		}
		if (j < islandMap[0].length - 1 && islandMap[i][j + 1] == '1') {
			visit(islandMap, i, j + 1, num);
		}
	}

	public static void main(String[] args) {
		char[][] islandMap = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '1', '0', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println("Number of islands is " + new nbOfIslands().numIslands(islandMap));

		char[][] islandMap2 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println("Number of islands is " + new nbOfIslands().numIslands(islandMap2));
	}

}

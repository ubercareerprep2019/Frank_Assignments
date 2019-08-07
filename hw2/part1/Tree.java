package part1;

public class Tree<T> {
	public TreeNode<T> root;

	public Tree(TreeNode<T> root) {
		this.root = root;
	}

	public Tree() {
		this.root = null;
	}

	public class TreeNode<T> {
		private T value;
		private TreeNode<T> left, right;

		public TreeNode(T value) {
			this.value = value;
		}

		public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public T getValue() {
			return value;
		}

		public TreeNode<T> getLeft() {
			return left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		private int safeSize(TreeNode<T> t) {
			return t == null ? 0 : t.size();
		}

		public int size() {
			return 1 + safeSize(left) + safeSize(right);
		}

		private boolean safeContains(TreeNode<T> t, T v) {
			return t == null ? false : t.contains(v);
		}

		public boolean contains(T v) {
			return value.equals(v) || safeContains(left, v) || safeContains(right, v);
		}
	}

	public void main(String[] args) {
		TreeNode<Integer> leftChild = new TreeNode<>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<>(3, null, null);
		TreeNode<Integer> left = new TreeNode<>(7, null, null);
		TreeNode<Integer> right = new TreeNode<>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<>(1, left, right);
		Tree tree = new Tree(root);

	}

	public void print() {
		preOrder(root);
		postOrder(root);
		inOrder(root);
	}

	// preorder print

	void preOrder(TreeNode<T> root) {
		TreeNode<T> cur = root;
		if (cur == null) {
			return;
		}
		System.out.print(root.getValue().toString() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	// postorder

	void postOrder(TreeNode<T> root) {
		TreeNode<T> cur = root;
		if (cur == null) {
			return;
		}
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getValue().toString() + " ");
	}

	// inorder print

	void inOrder(TreeNode<T> root) {
		TreeNode<T> cur = root;
		if (cur == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.getValue().toString() + " ");
		inOrder(root.getRight());

	}

}

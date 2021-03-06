package binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>, U> {
	protected BinarySearchTreeNode<T, U> root;
	protected int size = 0;
	protected int depth = 0;

	public boolean insert(BinarySearchTreeNode<T, U> node) {
		int depthTemp = 0;
		BinarySearchTreeNode<T, U> y = null;
		BinarySearchTreeNode<T, U> x = root;
		if (root != null && node.getKey().compareTo(root.getKey()) < 0) {
		}
		while (x != null) {
			++depthTemp;
			y = x;
			if (node.getKey().compareTo(x.getKey()) < 0) {
				x = x.getChildAt(0);
			} else if (node.getKey().compareTo(x.getKey()) > 0) {
				x = x.getChildAt(1);
			} else {
				// TODO: replace the node;
				return false;
			}
		}
		node.setParent(y);
		if (y == null) {
			root = node;
			++size;
			depth = 1;
			return true;
		} else if (node.getKey().compareTo(y.getKey()) < 0) {
			y.setLeftChild(node);
			++size;
			depth += depthTemp == depth ? 1 : 0;
			return true;
		} else if (node.getKey().compareTo(y.getKey()) > 0) {
			y.setRightChild(node);
			++size;
			depth += depthTemp == depth ? 1 : 0;
			return true;
		} else {

			// TODO: replace the node but we do nothing here, value not
			// implemented;
			return false;
		}
	}

	public BinarySearchTreeNode<T, U> search(T k) {
		if (root == null) {
			return null;
		}
		BinarySearchTreeNode<T, U> x = root;
		while (x != null) {
			if (k.compareTo(x.getKey()) < 0) {
				x = x.getChildAt(0);
			} else if (k.compareTo(x.getKey()) > 0) {
				x = x.getChildAt(1);
			} else {
				return x;
			}
		}
		return null;
	}

	public BinarySearchTree<T, U> maximum(T k) {
		return null;
	}

	public BinarySearchTree<T, U> minimum(T k) {
		return null;
	}

	public void inorderTreeWalk() {
		inorderTreeWalkAux(root);
	}

	private void inorderTreeWalkAux(BinarySearchTreeNode<T, U> node) {
		if (node != null) {
			System.out.print("(");
			inorderTreeWalkAux(node.getChildAt(0));
			System.out.print(node.getKey());
			inorderTreeWalkAux(node.getChildAt(1));
			System.out.print(")");
		}
	}

}

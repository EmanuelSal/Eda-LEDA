package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}
	private int height(BSTNode<T> Node) {
		if(Node == null) return -1;
		else {
			return 1 + Math.max(height((BSTNode<T>) Node.getLeft()), height((BSTNode<T>) Node.getRight()));
		}
	}
	@Override
	public BSTNode<T> search(T element) {
		BSTNode aux = this.root;
		BSTNode retorno = null;

		while (aux != null) {
			if (aux.getData().equals(element)) {
				retorno = aux;
			}
			if (element.compareTo((T) aux.getData()) < 0) {
				aux = (BSTNode) aux.getLeft();
			}
			if (element.compareTo((T)aux.getData()) > 0) {
				aux = (BSTNode) aux.getRight();
			}
		} return retorno;

	}

	@Override
	public void insert(T element) {
		if (element != null) {

		}

	}

	@Override
	public BSTNode<T> maximum() {
		if(this.isEmpty()) {
			return null;
		}

		BSTNode node = this.root;
		while (node.getRight() != null) {
			node.setRight(node.getRight());
		}

		return node;
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}

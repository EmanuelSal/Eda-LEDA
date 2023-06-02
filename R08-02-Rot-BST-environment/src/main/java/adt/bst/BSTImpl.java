package adt.bst;

import adt.bt.BTNode;

import java.util.ArrayList;
import java.util.List;

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
		return heightRecursive(this.root);
	}
	private int heightRecursive(BSTNode<T> Node) {
		if(Node.isEmpty())  {
			return -1;
		}
		else {
			return 1 + Math.max(
							heightRecursive((BSTNode<T>) Node.getLeft()),
							heightRecursive((BSTNode<T>) Node.getRight()));
		}
	}
	@Override
	public BSTNode<T> search(T element) {
		if (element != null) {
			return this.searchRecursive(this.root, element);
		}
		return new BSTNode<>();

	}

	private BSTNode<T> searchRecursive(BSTNode<T> node, T element) {
		if(node.isEmpty() || node.getData().equals(element)) {
			return node;
		}
		else if (element.compareTo(node.getData()) > 0) {
			return searchRecursive((BSTNode<T>) node.getRight(), element);
		}
		else {
			return this.searchRecursive((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			this.recursiveInsert(this.root, element);
		}

	}

	private void recursiveInsert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
		}
		else {
			if (element.compareTo(node.getData()) > 0) {
				this.recursiveInsert((BSTNode<T>) node.getRight(), element);
			}
			else {
				this.recursiveInsert((BSTNode<T>) node.getLeft(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if(!this.isEmpty()) {
			return this.recursiveMax(this.root);
		}
		return null;
	}

	private BSTNode<T> recursiveMax(BSTNode<T> node) {
		if (node.getRight().isEmpty()) {
			return node;
		}
		else {
			return this.recursiveMax((BSTNode<T>) node.getRight());
		}
	}
	@Override
	public BSTNode<T> minimum() {
		if(!this.isEmpty()) {
			return this.recursiveMin(this.root);
		}
		return null;
	}
	private BSTNode<T> recursiveMin(BSTNode<T> node) {
		if (node.getLeft().isEmpty()) {
			return node;
		}
		else {
			return this.recursiveMin((BSTNode<T>) node.getLeft());
		}
	}
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> searchedNode = this.search(element);

		if (!(searchedNode.isEmpty())) {

			if(!searchedNode.getRight().isEmpty()) {
				searchedNode = this.recursiveMin((BSTNode<T>) searchedNode.getRight());
			}

			else {
				searchedNode = this.recursiveSucessor(searchedNode, element);
			}
		}

		if (searchedNode == null || searchedNode.isEmpty()) {
			return null;
		}

		else {
			return searchedNode;
		}

	}

	private BSTNode<T> recursiveSucessor(BSTNode<T> searchedNode, T element) {
		if (searchedNode != null && searchedNode.getData().compareTo(element) <= 0) {
			return this.recursiveSucessor((BSTNode<T>) searchedNode.getParent(), element);
		}
		else {
			return searchedNode;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> searchedNode = this.search(element);

		if (!(searchedNode.isEmpty())) {

			if(!searchedNode.getLeft().isEmpty()) {
				searchedNode = this.recursiveMax((BSTNode<T>) searchedNode.getLeft());
			}

			else {
				searchedNode = this.recursivePredecessor(searchedNode, element);
			}
		}

		if (searchedNode == null || searchedNode.isEmpty()) {
			return null;
		}

		else {
			return searchedNode;
		}
	}

	private BSTNode<T> recursivePredecessor(BSTNode<T> searchedNode, T element) {
		if (searchedNode != null && searchedNode.getData().compareTo(element) >= 0) {
			return this.recursivePredecessor((BSTNode<T>) searchedNode.getParent(), element);
		}
		else {
			return searchedNode;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> searchedNode = this.search(element);
			if (!searchedNode.isEmpty()) {
				if(searchedNode.isLeaf()) {
					searchedNode.setData(null);
					searchedNode.setLeft(null);
					searchedNode.setRight(null);
				} else if (searchedNode.getRight().isEmpty() || searchedNode.getLeft().isEmpty()) {
					BSTNode<T> child = searchedNode.getRight().isEmpty() ? (BSTNode<T>) searchedNode.getLeft() : (BSTNode<T>) searchedNode.getRight();
					if (this.root.equals(searchedNode)) {
						this.root = child;
						this.root.setParent(null);
					}
					else {
						child.setParent(searchedNode.getParent());
						if (searchedNode.getParent().getLeft().equals(searchedNode)) {
							searchedNode.getParent().setLeft(child);
						} else {
							searchedNode.getParent().setRight(child);
						}
					}
				} else {
					T proximo = this.sucessor(searchedNode.getData()).getData();
					this.remove(proximo);
					searchedNode.setData(proximo);
				}
			}
		}
	}

	@Override
	public T[] preOrder() {
		return this.recursivePreOrder(this.root, new ArrayList<>());
	}

	private T[] recursivePreOrder(BSTNode<T> node, List<T> lista){
		if (!node.isEmpty()) {
			lista.add(node.getData());
			this.recursivePreOrder((BSTNode<T>) node.getLeft(), lista);
			this.recursivePreOrder((BSTNode<T>) node.getRight(), lista);
		}
		return (T[]) lista.toArray(new Comparable[0]);
	}
	@Override
	public T[] order() {
		return this.recursiveOrder(this.root, new ArrayList<>());
	}

	private T[] recursiveOrder(BSTNode<T> node, List<T> lista) {
		if (!node.isEmpty()) {
			this.recursiveOrder((BSTNode<T>) node.getLeft(), lista);
			lista.add(node.getData());
			this.recursiveOrder((BSTNode<T>) node.getRight(), lista);
		}
		return (T[]) lista.toArray(new Comparable[0]);
	}
	@Override
	public T[] postOrder() {
		return this.recursivePostOrder(this.root, new ArrayList<>());
	}

	private T[] recursivePostOrder(BSTNode<T> node, List<T> lista) {
		if (!node.isEmpty()) {
			this.recursivePostOrder((BSTNode<T>) node.getLeft(), lista);
			this.recursivePostOrder((BSTNode<T>) node.getRight(), lista);
			lista.add(node.getData());
		}
		return (T[]) lista.toArray(new Comparable[0]);
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

package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return this.recursiveEqualsTree(tree1.getRoot(), tree2.getRoot());
	}

	private boolean recursiveEqualsTree(BTNode<T> nodeTree1, BTNode<T> nodeTree2) {
		if (nodeTree1.equals(nodeTree2)) {
			if (!nodeTree1.isEmpty() && !nodeTree2.isEmpty()) {
				return this.recursiveEqualsTree(nodeTree1.getLeft(), nodeTree2.getLeft()) &&
						this.recursiveEqualsTree(nodeTree1.getRight(), nodeTree2.getRight());
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return  this.recursiveIsSimilar(tree1.getRoot(), tree2.getRoot());
	}

	private boolean recursiveIsSimilar(BTNode<T> nodeTree1, BTNode<T> nodeTree2) {
		if (!nodeTree1.isEmpty() && !nodeTree2.isEmpty()) {
			return this.recursiveIsSimilar(nodeTree1.getLeft(), nodeTree2.getLeft()) &&
					this.recursiveIsSimilar(nodeTree1.getRight(), nodeTree2.getRight());
		}
		else {
			return (!nodeTree1.isEmpty() || nodeTree2.isEmpty()) &&
					(nodeTree1.isEmpty() || !nodeTree2.isEmpty());
		}
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		int size = tree.size();

		if (k >= 1 && k <= size) {
			BTNode<T> minimoTree = tree.minimum();

			if (k == 1) {
				return minimoTree.getData();
			} else if (k == size) {
				return tree.maximum().getData();
			} else {
				return this.recursiveOrderStatistic(tree, minimoTree, k);
			}
		}
		return null;
	}
	private T recursiveOrderStatistic(BST<T> tree, BTNode<T> node, int k) {
		if (k == 1) {
			return node.getData();
		} else {
			return this.recursiveOrderStatistic(tree, tree.sucessor(node.getData()), --k);
		}
	}

}

package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || array.length <= 1 || leftIndex >= rightIndex) {
            return; // Nothing to sort or invalid indices
        }

        boolean trocado = true;

        while (trocado) {
            trocado = false;

            // Passe para a frente: empurre elementos grandes para a direita
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    Util.swap(array, i, i + 1);
                    trocado = true;
                }
            }

            // Passe para trás: empurre pequenos elementos para a esquerda
            for (int i = rightIndex - 1; i > leftIndex; i--) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    Util.swap(array, i, i - 1);
                    trocado = true;
                }
            }
        }

	}
}

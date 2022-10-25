package sorting.variationsOfBubblesort;

import java.util.Iterator;

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
		while (rightIndex <= array.length -1 && leftIndex >= 0) {
			if (leftIndex < rightIndex) {
				boolean status = false;
				for (int i = leftIndex; i <= rightIndex -1; i++) {
					if (array[i].compareTo(array[i+1]) > 0) {
						Util.swap(array, i, i+1);
					}
					
				} rightIndex--;
				if (!status) {return;}
				for (int indice = rightIndex; indice > leftIndex; indice--) {
					if (array[indice].compareTo(array[indice-1]) < 0) {Util.swap(array, indice, indice-1);}
					
				} leftIndex++;
				
			}
		}
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}
}

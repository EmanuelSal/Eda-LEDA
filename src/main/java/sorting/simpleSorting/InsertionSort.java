package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validacao(array, leftIndex, rightIndex)) {
			for (int i = leftIndex + 1; i < array.length; i++) {
				int a = i;
				while (a > 0 && array[a].compareTo(array[a-1]) == -1) {
					Util.swap(array, a, a -1);
					a--;
				} 
			} 
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}
 }
public boolean validacao(T[] array, int leftIndex, int rightIndex) {
		
		boolean status = true;
		
		if (leftIndex < 0 || leftIndex > rightIndex) {
			status = false;
		}
		else if (array == null) {
			status = false;
			
		} 
		else if (rightIndex >= array.length || rightIndex < leftIndex) {
			status = false;
		} return status;
		
	}
}

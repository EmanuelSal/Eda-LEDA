package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && rightIndex < array.length) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex + 1, rightIndex);

			merge(array, leftIndex, middleIndex, rightIndex);
		}
}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		T[] aux = Arrays.copyOf(array, array.length);
		
		int i = leftIndex;
		int j = middleIndex + 1;
		int k = leftIndex;

		while(i <= middleIndex && j <= rightIndex) {
			if(aux[i].compareTo(aux[j])<= 0) {
				array[k] = aux[i++];
				
			} else {
				array[k] = aux[j++];
				
			}
			k++;
		}
		while (i <= middleIndex) {
			array[k++] = aux[i++];
			
		}
		while (j <= middleIndex) {
			array[k++] = aux[j++];
		}
	}
}

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
		if (leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) return;
	
		int middle = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle+1, rightIndex);
			
		merge(array, leftIndex, middle, rightIndex);
		
	}

	private void merge(T[] array, int start, int middle, int end) {
		T[] aux = Arrays.copyOf(array, array.length);
		
		
		int i = start;
		int j = middle +1;
		int k = start;
		
		while (i <= middle && j <= end) {
			if(aux[i].compareTo(array[j]) <= 0)
				array[k] = aux[i++]; 
			
			else
				array[k]= aux[j++];
			k++;
		}
		while (i <= middle) 
			array[k++] = aux[i++];
			
		while (j <= end)
			array[k++] = aux[j++];
			
		
		
		
	}
}

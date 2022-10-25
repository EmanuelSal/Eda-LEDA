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
		if (leftIndex < rightIndex) {
			int medium = (leftIndex + rightIndex) /2;
			sort(array, leftIndex, rightIndex);
			sort(array, medium+1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
	}
	public void merge(T[] array, int leftIndex, int rightIndex) {
		T[] aux = Arrays.copyOf(array, array.length);
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[i] = array[i];
		} 
		int i = leftIndex;
		int meio = (leftIndex + rightIndex) /2;
		int f = meio + 1;
		int k = leftIndex;
		
		while (i <= meio && f <= rightIndex) {
			if (aux[i].compareTo(aux[f]) > 0) {
				array[k++] = aux[i++];
			} else {
				array[k++] = aux[f++];
			}
		} while (i <= meio) {
			array[k++] = aux[i++];
		} while (f <= leftIndex) {
			array[f++] = aux[f++];
		}
			
			
		
		
		//TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
	}
}

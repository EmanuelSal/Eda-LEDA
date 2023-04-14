package sorting.divideAndConquer;

import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.stream.MemoryCacheImageOutputStream;

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
		else {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);
			
			merge(array, leftIndex, middle, rightIndex);
		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private void merge(T[] array, int ini, int middle, int fim) {
		T[] aux = Arrays.copyOf(array, array.length);
		
		
		int i = ini;
		int j = middle +1;
		int k = ini;
		
		while (i <= middle && j <= fim) {
			if(aux[i].compareTo(array[j]) <= 0)
				array[k] = aux[i++]; 
			
			else
				array[k]= aux[j++];
			k++;
		}
		while (i <= middle) 
			array[k++] = aux[i++];
			
		while (j <= fim)
			array[k++] = aux[j++];
			
		
		
		
	}
}

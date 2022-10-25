package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex <= rightIndex) {
			int index = particionar(array, leftIndex, rightIndex);
			sort(array, leftIndex, index-1);
			sort(array, index+1, rightIndex);
		}
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
	}
	public int particionar(T[] array, int inicio, int fim) {
		T pivo = array[0];
		int ini = inicio;
		
		for (int j = ini +1; j <= fim; j++) {
			if (array[j].compareTo(pivo) > 0) {
				ini++;
				Util.swap(array, ini, j);
			} 
		}Util.swap(array, inicio, ini);
		return ini;
	}
}

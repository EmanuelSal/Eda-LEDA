package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(validacao(array, leftIndex, rightIndex)) {
			
			for (int indice = leftIndex; indice <= rightIndex; indice++) {
				for (int j = indice +1; j <= rightIndex; j++) {
					if(array[indice].compareTo(array[j]) == 1) {
						Util.swap(array, indice, j);
					}
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
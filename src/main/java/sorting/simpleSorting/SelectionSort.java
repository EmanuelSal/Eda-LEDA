package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */

public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

		@Override
		public void sort(T[] array, int leftIndex, int rightIndex) {
			
			for(int i = leftIndex; i < array.length; i++) {
				int menorIndice = i;
				for (int j = menorIndice + 1; j <= rightIndex; j++) {
					if(array[menorIndice].compareTo(array[j]) == 1) {
						menorIndice = j;
					} 
				} Util.swap(array, i, menorIndice);
			}
			//throw new UnsupportedOperationException("Not Implemented yet!");
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


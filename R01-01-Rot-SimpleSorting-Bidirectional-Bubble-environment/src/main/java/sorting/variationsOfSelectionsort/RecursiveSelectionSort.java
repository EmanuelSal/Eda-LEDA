package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		while (rightIndex <= array.length-1 && leftIndex >=0) {
			if (rightIndex > leftIndex) {
				int menorIndice = leftIndex;
				for (int indice = leftIndex + 1; indice <= rightIndex; indice++) {
					if (array[indice].compareTo(array[menorIndice]) < 0) {
						menorIndice = indice;
					} Util.swap(array, leftIndex, menorIndice);
					Util.swap(array, leftIndex +1, rightIndex);
				}
			} 
		}
		
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}

}

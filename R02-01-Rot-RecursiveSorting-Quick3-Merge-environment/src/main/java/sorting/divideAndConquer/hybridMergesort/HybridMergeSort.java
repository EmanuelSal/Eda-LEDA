package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		int tamanho = array.length;
		if (tamanho >=0 && tamanho <= SIZE_LIMIT) {insertionSort(array, leftIndex, rightIndex);}
		else {
			
			int medium = (leftIndex + rightIndex) /2;
			sort(array, leftIndex, rightIndex);
			sort(array, medium + 1, rightIndex);
			merge(array, leftIndex, medium, rightIndex);
		}
	}
	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] auxiliar = Arrays.copyOf(array, array.length);
		for (int i = leftIndex; i <= rightIndex; i++) {
			auxiliar[i] = array[i];
		} 
		int i = leftIndex;
		int medium = meio +1;
		int k = leftIndex;
		
		while (i <= meio && medium <= rightIndex) {
			if (auxiliar[i].compareTo(auxiliar[medium]) > 0) {
				array[k++] = auxiliar[i++];
			} 
			else {array[k++] = auxiliar[medium++];}
		} 
		while (i <= meio) {array[k++] = auxiliar[i++];} 
		while (medium <= leftIndex) {array[medium++] = auxiliar[medium++];}
		MERGESORT_APPLICATIONS++;
	
	}
	
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i < array.length; i++) {
			int a = i;
			while (a > 0 && array[a].compareTo(array[a-1]) == -1) {
				Util.swap(array, a, a -1);
				a--;} 
		} INSERTIONSORT_APPLICATIONS++;
	}
}

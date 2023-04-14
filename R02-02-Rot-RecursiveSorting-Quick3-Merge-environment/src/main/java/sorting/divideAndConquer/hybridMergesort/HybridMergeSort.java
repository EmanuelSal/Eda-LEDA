package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;

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

    public static final int SIZE_LIMIT = 4;

    protected static int MERGESORT_APPLICATIONS = 0;
    protected static int INSERTIONSORT_APPLICATIONS = 0;

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        MERGESORT_APPLICATIONS = 0;
        INSERTIONSORT_APPLICATIONS = 0;
        hybridMergeSort(array, leftIndex, rightIndex);
    }

    private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex + 1 <= SIZE_LIMIT) {
            insertionSort(array, leftIndex, rightIndex);
            INSERTIONSORT_APPLICATIONS++;
        } else {
            int middleIndex = (leftIndex + rightIndex) / 2;
            hybridMergeSort(array, leftIndex, middleIndex);
            hybridMergeSort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
            MERGESORT_APPLICATIONS++;
        }
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

    private void insertionSort(T[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= leftIndex && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            } 

            array[j + 1] = key;
        }
    }

}


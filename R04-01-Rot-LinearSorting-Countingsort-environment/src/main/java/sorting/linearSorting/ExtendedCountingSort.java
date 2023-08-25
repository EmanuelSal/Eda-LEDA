package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && rightIndex < array.length) {
			//encontrando o maior elemento
			
			int maiorElem = array[leftIndex];
			int menorElem = array[leftIndex];
			for (int i = leftIndex+1; i <= rightIndex; i++) {
				if(array[i] > maiorElem) {
					maiorElem = array[i];
				}
			}
			for (int i = leftIndex+1; i <= rightIndex; i++) {
				if(array[i] < menorElem) {
					menorElem = array[i];
				}
			}

			int[] aux = new int[maiorElem - menorElem + 1];

			// frequencia
			for (int i = leftIndex; i <= rightIndex; i++) {
				aux[array[i] - menorElem] +=1;
			}

			//soma cumulativa no array "aux"
			for (int i = 1; i < aux.length; i++) {
				aux[i] += aux[i-1];
			}

			int[] helper = new int[rightIndex - leftIndex + 1];
			for (int i = rightIndex; i >= leftIndex; i--) {
				helper[aux[array[i] - menorElem] -1] = array[i];
				aux[array[i] - menorElem] -= 1;
			}
			
			for (int i = 0; i < helper.length; i++) {
				array[leftIndex + i] = helper[i];
			}

		}
	}

}

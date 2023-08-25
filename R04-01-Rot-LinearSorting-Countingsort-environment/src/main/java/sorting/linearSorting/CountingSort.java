package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && rightIndex < array.length) {
		//encontrando o maior elemento
		
		int maiorElem = array[leftIndex];

		for (int i = leftIndex+1; i <= rightIndex; i++) {
			if(array[i] > maiorElem) {
				maiorElem = array[i];
			}
		}

		int[] aux = new int[maiorElem + 1];
		
		//frequencia 
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[array[i]] += 1;
		}

		//soma cumulativa no array "aux"
		for (int i = 1; i < aux.length; i++) {
			aux[i] += aux[i-1];
		}
		
		//iterando invertido sobre o vetor original e registrando em um array auxiliar os elementos
		int[] helper = new int[rightIndex - leftIndex + 1];
		for (int i = rightIndex; i >= leftIndex; i--) {
			helper[aux[array[i]] -1] = array[i];
			aux[array[i]] -= 1;
		}
		
		// passando os valores de helper , para array original
		for (int i = 0; i < helper.length; i++) {
			array[leftIndex + i] = helper[i];
		}
		
		}
	}

}

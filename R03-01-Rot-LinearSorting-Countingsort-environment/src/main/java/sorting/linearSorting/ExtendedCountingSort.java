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
		if (array.length == 0) {return;}
		
		int maior = array[0];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		int menor = array[0];
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		
		int[] helper = new int[maior - menor + 1];
		
		// fazendo a frequencia
		for (int j = leftIndex; j < array.length; j++) {
			helper[array[j] - menor]++;
		}
		// Cumulativa 
		for (int i = 1; i < helper.length; i++) {
			helper[i] += helper[i -1];	
		}
		
		// ordenando
		int[]array2 = new int[array.length];
		for(int a = rightIndex; a >= leftIndex; a--) {
			array2[helper[array[a]- menor]-1] = array[a];
			helper[array[a]- menor]--;
		}
		// como ele não pede pra retornar nada, passei pro array inicial
		for(int s = 0; s < array2.length; s++) {
			array[s] = array2[s];
		}
	}
}	
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
		if(array.length == 0) {
			return;
		}
		int k = array[0]; 
		// Procurando o maior
		for(int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > k) {
				k = array[i];
			}

		} int[] helper = new int[k + 1];
		//System.out.println(helper.length);
		// Frequencia
		for (int j = leftIndex; j < array.length; j++) {
			helper[array[j]]++;
			//System.out.println(Arrays.toString(helper)); //[30, 28, 7, 29, 11, 26, 4, 22, 23,
//			31 ]
		} 
		// Cumulativa
		for (int i = 1; i < helper.length; i++) {
			helper[i] += helper[i -1];	
		
		}
		int[]array2 = new int[array.length];
		//System.out.println("---");
		for(int a = rightIndex; a >= leftIndex; a--) {
			array2[helper[array[a]]-1] = array[a];
			helper[array[a]]--;
			
		
			
			
		}
		for(int s = 0; s < array2.length; s++) {
			array[s] = array2[s];
		}
		
	}// [4, 9, 3, 4, 0, 5, 1, 4]
}
package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
		int indexMax = position;

		if(this.isValid(this.left(position)) && this.compare(position, this.left(position)) < 0) {
			indexMax = this.left(position);
		}
		if(this.isValid(this.right(position)) && this.compare(position, this.right(position)) > 0) {
			indexMax = this.right(position);
		}

		if(indexMax != position) {
			Util.swap(this.heap, position, indexMax);
			heapify(indexMax);
		}
	}
	private int compare(int index1, int index2) {
		return this.comparator.compare(this.heap[index1], this.heap[index2]);
	}
	private boolean isLeaf(int index) {
		return (index >= this.parent(this.index) && index <= this.index);
	}
	private boolean isValid(int index) {
		return index >= 0 && index <= this.index;
	}

	@Override
	public void insert(T element) {
		if(element != null) {// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
			if (index == heap.length - 1) {
				heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
			}
			// /////////////////////////////////////////////////////////////////
			this.heap[++this.index] = element;
			int index = this.index;

			while (index > 0 && this.compare(index, this.parent(index)) > 0) {
				Util.swap(this.heap, index, this.parent(index));
				index = this.parent(index);
			}
		}
	}


	@Override
	public void buildHeap(T[] array) {
		this.heap = array.clone();
		this.index = array.length -1;
		for (int i = array.length /2; i >= 0; i--) {
			this.heapify(i);
		}
	}

	@Override
	public T extractRootElement() {
		T saida = null;

		if(!this.isEmpty()) {
			saida = this.rootElement();
			this.heap[0] = this.heap[this.index--];
			this.heapify(0);
		}
		return saida;
	}

	@Override
	public T rootElement() {
		T element = null;

		if(!this.isEmpty()) {
			element = this.heap[0];
		}
		return element;
	}


	@Override
	public T[] heapsort(T[] array) {
		if (array.length >= 2) {
			this.buildHeap(array);
			if(this.rootElement().compareTo(this.heap[this.index]) >0) {
				for (int i = this.index; i >= 0 ; i--) {
					array[i] = this.extractRootElement();
				}
			}
			else {
				for (int i = 0; i < array.length ; i++) {
					array[i] = this.extractRootElement();
				}
			}
		}
		return array;
	}

	@Override
	public int size() {
		return this.index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}

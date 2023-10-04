package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			throw new HashtableOverflowException();
		}
		if (element != null && this.search(element) == null) {
			int probin = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probin);
			
			while (this.table[index] != null && !this.table[index].equals(this.deletedElement) && probin < this.table.length) {
				
				probin++;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probin);
				this.COLLISIONS++;

			}
			
			this.table[index] = element;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		int index = this.indexOf(element);
		if (index >= 0) {
			this.table[index] = this.deletedElement;
			this.elements--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T procurado = null;
		int indexOf = indexOf(element);
		if (indexOf >= 0) {
			procurado = (T) this.table[indexOf];
		}

		return procurado;
	}

	@Override
	public int indexOf(T element) {
		int i = -1;
		if (!isEmpty() && element != null) {
			
			int probin = 0;
			int index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probin);
			
			while (this.table[index] != null && !this.table[index].equals(element) && probin < this.table.length) {
				
				probin++;
				index = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probin);
			
			}
			
			if (this.table[index] != null && this.table[index].equals(element)) {
				i = index;
			}

		}
		return i;
	}
}


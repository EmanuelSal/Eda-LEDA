package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(isFull()) {
			throw new HashtableOverflowException();
		}
		if(element != null && this.search(element) == null) {
			int probin = 0;
			int index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probin);

			while (this.table[index] != null && !this.table[index].equals(this.deletedElement) && probin < this.table.length) {
				probin++;
				index = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probin);
				this.COLLISIONS++;
			}
			this.table[index] = element;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		int indexOf = this.indexOf(element);
		if (indexOf >= 0) {
			this.table[indexOf] = this.deletedElement;
			this.elements--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T procurado = null;
		int index = indexOf(element);
		if (index >= 0) {
			procurado = (T) this.table[index];
		}
		return procurado;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if(!isEmpty() && element != null) {
			int probin = 0;
			int ind = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probin);
			while(this.table[ind] != null && !this.table[ind].equals(element) && probin < this.table.length) {
				probin++;
				ind = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probin);
			}
			if(this.table[ind] != null && this.table[ind].equals(element)) {
				index = ind;
			}
		}
		return index;
	}

}

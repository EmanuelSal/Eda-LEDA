package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() { 

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
<<<<<<< HEAD
		if(isEmpty()){
			return 0;
		}
		return 1 + next.size();
=======
		if (this.isEmpty())
			return 0;

		return 1 + this.next.size();
>>>>>>> 7850f8c2428dc4677772c7537b02464db5c5d4c5
	}

	@Override
	public T search(T element) {
		if (element != null) {
			if (this.isEmpty() || this.data.equals(element)){
				return this.data;
			} else
				return this.next.search(element);
		}
		return null;
	}

	@Override
	public void insert(T element) {
<<<<<<< HEAD
		if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else
				this.next.insert(element);
		}
=======
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			} else
				this.next.insert(element);
		}
	}
>>>>>>> 7850f8c2428dc4677772c7537b02464db5c5d4c5

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else
				this.next.remove(element);
		}
	}

	@Override
	public T[] toArray() {
<<<<<<< HEAD
		ArrayList<T> retorno = new ArrayList<>();
		toArrayRecursivo(retorno);
		return retorno.toArray((T[]) new Object[this.size()]);
	}

	private void toArrayRecursivo(ArrayList<T> array) {
		if (!isEmpty()) {
			array.add(this.data);
			this.next.toArrayRecursivo(array);

		}
=======
		
		List<T> retorno = new ArrayList<>();
		return this.toArray(retorno);
		// TODO Auto-generated method stub
	}

	private T[] toArray(List<T> array) {
		if (!isEmpty()) {

		array.add(data);
		next.toArray(array);

		} 
		return (T[]) array.toArray();
>>>>>>> 7850f8c2428dc4677772c7537b02464db5c5d4c5
	}	



	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}

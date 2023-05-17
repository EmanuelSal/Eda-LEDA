package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {

		if (element != null) {

			if (isEmpty()) { 
				RecursiveDoubleLinkedListImpl<T> auxlast = new RecursiveDoubleLinkedListImpl<>();

				this.data = element;
				this.next = auxlast;
				auxlast.previous = this;

				if (this.previous == null) {

					RecursiveDoubleLinkedListImpl<T> auxhead = new RecursiveDoubleLinkedListImpl<>();

					this.previous = auxhead;
					auxhead.next = this;
				
			}
			
		} 
			else { 
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {

		if (this.data.equals(element)) {

			if (this.previous.isEmpty()) {
				this.removeFirst();}
			else if (this.next.isEmpty()) {this.removeLast();}
			
			else {

				this.previous.setNext(next);
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(previous);
			
			}
			
		} 
			else {next.remove(element);}
		}
	}

	@Override
	public void insertFirst(T element) {
		
		if (element != null) {

			if (this.isEmpty()) {

				this.insert(element);
			
			} else {
			
			RecursiveDoubleLinkedListImpl<T> nodeAux = new RecursiveDoubleLinkedListImpl<>();

			nodeAux.data = this.data;
			data = element;
			nodeAux.next = this.next;
			this.next = nodeAux;
			nodeAux.previous = this;

			((RecursiveDoubleLinkedListImpl<T>) this.next).setNext(nodeAux);

			}
		}
	}

	@Override
	public void removeFirst() {
		
		if (!isEmpty()) {

		if (this.next.isEmpty()) {
			
			this.data = null;
			this.previous = null;
			this.next = null;
			
		}	
			else {
		
				this.data = next.data;
				this.next = next.getNext();
			
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
			
			}
		}		
	}
	
	@Override
	public void removeLast() {
		
		if (!isEmpty()) {

			if (next.isEmpty()) {

				this.data = null;
				this.next = null;
			
			if (this.previous.isEmpty()) {this.previous = null;} 
				
			} 
		
			else {((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();}
		
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
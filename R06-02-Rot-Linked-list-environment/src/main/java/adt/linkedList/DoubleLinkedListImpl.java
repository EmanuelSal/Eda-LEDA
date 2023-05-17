package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {

			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			
			newNode.data = element;
			newNode.next = this.head;
			newNode.previous = new DoubleLinkedListNode<>();
			
			((DoubleLinkedListNode<T>) this.head).previous = newNode;

			if(this.getLast().isNIL()) {
				this.setLast(newNode);
			}
			
			this.head = newNode;
		}
		
	}
	public void insert(T element) {
		if(element != null){
			
			DoubleLinkedListNode<T> nodeAux = new DoubleLinkedListNode<>();
			
			nodeAux.data = element;
			nodeAux.previous = this.getLast();

			nodeAux.setNext(new DoubleLinkedListNode<>());

			this.last.setNext(nodeAux);

			if(this.last.isNIL()) {
				this.head = nodeAux;
			}

			this.setLast(nodeAux);
		}
		
	}
	
	@Override
	public void remove(T element) {
		if(element != null) {

			if (this.getHead().equals(element)) {
				this.removeFirst();
			} 
			else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();

				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.next;
				}

				if (!aux.isNIL()) {
				
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				
				}
			}
		}
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
		
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			this.head = this.head.getNext();

			if (this.head.isNIL())
				this.last = ((DoubleLinkedListNode<T>) this.head);
			else {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();

				((DoubleLinkedListNode<T>) this.head).setPrevious(nil);
				nil.setNext(this.head);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			
		
		this.setLast(this.getLast().getPrevious());

		if(this.getLast().isNIL()) {this.setHead(this.getLast());}
			
		this.getLast().setNext(new SingleLinkedListNode<>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}

package adt.linkedList;



public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}
	

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		int size = 0;
		if(this.head.isNIL()) size = 0;  
		SingleLinkedListNode<T> aux = this.head;
		while (!aux.isNIL()) {
			size ++;
			aux.getNext();
		} return size;
	}

	@Override
	public T search(T element) {
		T resulT = null;
		SingleLinkedListNode<T> auxNode = this.head;
		while(!auxNode.isNIL()) {
			if (auxNode.getData().equals(element)) { 
				resulT = auxNode.getData();
				}
			auxNode.getNext();
		}
		return resulT;
		
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxNode = this.head;
		if (this.head.isNIL()) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<T>());
			this.head = newNode;
		}
		while(!auxNode.isNIL()) {
			auxNode = auxNode.next;
		}
		auxNode.setData(element);
		auxNode.setNext(new SingleLinkedListNode<>(element, new SingleLinkedListNode<>()));
		head = auxNode;
		
		
		
	}
	

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] arraySaida = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = this.head;
		for (int i = 0; i < this.size(); i++) {
			arraySaida[i] = auxNode.getData();
			auxNode = auxNode.getNext();
		}
		return arraySaida;
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

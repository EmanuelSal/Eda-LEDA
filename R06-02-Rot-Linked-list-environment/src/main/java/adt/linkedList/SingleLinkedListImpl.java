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
		//if(this.head.isNIL()) size = 0;  
		SingleLinkedListNode<T> aux = this.head;
		while (!aux.isNIL()) {
			size ++;
			aux = aux.getNext();
		} return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxNode = this.head;
		while(!auxNode.isNIL()) {
			if (auxNode.getData().equals(element)) { 
				return auxNode.getData();
				}
			auxNode = auxNode.getNext();
		}
		return null;
		
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			SingleLinkedListNode<T> auxNode = this.head;
			while(!auxNode.isNIL()) {
				auxNode = auxNode.getNext();
		}
		auxNode.setData(element);
		auxNode.setNext(new SingleLinkedListNode<>());
		//head = auxNode;
		
		}
		
	}
	

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			SingleLinkedListNode<T> auxNode = this.head;
			while (!auxNode.isNIL() && !auxNode.getData().equals(element)) {
				auxNode = auxNode.getNext();
			}
			if (!auxNode.isNIL()) {
				auxNode.data = auxNode.getNext().getData();
				auxNode.next = auxNode.getNext().getNext();
			}
		}
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] arraySaida = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = this.head;
		for (int i = 0; i < arraySaida.length; i++) {
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

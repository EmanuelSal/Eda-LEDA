package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	private int elements;
	
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
		SingleLinkedListNode aux = new SingleLinkedListNode<T>();
		while (aux.isNIL()) {
			size ++;
			aux.getNext();
		} return size;
	}

	@Override
	public T search(T element) {
		
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

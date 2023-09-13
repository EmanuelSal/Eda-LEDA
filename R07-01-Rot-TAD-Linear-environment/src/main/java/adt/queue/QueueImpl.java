package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T resultado = array[0];
		if(this.isEmpty()) {
			resultado = null;
		}
		return resultado;// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == array.length-1;
	}

	private void shiftLeft() {
		for (int i = 0; i < this.tail; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!this.isFull()) {
			this.array[++tail] = element;
		}
		else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resultado; 
		if (!this.isEmpty()) {
			resultado = this.head();
			this.shiftLeft();
			this.tail--;
			return resultado;
		}
		else {
		throw new QueueUnderflowException();
		}
	}

}

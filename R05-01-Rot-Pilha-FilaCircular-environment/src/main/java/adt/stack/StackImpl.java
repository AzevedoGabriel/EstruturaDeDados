package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		if(size <= 0) {
			throw new RuntimeException();
		}
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public void push(T elem) throws StackOverflowException {
		if(top + 1 == array.length) {
			throw new StackOverflowException();
		}
		array[++top] = elem;
		
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T elem = array[top];
		array[top] = null;
		top--;
		return elem;
	}

	@Override
	public T top() {
		if(isEmpty()) {
			return null;
		}
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean isFull() {
		return (array.length == top + 1);
	}
	

}
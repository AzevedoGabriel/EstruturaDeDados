package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		if(this.data == null) {
			return true;
		}
		else {
			return false;
		}		
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if(!(element == null)) {
		if(isEmpty()) {
			return null;
		}
		else {
			if(data == element) {
				return data;
			}
			else {
				return next.search(element);
			}
		}
	} return null;
}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		}
		else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (isEmpty()) {
				//Não faz nada.
			} else {
				if (data == element) {
					data = next.data;
					next = next.next;
				} else {
					next.remove(element);
				}
			}
		}
	}
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		toArray(array, this, 0);
		return array;
	}
	
	public T[] toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int position) {
		if (node == null) {
			return array;
		}
		if (node.isEmpty()) {
			return array;
		}
		else {
			array[position++] = node.data;
			return toArray(array, node.next, position);
		}
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

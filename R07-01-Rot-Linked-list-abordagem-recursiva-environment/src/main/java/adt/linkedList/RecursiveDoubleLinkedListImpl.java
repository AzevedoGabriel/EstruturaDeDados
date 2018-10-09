package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data,RecursiveSingleLinkedListImpl<T> next,RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}


	@Override
	public void insertFirst(T element) {
		if (element != null) {
			RecursiveDoubleLinkedListImpl<T> newNode= new RecursiveDoubleLinkedListImpl<T>(data, next, this);
			previous = new RecursiveDoubleLinkedListImpl<T>();
			this.data = element;
			this.next = newNode;
			((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
		}
}
	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
				
				if (getPrevious() == null) setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			} else getNext().insert(element);
		}
	}

	@Override
	public void removeFirst() {
		if (!(isEmpty())) {
			previous = new RecursiveDoubleLinkedListImpl<T>();
			data = next.data;
			next = next.next;
		}
}

	@Override
	public void removeLast() {
		if (!(isEmpty())) {
			buscaRemoveUltimo(this);
		}
	}

	private void buscaRemoveUltimo(RecursiveDoubleLinkedListImpl<T> node) {
		if (node.getNext().getData() == null) {
			if (node.getPrevious().getData() == null) {
				node.setData(null);
				node.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			} else {
				node.getPrevious().setNext(new RecursiveDoubleLinkedListImpl<T>());
			}
		} else {
			buscaRemoveUltimo((RecursiveDoubleLinkedListImpl<T>) node.getNext());
		}
	}
	@Override
	public void remove(T element) {
		if (element != null) {
			if (!(isEmpty())) {
				if(getData() == element) {
					if(getPrevious().isEmpty() && getNext().isEmpty()) {
						setData(null); 
						setNext(null); 
						setPrevious(null);
					} else {
						setData(getNext().getData());
						setNext(getNext().getNext());
						
						if(next!= null) {
							((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
						}
					}
				} else getNext().remove(element);
			}
		}
}



	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

	public T getLast() {
		if (getNext().getData() != null) {
			return ((RecursiveDoubleLinkedListImpl<T>) getNext()).getLast();
		} else {
			return getData();
		}
}

}

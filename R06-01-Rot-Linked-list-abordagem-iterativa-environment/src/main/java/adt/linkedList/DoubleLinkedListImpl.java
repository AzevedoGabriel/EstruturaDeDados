package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		last = new DoubleLinkedListNode<T>();
		head = last;
	}

	@Override
	public T search(T element) {
		
		T result = null;
		if(element != null) {
			
			DoubleLinkedListNode<T> tempHead = (DoubleLinkedListNode<T>) head;
			DoubleLinkedListNode<T> tempLast = last;
			
			while(!tempHead.equals(tempLast) && !tempHead.next.equals(tempLast) && !element.equals(tempHead.data)
					&& !element.equals(tempLast.data)) {
				tempHead = (DoubleLinkedListNode<T>) tempHead.next;
				tempLast = tempLast.previous;
			}
			if(element.equals(tempHead.data)) result = tempHead.data;
			if(element.equals(tempLast.data)) result = tempLast.data;
		}
		return result;
		
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), last);
			((DoubleLinkedListNode<T>) node.next).previous = node;
			last.next = node;
			if(last.isNIL()) head = node;
			last = node;
			
		}

	}

	@Override
	public void remove(T element) {
		
		if(element != null) {
			
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
			DoubleLinkedListNode<T> tempLast = last;
			DoubleLinkedListNode<T> node = null;
			
			while(!auxHead.equals(tempLast) && !auxHead.next.equals(tempLast) && !element.equals(auxHead.data)
					&& !element.equals(tempLast.data)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.next;
				tempLast = tempLast.previous;
			}
			if(element.equals(auxHead.data)) node = auxHead;
			if(element.equals(tempLast.data)) node = tempLast;
			
			node.previous.next = node.next;
			((DoubleLinkedListNode<T>) node.next).previous = node.previous;
		}
		
	}

	@Override
	public void insertFirst(T element) {
		
		if(element != null) {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element,
			(DoubleLinkedListNode<T>) head,
			((DoubleLinkedListNode<T>) head).previous);
			((DoubleLinkedListNode<T>) head).previous.next = node;
			((DoubleLinkedListNode<T>) head).previous = node;
			head = node;
		}
		
	}

	@Override
	public void removeFirst() {
		
		if(!isEmpty()) {
			((DoubleLinkedListNode<T>) head).previous.next = head.next;
			((DoubleLinkedListNode<T>) head.next).previous = ((DoubleLinkedListNode<T>) head).previous;
			head = head.next;
			if(head.isNIL()) last = (DoubleLinkedListNode<T>) head;
		}
		
	}

	@Override
	public void removeLast() {
		
		if(!isEmpty()) {
			last.previous.next = last.next;
			((DoubleLinkedListNode<T>) last.next).previous = last.previous;
			last = last.previous;
			if(last.isNIL()) head = last;
		}
		
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
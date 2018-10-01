package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element,null,null);
		newHead.next = head;
		newHead.previous = new DoubleLinkedListNode<>();
		if (head instanceof DoubleLinkedListNode) {
			((DoubleLinkedListNode<T>) head).previous = newHead;
		}
		if(head.isNIL()) {
			last = newHead;
		}
		head = newHead;
	}

	@Override
	public void removeFirst() {
		if(!(head.isNIL())) {
			head = head.next;
		}else {
			last = (DoubleLinkedListNode<T>) head;
			
		}
		((DoubleLinkedListNode<T>) this.head).previous = new DoubleLinkedListNode<T>();
	}

	@Override
	public void removeLast() {
		if(!(last.isNIL())) {
			last = last.previous;
			if(last.isNIL()) {
				head = last;
			}
			((DoubleLinkedListNode<T>) last).next = new DoubleLinkedListNode<T>();
		}
			
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}

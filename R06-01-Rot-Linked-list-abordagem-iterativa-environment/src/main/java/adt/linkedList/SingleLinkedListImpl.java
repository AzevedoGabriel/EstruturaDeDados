package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean resultado = false;
		if(head.isNIL()) {
			resultado = true;
		}
		return resultado;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while(!(aux.isNIL())) {
			size++;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		while(!(aux.isNIL()) && aux.data != element) {
			aux = aux.next;
		}
		return  aux.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = head;
		if(head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element,null);
			newHead.next = head;
			head = newHead;
		}
		else {
			while(!(auxHead.next.isNIL())) {
				auxHead = auxHead.next;
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element,null);
			newNode.next = auxHead.next;
			auxHead.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		
		if(head.data == element) {
			head = head.next;
		}
		else {
			SingleLinkedListNode<T >aux = head;
			SingleLinkedListNode<T> previous = null;
			while(!(aux.isNIL()) && aux.data != element) {
				previous = aux;
				aux = aux.next;
			}
			if(!(aux.isNIL())) {
				previous.next = aux.next;
			}
			
			
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = head;
		int count = 0;
		while(!(aux.isNIL()) && (aux != null)) {
			result[count] = aux.data;
			aux = aux.next;
			count++;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	
}

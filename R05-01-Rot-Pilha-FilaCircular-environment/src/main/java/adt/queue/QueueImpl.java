package adt.queue;

public class QueueImpl<T> implements Queue<T> {

   private T[] array;
   private int tail;

   @SuppressWarnings("unchecked")
   public QueueImpl(int size) {
	   if(size <= 0) {
			throw new RuntimeException();
		}
      array = (T[]) new Object[size];
      tail = -1;
   }

   @Override
   public void enqueue(T elem) throws QueueOverflowException {
      if (isFull()) {
         throw new QueueOverflowException();
      }
      array[++tail] = elem;

   }

   @Override
   public T dequeue() throws QueueUnderflowException {
      if (isEmpty()) {
         throw new QueueUnderflowException();
      }
      T elemen = array[0];
      array[0] = null;
      tail--;
      return elemen;
   }

   @Override
   public T head() {
	   if(isEmpty()) {
		   return null;
	   }
      return array[0];
   }

   @Override
   public boolean isEmpty() {
      return (tail == -1);
   }

   @Override
   public boolean isFull() {
      return (tail == array.length);
   }

   private void shiftLeft() {
      int contador = 0;
      for (int i = 0; i < array.length - 1; i++) {
         array[i] = array[i + 1];
         contador += 1;
      }

   }

}

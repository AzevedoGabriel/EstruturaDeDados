package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
       //VErifica se as entradas são válidas.
       if(leftIndex < rightIndex && array != null && leftIndex >= 0 ) {
    	   
    	  // vai escolher o meio, para começar a ordenar o lado esquerdo e direito da lista
         int middle = partition(array, leftIndex, rightIndex);
         sort(array, leftIndex, middle - 1);
         sort(array, middle + 1, rightIndex);

       }
   }
   /**
    * Metodo que vai realizar as trocas na lista.
    * @param array - array a ser recebido.
    * @param leftIndex - indice de onde começará.
    * @param rightIndex - indice onde terminará.
    * @return um inteiro representado o middle.
    */
   private int partition(T[] array, int leftIndex, int rightIndex) {
      int pivot = leftIndex;
      int i = leftIndex;
      for (int j = leftIndex + 1; j <= rightIndex; j++) {
         if (array[j].compareTo(array[pivot]) < 0) {

            Util.swap(array, ++i, j);

         }
      }
      Util.swap(array, pivot, i);

      return i;
   }
}

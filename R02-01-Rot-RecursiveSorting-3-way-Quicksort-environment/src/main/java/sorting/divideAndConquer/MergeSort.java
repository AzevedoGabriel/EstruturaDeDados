package sorting.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {

      if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length != 0) {
    	 int meio = (leftIndex + rightIndex) / 2;
    	 T[] esquerda = Arrays.copyOfRange(array, leftIndex, meio);
    	 T[] direita = Arrays.copyOfRange(array, meio + 1, rightIndex);
         sort(array, leftIndex, meio);

         sort(array, meio + 1, rightIndex);

         merge(array, esquerda, direita);

      }

   }

   public List merge(T[] array, T[] esquerda, T[] direita) {
      List resultado = new ArrayList<T>();
      System.out.println(resultado);
      while(esquerda.length > 0 && direita.length > 0) {
    	  if(esquerda[0].compareTo(direita[0]) <= 0) {
    		  resultado.add(esquerda[0]);
    		  esquerda = Arrays.copyOfRange(esquerda, 1, esquerda.length);
    	  }
    	  else {
    		  resultado.add(direita[0]);
    		  direita = Arrays.copyOfRange(direita, 1, direita.length);
    	  }
      }
      
      if(esquerda.length > 0) {
    	  for(int i = 0; i < esquerda.length;i++)
    	  resultado.add(esquerda[i]);
      }
      if(direita.length > 0) {
    	  for(int i = 0; i < direita.length;i++)
        	  resultado.add(direita[i]);
      }
     
      return resultado;
      
   }
}

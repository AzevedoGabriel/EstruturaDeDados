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
      if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length != 0) {
         if (leftIndex > rightIndex) {
            return;
         }
         if (leftIndex < rightIndex) {
            int m = partition(array, leftIndex, rightIndex);
            sort(array, leftIndex, m - 1);
            sort(array, m + 1, rightIndex);
         }
      }
   }

   private int partition(T[] array, int leftIndex, int rightIndex) {
      T pivot = array[leftIndex];
      int i = leftIndex, f = rightIndex;
      while (i <= f) {
         if (array[i].compareTo(pivot) <= 0) {
            i++;
         } else if (pivot.compareTo(array[f]) < 0) {
            f--;
         } else {
           Util.swap(array, i, f);
            i++;
            f--;
         }
      }
      array[leftIndex] = array[f];
      array[f] = pivot;
      return f;
   }
}

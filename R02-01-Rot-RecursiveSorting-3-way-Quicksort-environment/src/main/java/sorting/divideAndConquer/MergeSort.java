package sorting.divideAndConquer;

import java.util.Arrays;

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

      // Vai verificar a validade dos parâmetros passados.
      if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length != 0) {
         if (array.length == 1) {
            return;
         }
         // vai definir o meio, para ir dividindo a lista, até ficar com tamanho 1 e então comaça a junção até,
         //a lista ficar ordenada.
         int meio = ((leftIndex + rightIndex) / 2);
         sort(array, leftIndex, meio);
         sort(array, meio + 1, rightIndex);
         merge(array, leftIndex, meio, rightIndex);

      }
  

   }
   
   /**
    * Metodo que daŕa o merge na lista, ordenando-a.
    * @param array - array a ser recebido.
    * @param leftIndex - indice onde começará.
    * @param meio - meio de onde a lista vai ser dividida.
    * @param rightIndex - onde termina a ordenação.
    */
   public void merge(T[] array, int leftIndex, int meio, int rightIndex) {

      T[] auxiliar = Arrays.copyOf(array, array.length);

      int i = leftIndex;
      int j = meio + 1;
      int k = leftIndex;

      while (i <= meio && j <= rightIndex) {

         if (auxiliar[i].compareTo(auxiliar[j]) <= 0) {
            array[k] = auxiliar[i];
            i++;
         } else {
            array[k] = auxiliar[j];
            j++;
         }
         k++;

      }

      while (i <= meio) {
         array[k] = auxiliar[i];
         i++;
         k++;
      }
      while (j <= rightIndex) {
         array[k] = auxiliar[j];
         j++;
         k++;
      }
   }

}
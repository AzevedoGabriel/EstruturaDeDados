package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length && array.length != 0) {
         int menor = array[leftIndex];
         int maior = 0;

         for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i] > maior) {
               maior = array[i];
            }
            if (array[i] < menor) {
               menor = array[i];
            }
         }

         int offSet = menor;
         int[] c = new int[maior - menor + 1];
         int[] resultado = new int[array.length];

         for (int i = leftIndex; i <= rightIndex; i++) {
            c[array[i] - offSet]++;
         }

         for (int i = 0; i < c.length - 1; i++) {
            c[i + 1] += c[i];

         }

         for (int i = rightIndex; i >= leftIndex; i--) {
            c[array[i] - offSet] = c[array[i] - offSet] - 1;
            resultado[c[array[i] - offSet] + leftIndex] = array[i];
         }

         for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] = resultado[i];
         }

      }
   }

}

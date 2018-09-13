package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

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
			    
			  //{9,3,1,7,4,1};
			    for (int i = rightIndex; i >= leftIndex; i--) {
			    	c[array[i] - offSet] = c[array[i] - offSet] - 1;
			        resultado[c[array[i] - offSet] + leftIndex] = array[i];
			    }
			    

			    for (int i = leftIndex; i <= rightIndex; i++) {
			        array[i] = resultado[i];
			    }

			    //System.out.println(Arrays.toString(array));
			}
			}
				
			
			


		 

			
	}



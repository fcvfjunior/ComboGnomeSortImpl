
package sorting.variationsOfBubblesort;

import java.util.Arrays;
import sorting.AbstractSorting;
import util.Util;
import util.Util;

/**
 * A mediana de uma colecao/array de valores é o valor que divide a coleção na
 * metade. A forma mais custosa de encontrar a mediana seria ordenar o array
 * completo e escolher o elemento do meio do array. Essa abordagem limita o
 * tempo de execucao ao tempo do algoritmo de ordenacao utilizado. Sabe-se que a
 * mediana é um excelente pivot para garantir um bom tempo de execução do
 * quicksort.
 * 
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos
 * dados a serem ordenados como pivot. Utilize a estrategia de selection sort
 * para encontrar a mediana (sem modificar o array original). Depois use-a como
 * o pivot do quicksort.
 * 
 * Requisitos: - Voce nao pode ordenar o array e escolher o elemento da metade -
 * Voce nao pode utilizar array extra (tem que ser in-place) - O uso do
 * selection eh apenas para encontrar a mediana, mas nao deve modificar o array
 * de forma alguma.
 */
public class QuickSortComMediana<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int middle = this.halfSelectionSort(array, leftIndex, rightIndex);
			int pivotIndex = this.partition(array, leftIndex, rightIndex, rightIndex);
			this.sort(array, leftIndex, pivotIndex - 1);
			this.sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex, int pivotIndex) {
		Util.swap(array, pivotIndex, rightIndex);

		int i = leftIndex, j = rightIndex - 1;
		while (i < j) {
			if (array[i].compareTo(array[rightIndex]) < 0) {
				i++;
			} else if (array[j].compareTo(array[rightIndex]) >= 0) {
				j--;
			} else {
				Util.swap(array, i++, j--);
			}
		}
		if (array[j].compareTo(array[rightIndex]) >= 0) {
			Util.swap(array, j, rightIndex);
			return j;
		} else {
			Util.swap(array, j + 1, rightIndex);
			return j + 1;
		}
	}

	private int halfSelectionSort(T[] array, int leftIndex, int rightIndex) {
		int middle = (rightIndex - leftIndex) / 2;
		for (int i = leftIndex; i <= middle; i++) {
			int min = i;
			for (int j = i; j <= rightIndex; j++) {
				if (array[min].compareTo(array[j]) > 0) {
					min = j;
				}
			}
			Util.swap(array, i, min);
		}
		return middle;
	}

	public static void main(String[] args) {
		QuickSortComMediana<Integer> quick = new QuickSortComMediana<>();
		// Integer[] arr = {3,4,5,1};
		Integer[] arr2 = { 2, 3, 4, 7, -1, 8, 9, -10 };
		System.out.println(Arrays.toString(arr2));
		quick.sort(arr2, 0, arr2.length - 1);
		System.out.println(Arrays.toString(arr2));
	}

}
package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */

public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {
			combSort(array, leftIndex, rightIndex);
		}
	}

	private void combSort(T[] array, int leftIndex, int rightIndex) {
		double fator = 1.25;
		int gap = rightIndex - leftIndex + 1; // Tamanho

		while (!isSorted(array, leftIndex, rightIndex)) {
			if (gap > 1) {
				gap = (int) (gap / fator);
			}

			for (int i = leftIndex; i + gap <= rightIndex; i++) {
				if (array[i].compareTo(array[i + gap]) > 0) {
					Util.swap(array, i, i + gap);
				}
			}
		}
	}

	private boolean isSorted(T[] array, int leftIndex, int rightIndex) {
		boolean retorno = true;

		int i = leftIndex + 1;
		while (retorno && i <= rightIndex) {
			if (array[i - 1].compareTo(array[i]) > 0) {
				retorno = false;
			}
			i++;
		}
		return retorno;
	}

}

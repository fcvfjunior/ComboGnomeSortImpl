package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex) {
			gnomeSort(array, leftIndex, rightIndex);
		}
	}

	private void gnomeSort(T[] array, int leftIndex, int rightIndex) {
		int pivot = leftIndex;

		while (pivot < rightIndex) {
			T next = array[pivot + 1];

			if (array[pivot].compareTo(next) <= 0) {
				pivot += 1;
			}

			else {
				Util.swap(array, pivot, pivot + 1);
				if (pivot > leftIndex)
					pivot -= 1;
			}
		}
	}
}

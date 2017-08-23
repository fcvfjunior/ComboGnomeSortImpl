
package sorting.variationsOfBubblesort;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> /*implements OrderStatistics<T>*/ {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a
	 * estrategia de usar o selection sem modificar o array original. Note que
	 * seu algoritmo vai apenas selectionar a estatistica deordem e nao ordenar
	 * o array original.
	 * 
	 * Restricoes: - Preservar o array original, ou seja, nenhuma modificacao
	 * pode ser feita no array original - Nenhum array auxiliar deve ser criado
	 * e utilizado. - Caso a estatistica de ordem nao exista no array, o
	 * algoritmo deve retornar null. - Considerar que k varia de 1 a N -
	 * Sugestao: o uso de recursao ajudara sua codificacao.
	 */

	private T getSmallestElement(T[] array) {
		T smallestElement = array[0];

		for (int i = 1; i < array.length; ++i) {
			if (smallestElement.compareTo(array[i]) > 0) {
				smallestElement = array[i];
			}
		}

		return smallestElement;
	}

	private T getGreatestElement(T[] array) {
		T greatestElement = array[0];

		for (int i = 1; i < array.length; ++i) {
			if (greatestElement.compareTo(array[i]) < 0) {
				greatestElement = array[i];
			}
		}

		return greatestElement;
	}

	private T modifyedSelectionStep(T[] array, T previous) {
		T smallest = getGreatestElement(array);

		for (int i = 0; i < array.length; ++i) {
			if (array[i].compareTo(previous) > 0 && array[i].compareTo(smallest) < 0) {
				smallest = array[i];
			}
		}

		return smallest;
	}

	private T getKthElement(T[] array, T previous, int step) {
		if (step == 1) {
			return previous;
		} else {
			T currentSmallest = modifyedSelectionStep(array, previous);
			return getKthElement(array, currentSmallest, step - 1);
		}
	}

	//@Override
	public T getOrderStatistics(T[] array, int k) {
		T kthElement = null;

		if (array != null && k > 0 && k <= array.length) {
			T smallestElement = getSmallestElement(array);
			kthElement = getKthElement(array, smallestElement, k);
		}

		return kthElement;
	}
}

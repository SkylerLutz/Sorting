public class Insertionsort {

	public static <T extends Comparable<? super T>> void insertionSort(T[] array) {

		T temp;
		int j;

		for (int i = 1; i < array.length; i++ ){

			temp = array[i];

			for (j = i; j > 0; j--) {
				
				if (array[j-1].compareTo(temp) > 0) {

					array[j] = array[j-1];
				}
				else {

					break;
				}
			}

			array[j] = temp;
		}
	}
}

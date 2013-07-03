import java.util.Arrays;

public class Mergesort {
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
		
		if (array.length > 1) { 

			T[] left = Arrays.copyOfRange(array, 0, array.length / 2);
			mergeSort(left);

			T[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
			mergeSort(right);

			T[] temp = merge(left, right);
			System.arraycopy(temp, 0, array, 0, temp.length);
		}
	}

	private static <T extends Comparable<? super T>> T[] merge(T[] left, T[] right) {

		T[] merged = Arrays.copyOfRange(left, 0, left.length + right.length);

		int l = 0, r = 0, m = 0;

		while(l < left.length && r < right.length) {
	
			if (left[l].compareTo(right[r]) < 0) {

				merged[m++] = left[l++];
			}
			else {

				merged[m++] = right[r++];
			}
		}

		while (l < left.length) {

			merged[m++] = left[l++];
		}

		while (r < right.length) {
	
			merged[m++] = right[r++];
		}

		return merged;
	}
}

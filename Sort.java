import java.util.Arrays;

public class Sort {
	
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


	public static <T extends Comparable<? super T>> void heapSort(T[] array){
		
		for (int i = array.length; i >= 0; i--){
			
			heapify(array, i, array.length);
		}
		for (int i = array.length - 1; i > 0; i--){
			
			T o = array[0];
			array[0] = array[i];
			array[i] = o;
			heapify(array, 0, i);
		}
	}
	private static <T extends Comparable<? super T>> void heapify(T[] array, int parent, int endIndex){
		
        	int left = parent * 2 + 1;
		int right = parent * 2 + 2;
		int big = 0;
        
		if(left < endIndex){
			
			if(right < endIndex){
				
				big = (array[left].compareTo(array[right]) < 0) ? right : left;
			}
			else{
                
				big = left;
			}

			if(array[big].compareTo(array[parent]) > 0){
				
                		T o = array[parent];
				array[parent] = array[big];
				array[big] = o;

				heapify(array, big, endIndex);
			}
		}
	}
	public static <T extends Comparable<? super T>> void quickSort(T[] array) {

		qSort(array, 0, array.length - 1);
	}
	private static <T extends Comparable<? super T>> void qSort(T[] array, int left, int right) {

		int l = left;
		int r = right;
		int pivot = r;

		if (left < right) {

			while(l < r) {

				while(l < r && array[l].compareTo(array[pivot]) <= 0){
					l++;
				}
				
				while(l < r && array[pivot].compareTo(array[r]) <= 0){
					r--;
				}

				if(l < r) {

					T temp = array[l];
					array[l] = array[r];
					array[r] = temp;
				}
			}

			if(r != pivot) {

				T temp = array[r];
				array[r] = array[pivot];
				array[pivot] = temp;
			}
			qSort(array, left, r-1);
			qSort(array, r+1, right);
		}
	}
}

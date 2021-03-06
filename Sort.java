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
	public static <T extends Comparable<? super T>> void selectionSort(T[] array) {

		
		for(int i=0; i < array.length-1; i++) {
			
			int min = i;
			for(int j=i+1; j < array.length; j++) {

				if(array[j].compareTo(array[min]) < 0){
					min = j;
				}
				T temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}
	public static <T extends Comparable<? super T>> void mergeSortInPlace(T[] array){
	
		mergeSort(array, 0, array.length);		
	}
	private static <T extends Comparable<? super T>> void mergeSort(T[] array, int left, int right){

		if(left < right) {

			int rl = right / 2;
			int ll = 0;
			mergeSort(array, ll, rl);

			int rr = right - left;
			int lr = (right / 2)+1;
			mergeSort(array, lr, rr);

			merge(array, ll, rl, lr, rr);
		}
	}
	private static <T extends Comparable<? super T>> void merge(T[] array, int lefto, int righto, int lefte, int righte){

		T temp;
		int j;
		for (int i = lefto; i < righte; i++ ){

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
	
	public static <T extends Comparable<? super T>> void shellsort(T[] array){

		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
		T temp;
		int j;
		for(int gap : gaps) {

			if(gap < array.length) {

				for(int i=0; i < array.length; i++) {
					
					temp = array[i];
					for(j=i; (j > 0) && (j-gap >= 0); j-=gap) {

						if(temp.compareTo(array[j-1]) < 0) {
							array[j] = array[j-gap];
						}
						else  {
							break;
						}
					}
					if(j >= 0) {
						array[j] = temp;
					}
				}
			}
			
		}	
	}
	public static <T extends Comparable<? super T>> void combsort(T[] array){

		float shrink = 1.3f;
		int gap = (int)((float)array.length / shrink);
		
		for(int i=0; i < array.length && gap >= 1; i++) {

			for(int j=0; j+gap < array.length; j++) {

				if(array[j+gap].compareTo(array[j]) < 0 ){
					T temp = array[j];
					array[j] = array[j+gap];
					array[j+gap] = temp;
				}
			}
			gap = (int)((float)gap/shrink);
		}
	}
	public static <T extends Comparable<? super T>> void bogosort(T[] array){

		java.util.Random r = new java.util.Random();
		boolean sorted = false;
		while(!sorted) {

			sorted = true;
			for(int i=0; i < array.length-1; i++) {
				if(array[i].compareTo(array[i+1]) > 0) {
					sorted=false;
				}
			}
			if(!sorted) {
				for(int i=0; i < array.length; i++) {
		
					int n = r.nextInt(array.length);	
					T temp = array[i];
					array[i] = array[n];
					array[n] = temp;
				}
			}
		}
	}
}

import java.util.Random;

public class Heapsort {

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
}

import java.util.Scanner;
import java.util.Arrays;

public class ENSF694Lab2 {
	
	  public static int linearSearch(int[] array, int key) {
		  	for (int i = 0; i < array.length; i++) {
		  		if (array[i] == key)
		  			return i;
	  	} return -1;
  }
	  
	  public static int interpolationSearch(int array[], int key) {
		   
		  int low = 0;
		  int high = array.length -1;
		  
		  while (low <=high && key>= array[low] && key <= array[high]) {
			  int pos = (key - array[low])/(array[high]-array[low]);
			  int mid = low+((high-low)*pos);  
			  
			  if (array[mid] == key) {
				  return mid;
			  }
			  
			  if (array[mid] < key) {
				  low = mid + 1;
			  } else {
				  high = mid - 1;
			  }
		  }
		  return -1;
	  }
	  
	  public static int fasterLinearSearch(int[] array, int key) {
		  
		  	for (int i = 0; i < array.length; i++) {
		  		if (array[i] == key)
		  			return i;
	  	} return -1;
}
	
	public static void main(String[] args) {
	
	  Scanner scanner = new Scanner(System.in);
	  
	  System.out.println("Enter the number of elements in the array: ");
	  
	  int numberElements = Integer.valueOf(scanner.nextLine());
	  
	  int[] array = new int[numberElements];
	  
	  System.out.println("Enter the elements in the array: ");
	  for (int i = 0; i < array.length; i++) {
		  array[i] = Integer.valueOf(scanner.nextLine());
		  }
	  
	  System.out.println("Enter search key: ");
	  
	  Arrays.sort(array);
	  
	  int Key = Integer.valueOf(scanner.nextLine());
	  
      long linearStartTime = System.nanoTime();
	  int linearResult = linearSearch(array, Key);
	  long linearEndTime = System.nanoTime();
      long linearExecutionTime = linearEndTime - linearStartTime;

	  
	  if (linearResult != -1) {
		  System.out.println("Using Linear Search: ");
		  System.out.println("Search key FOUND at index " + linearResult + ".");
	  } else {
		  System.out.println("Search key NOT FOUND");
	  } System.out.println("Linear Search Execution Time: " + linearExecutionTime + " nanoseconds");
	  
      long interpolationStartTime = System.nanoTime();
	  int interpolationResult = interpolationSearch(array, Key);
      long interpolationEndTime = System.nanoTime();
      long interpolationExecutionTime = interpolationEndTime - interpolationStartTime;
	  
	  if (interpolationResult != -1) {
		  System.out.println("Using Interpolation Search: ");
		  System.out.println("Search key FOUND at index " + interpolationResult + ".");
	  } else {
		  System.out.println("Search key NOT FOUND");	  
	  } System.out.println("Interpolation Search Execution Time: " + interpolationExecutionTime + " nanoseconds");
	  
	  long linearFastStartTime = System.nanoTime();
	  int linearFastResult = fasterLinearSearch(array, Key);
	  long linearFastEndTime = System.nanoTime();
      long linearFastExecutionTime = linearFastEndTime - linearFastStartTime;
      
      if (linearFastResult != -1) {
		  System.out.println("Using Linear Search with initial sort: ");
		  System.out.println("Search key FOUND at index " + linearFastResult + ".");
	  } else {
		  System.out.println("Search key NOT FOUND");
	  } System.out.println("Linear Search Execution Time: " + linearFastExecutionTime + " nanoseconds");    
	}
}
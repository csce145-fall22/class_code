
public class SelectionSort {
	
	public static int[] selectionSortNotInPlace(int[] a) {
		int[] b  = a.clone();
		selectionSort(b);
		return b;
	}
	
	public static void selectionSort(int[] a) {
	
		for(int i = 0; i< a.length -1 ; ++i) {
			int curr_min = i; //current minimum index
			for(int j=i+1; j<a.length; ++j) {
				if(a[j]<a[curr_min]) 
					curr_min = j;
			}
			int temp = a[i];
			a[i] = a[curr_min];
			a[curr_min]= temp;
		}
	}

	public static void printArr(int[] a){
		System.out.print('{');
		for(int i = 0; i< a.length ; ++i) {
			if(i<a.length-1) {
				System.out.print(a[i]+", ");
			}
			else {
				System.out.print(a[i]);
			}
		}
		System.out.print('}');
	}
	
	public static void main(String[] args) {
		int[] a = new int[args.length];
		
		for(int i =0; i<args.length; ++i) {
			a[i] = Integer.parseInt(args[i]);
		}
		
		System.out.println("Testing not in place code");
		System.out.println("Original array =");
		printArr(a);
		System.out.println("\n Sorted array =");
		int[] x = selectionSortNotInPlace(a);
		printArr(x);
		System.out.println("\nOriginal array =");
		printArr(a);
		
		System.out.println("\n\nOriginal array =");
		printArr(a);
		System.out.println("\nOriginal array, now sorted =");
		selectionSort(a);
		printArr(a);
		
		
		
	}

}

import java.io.*;



public class InsertionSort {
	
	public static int[] sortArray(int[] A, int size) {
		System.out.println("Starting My Sort\n");
		int key, i;
		for(int j=0; j<size; j++) {
			key = A[j];
			i = j-1;
			while(i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i--;
			}
				
			A[i+1] = key;
		}
		//[34, 12, 18, 3, 84, 23, 56, 9]
		
		return A;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(inputStreamReader);
		System.out.println("How many Integers in your Array?");
		int n = Integer.parseInt(in.readLine());
		System.out.println("You Entered: "+n);
		int[] intArray = new int[n];
		System.out.println("Please enter in your elements:\n");
		for(int i=0; i<n; i++) {
			intArray[i] = Integer.parseInt(in.readLine());
		}
		System.out.print("You entered: \n[");
		for(int i=0; i<n-1; i++) {
			System.out.print(intArray[i]+", ");
		}
		System.out.print(intArray[n-1]+"]\n");
		int[] sortedArray = sortArray(intArray, n);
		
		System.out.print("Sorted Array is as Follows: \n[");
		for(int i=0; i<n-1; i++) {
			System.out.print(sortedArray[i]+", ");
		}
		System.out.print(sortedArray[n-1]+"]");
		
	}

}

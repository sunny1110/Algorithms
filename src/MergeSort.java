import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
	static int[] intArray = new int[8];
	static int p =0, r = 0;
	
	
	public static void mergeS(int A[], int p, int r) {
		
		if(p<r) {
			int q = (p+r)/2;
			mergeS(A, p, q);
			mergeS(A, q+1, r);
			merge(A, p, q, r);
		}
		
	}
	
	public static void merge(int A[], int p, int q, int r) {
		int i =0, j=0;
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		for(i=0; i<n1; i++) {
			L[i] = A[p+i];
		}
		L[n1] = -1;
		
		for(j=0;j<n2; j++) {
			R[j] = A[q+1+j];
		}
		R[n2] = -1;
		i=0; j=0;
		for(int k=p; k<=r; k++) {
			if(L[i]==-1 || R[j]==-1) {
				if(L[i]==-1) {
					A[k] = R[j];
					j++;
				}
				else if(R[j]==-1) {
					A[k] = L[i];
					i++;
				}
			}
			else {
				if(L[i]<=R[j]) {
					A[k] = L[i];
					i++;
				}
				else {
					A[k] = R[j];
					j++;
				}
			}
			
			
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(inputStreamReader);
		System.out.println("How many Integers in your Array?");
		int n = Integer.parseInt(in.readLine());
		r = n;
		System.out.println("You Entered: "+n);
		System.out.println("Please enter in your elements:\n");
		for(int i=0; i<n; i++) {
			intArray[i] = Integer.parseInt(in.readLine());
		}
		System.out.print("You entered: \n[");
		for(int i=0; i<n-1; i++) {
			System.out.print(intArray[i]+", ");
		}
		System.out.print(intArray[n-1]+"]\n");
		
		
		
		mergeS(intArray, p, r-1);
		
		
		// This displays the sorted Array, IDEALLY.
		System.out.print("Sorted Array is as Follows: \n[");
		for(int i=0; i<n-1; i++) {
			System.out.print(intArray[i]+", ");
		}
		System.out.print(intArray[n-1]+"]");
		
	}//8: [34, 12, 18, 3, 84, 23, 56, 9]
	//Expected: [3, 9, 12, 18, 23, 34, 56, 84]
}

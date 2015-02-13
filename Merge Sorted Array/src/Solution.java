
public class Solution {
	public static void merge(int A[], int m, int B[], int n) {
        int ptrA = 0, ptrB = 0;
        int count = 0;
        
        for (; ptrB < n; ptrB++ ) {
        	if (A[ptrA] < B[ptrB]) {
				ptrA++;
			}
        	
        	if (A[ptrA] >= B[ptrB]) {
				for (int i = m + (count++); i > ptrA ; i--) {
					A[i] = A[i-1]; 
					
				}
				A[ptrA] = B[ptrB];
				ptrA++;
			}
        }
        
        for (int i : A) {
			System.out.println(i);
		}
    }
	
	public static void main(String[] args) {
		int[] A = new int[10];
	/*	for (int i = 0; i < 5; i++) {
			A[i] = 2 * i + 1;
		}*/
		A[0] = 1;
		A[1] = 6;
/*		A[2] = 1;
		A[3] = 1;
		A[4] = 1;*/
		
		int[] B = {4, 5};
		int m = 2, n = 2;
		merge(A, m, B, n);
		
		
	}
}

package leetsort;

public class LeetSort {

	public int partition(int[]A ,int p,int r){
		int x=A[r];
		int i=p-1;
		int t;
		for(int j=p;j<r-1;j++){
			if (A[j]<=x) {
				i=i+1;
				t=A[i];
				A[i]=A[j];
				A[j]=t;
			}
			t=A[i+1];
			A[i+1]=A[r];
			A[r]=t;
		}
		return i;
	}
	
	public void quickSort(int[] A,int p,int r) {
		if (p<r) {
			int q=partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}
	
	public static void main(String[] args) {
		LeetSort leetSort=new LeetSort();
		int[] A=new int[]{1,3,4,2,6,7,5};
		int p=2,r=2;
		leetSort.quickSort(A, p, 3);
		for (int i : A) {
			System.out.print(i);
		}
		
	}
}

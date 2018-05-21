package leetsort;

import javax.security.auth.kerberos.KerberosKey;

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
	
	public void quickSort(int[] data,int p,int r){
		
		if (p<r) {
			int low=p-1;
			int high,index;
			for(high=p;high<r;high++){
				if (data[high]<data[r]) {
					low++;
					swap(data, low, high);
				}
			}
			
			index=low+1 ;
			swap(data, index, r);
			quickSort(data, p, index-1);
			quickSort(data, index+1, r);
		}
	}
	

	public void mergesort(int[] data,int p,int r){
		if (p<r) {
			int q=(p+r)/2;
			mergesort(data, p, q);
			mergesort(data, q+1, r);
			merge(data, p, q, r);
		}
		
	}


	public int search(int[] data,int val){
		int n=data.length-1;
		int mid;
		int low=0,high=n;
		while (low<high) {
			mid=(low+high)/2;
			if (data[mid]==val) {
				return mid;
			}
			if (data[mid]>val) {
				high=mid;
			}else {
				low=mid;
			}
		}
		
		return -1;
	}
	
	
	public int searchReverse(int []data,int val,int low ,int high){
		if (low<high) {
			int mid=(low+high)/2;
			if (data[mid]==val) {
				return mid;
			}
			if (data[mid]>val) {
				return searchReverse(data, val, low, mid);
			}else {
				return searchReverse(data, val, mid, high);
			}
		}
		
		return -1;
	}
	
	
	
	public void merge(int[] data,int p,int q,int r){
		
		int n1=q-p+1;
		int n2=r-q;
		int[] L=new int[n1];
		int[] R=new int[n2];
		for (int i = 0; i < L.length; i++) {
			L[i]=data[p+i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i]=data[q+i+1];
		}
		
		
		for(int i=0,j=0,k=p;k<=r;k++){

			if (i>=n1) {
				while (j<n2) {
					data[k]=R[j];
					k++;
					j++;
				}
				break;
			}
			if (j>=n2) {
				while (i<n1) {
					data[k]=L[i];
					k++;
					i++;
				}
				break;
			}
			if (L[i]<R[j]) {
				data[k]=L[i];
				i++;
			}else {
				data[k]=R[j];
				j++;
			}
		}
		

		
	}

	public void buildHeap(int[] data){
		int size=data.length;
		for (int i = data.length/2-1; i >=0	; i--) {
			heapMaxify(data, i, size);
		}
	}
	
	
	public void heapSort(){
		//int[] data={10,5,4,7,6,8};
		int[] data={4,7,8,5,6,10};
		buildHeap(data);
		for (int i : data) {
			System.out.print(i+" ");
		}
		System.out.println();
		int size=data.length;
		for (int i = data.length-1; i >0; i--) {
			swap(data, 0,i);
			heapMaxify(data, 0, i);
//			for (int j : data) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
		}
		
		for (int i : data) {
			System.out.print(i+" ");
		}
	}
	
	public void heapMaxify(int[] data,int i,int size){
		int l=2*(i+1)-1;
		int r=2*(i+1);
		int largest=i;
		if (l<size&&data[l]>data[i]) {
			largest=l;
		}
		if (r<size&&data[r]>data[largest]) {
			largest=r;
		}
		if (largest!=i) {
			swap(data, largest, i);
			heapMaxify(data, largest, size);
		}
	}
	
	
	public void swap(int[] data,int a,int b){
		int c=data[a];
		data[a]=data[b];
		data[b]=c;
	}
	
	public static void main(String[] args) {
		LeetSort leetSort=new LeetSort();
		int[] A=new int[]{3,6,4,9,7,8};
		int p=2,r=2;
		//leetSort.quickSort(A, 0, A.length-1);
		leetSort.mergesort(A, 0, A.length-1);
		for (int i : A) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("");
		//System.out.println(leetSort.searchReverse(A, 5,0,A.length-1));
		leetSort.heapSort();
		
	}
}

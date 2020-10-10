package finalexam;

import org.omg.CORBA.IdentifierHelper;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 main=new Main3();
		main.exec();
	}
	
	public void exec() {
		int[] data=new int[]{2,1,4,5,3};
//		quickSort(data, 0, data.length-1);
//		bubbleSort(data);
		heapSort(data);
		for (int i : data) {
			System.out.print(i+" ");
		}
	}
	
	public void heapSort(int[] data) {
		buildHeap(data);
		for(int i=data.length-1;i>=0;i--){
			swap(data, 0, i);
			heapMax(data, 0	, i);
		}
	}
	
	public void buildHeap(int[] data) {
		int n=data.length;
		for (int i = n/2; i >=0; i--) {
			heapMax(data, i, data.length);
		}
	}
	
	
	public void heapMax(int[] data,int idx,int size) {
		int l=2*idx+1;
		int r=2*idx+2;
		int largest=idx;
		if (l<size&&data[l]>data[largest]) {
			largest=l;
		}
		if (r<size&&data[r]>data[largest]) {
			largest=r;
		}
		if (largest!=idx) {
			swap(data, largest, idx);
			heapMax(data, largest, size);
		}
		
	}
	
	public void selectSort(int[] data) {
		
	}
	
	public void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length-i; j++) {
				if (data[j]>data[j-1]) {
					swap(data, j, j-1);
				}
			}
		}
	}
	
	public void quickSort(int[] data,int p,int r) {
		if (p<r) {
			int low=p-1;
			int high=p;
			for(;high<r;high++){
				if (data[high]<data[r]) {
					low++;
					swap(data, high, low);
				}
			}
			int index=low+1;
			swap(data, index, r);
			quickSort(data, p, index-1);
			quickSort(data, index+1, r);
		}
	}
	
	public void swap(int[] data,int a,int b) {
		int t=data[a];
		data[a]=data[b];
		data[b]=t;
	}

}

package leetsort2;

import java.util.ArrayList;

import leetTest.Test;

public class LeetSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetSort leetSort = new LeetSort();
		int[] data = { 2, 4, 5, 3, 9, 6, 8 };
		// leetSort.bubbleSort(data);
		// leetSort.selectSort(data);
		//leetSort.insertSort(data);
		//leetSort.quickSort(data, 0, data.length-1);
//		leetSort.mergeSort(data, 0, data.length-1);
//		printArray("归并排序：", data);
		leetSort.heapSort(data);
		System.out.println(leetSort.binarySearch(data, 7));
		System.out.println(leetSort.treeSearch(data, 5));
	}
	
	
	private int treeSearch(int[] data,int val){
		TreeNode root=buildTree(data);
		return treeSearchReal(root, val);
	}
	
	private int treeSearchReal(TreeNode root,int val){
		if (root==null) {
			return -1;
		}
		if (root.val==val) {
			return root.index;
		}else if(root.val>val){
			return treeSearchReal(root.left, val);
		}else {
			return treeSearchReal(root.right, val);
		}
	}
	
	
	private TreeNode buildTree(int[] data){
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			root=insertTree(root, data[i], i);
		}
		return root;
	}
	
	private TreeNode insertTree(TreeNode root,int val,int index){
		if (root==null) {
			root=new TreeNode(val, index);
		}else if(root.val>val){
			root.left=insertTree(root.left, val, index);
		}else {
			root.right=insertTree(root.right, val, index);
		}
		
		return root;
	}

	
	public int binarySearch(int[] data,int goal){
		int i=0,j=data.length-1;
		while (i<=j) {
			int mid=(i+j)/2;
			if (data[mid]==goal) {
				return mid;
			}
			if (data[mid]>goal) {
				j=mid-1;
			}else {
				i=mid+1;
			}
			
		}
		return -1;
	}
	
	public void heapSort(int[] data){
		buildHeap(data);
		for(int i=data.length-1;i>0;i--){
			swap(data, 0, i);
			heapMaxify(data, 0, i);
		}
		printArray("堆排序", data);
	}
	
	
	private void buildHeap(int[] data) {
		for(int i=data.length/2-1;i>=0;i--){
			heapMaxify(data, i, data.length);
		}
	}
	
	
	public void heapMaxify(int[] data,int i,int size){
		int l=2*(i+1)-1;
		int r=2*(i+1);
		int largest=i;
		if (l<size&&data[l]>data[largest]) {
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
	
	
	
	
	
	
	
	
	
	
	
	public void mergeSort(int[] data,int p,int r){
		if (p<r) {
			int q=(p+r)/2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
		
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
		
		for (int i =0,j=0,k=p; k <= r; k++) {
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

	public void quickSort(int[] data,int p,int r){
		if (p<r) {
			int low=p-1;
			int high=p;
			for (; high<r; high++) {
				if (data[high]<data[r]) {
					low++;
					swap(data, low, high);
					
				}
			}
			int index=low+1;
			swap(data, index, r);
			quickSort(data, p, index-1);
			quickSort(data, index+1, r);
		}
		printArray("快速排序", data);
	}
	
	
	public void insertSort(int[] data) {
		for (int i = 1; i < data.length; i++) {

			int t = data[i];
			int j = i - 1;
			while (j >= 0) {
				if (data[j] > t) {
					data[j + 1] = data[j];
				} else {
					break;
				}
				j--;

			}
			j = j + 1;
			data[j] = t;

		}

		printArray("插入排序", data);
	}

	public void selectSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}
			swap(data, i, min);
		}

		printArray("选择排序", data);
	}

	public void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length - i; j++) {
				if (data[j] < data[j - 1]) {
					swap(data, j - 1, j);
				}
			}
		}
		printArray("冒泡排序", data);
	}

	public void swap(int[] data, int a, int b) {
		int t = data[a];
		data[a] = data[b];
		data[b] = t;
	}

	public static void printArray(String info, int[] data) {
		System.out.print(info + ":");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	private class TreeNode{
		public TreeNode left;
		public TreeNode right;
		int val;
		int index;
		
		public TreeNode(int val,int index) {
			// TODO Auto-generated constructor stub
			this.index=index;
			this.val=val;
		}
	}
	
}

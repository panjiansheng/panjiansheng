package ali;

import java.awt.Robot;

public class InternFaceSortSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InternFaceSortSearch internFaceSortSearch = new InternFaceSortSearch();
		int[] data = initData();
		internFaceSortSearch.insertSort(data);
		print(data);
		data=initData();
		internFaceSortSearch.heapSort(data);
		print(data);
		data=initData();
		internFaceSortSearch.quickSort(data,0,data.length-1);
		print(data);
		data=initData();
		internFaceSortSearch.mergeSort(data,0,data.length-1);
		print(data);
		data=initData();
		internFaceSortSearch.selectSort(data);
		print("select",data);
		System.out.println(internFaceSortSearch.binarySearch(data, 7));
		System.out.println(internFaceSortSearch.treeSearch(data, 9));
	}
	
	public int treeSearch(int[] data,int val){
		TreeNode root=buildTree(data);
		return treeSearchHelper(root, val);
	}
	
	public int treeSearchHelper(TreeNode root,int val){
		if (root==null) {
			return -1;
		}else if (root.val==val) {
			return root.index;
		}else if (root.val>val) {
			return treeSearchHelper(root.left, val);
		}else {
			return treeSearchHelper(root.right, val);
		}
	}
	
	private TreeNode buildTree(int[] data){
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			TreeNode node=new TreeNode(data[i], i);
			root=insertTree(root,node);
		}
		return root;
	}
	
	
	
	
	private TreeNode insertTree(TreeNode root,TreeNode node) {
		if(root==null){
			root=node;
		}else if (root.val>node.val) {
			root.left=insertTree(root.left, node);
		}else {
			root.right=insertTree(root.right, node);
		}
		return root;
	}
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		int index;
		
		public TreeNode(int val,int index) {
			// TODO Auto-generated constructor stub
			this.index=index;
			this.val=val;
		}
	}
	
	
	public int binarySearch(int[] data,int val){
		int low=0,mid;
		int high=data.length-1;
		while (low<=high) {
			mid=(low+high)/2;
			if (data[mid]==val) {
				return mid;
			}
			else if (data[mid]<val) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		return -1;
	}
	
	
	public void selectSort(int[] data){
		for (int i = 0; i < data.length; i++) {
			int minIndex=i;
			for (int j = i; j < data.length; j++) {
				if (data[j]<data[minIndex]) {
					minIndex=j;
				}
			}
			swap(data, i, minIndex);
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
	
	private void merge(int[] data,int p,int q,int r){
		int[] L=new int[q-p+2];
		int[] R=new int[r-q+1];
		for (int i = 0; i <q-p+1; i++) {
			L[i]=data[p+i];
		}
		for (int i =0; i <r-q; i++) {
			R[i]=data[q+i+1];
		}
		L[L.length-1]=Integer.MAX_VALUE;
		R[R.length-1]=Integer.MAX_VALUE;
		
		for(int k=p,i=0,j=0;k<=r;k++){
			if(L[i]<R[j]){
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
			for(;high<=r-1;high++){
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
	}
	
	public void heapSort(int[] data){
		buildHeap(data);
		for (int i = data.length-1; i >=0; i--) {
			swap(data, 0, i);
			heapMaxify(data, 0, i);
		}
	}
	
	private void buildHeap(int[] data) {

		for (int i = data.length-1; i>=0; i--) {
			heapMaxify(data, i, data.length);
		}
	}
	
	private void heapMaxify(int[] data,int index,int size){
		int l=2*(index+1)-1;
		int r=2*(index+1);
		int largest=index;
		if (l<size&&data[l]>data[largest]) {
			largest=l;
		}
		if (r<size&&data[r]>data[largest]) {
			largest=r;
		}
		if (largest!=index) {
			swap(data, largest, index);
			heapMaxify(data, largest, size);
		}
	}

	public void insertSort(int[] data) {

		for (int i = 1; i < data.length; i++) {
			int j = i;
			int tmp = data[i];

			while (data[j-1] > tmp && j > 0) {
				data[j] = data[j - 1];
				j--;
			}
			data[j] = tmp;

		}
	}

	public void bubbleSort(int[] data) {
		boolean flag = true;
		for (int i = 0; i < data.length && flag; i++) {
			flag = false;
			for (int j = 1; j < data.length - i; j++) {
				if (data[j] < data[j - 1]) {
					flag = true;
					swap(data, j, j - 1);
				}
			}
		}

	}

	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	public static void print(String msg,int[] data) {
		System.out.print(msg+":");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public void swap(int[] data, int a, int b) {
		int t = data[a];
		data[a] = data[b];
		data[b] = t;
	}

	public static int[] initData() {
		int[] data = new int[] { 1, 3, 5, 7, 4, 2 };
		return data;
	}
}

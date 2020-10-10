package leetTest;

public class SortAndSearch {
	
	
	public void bubbleSort(int[] data){
		int n=data.length;
		int flag=n;
		for (int i = 0; i < n; i++) {
			int k=flag;
			flag=0;
			for (int j = 1; j <k; j++) {
				if (data[j-1]>data[j]) {
					swap(data, j-1, j);
					flag=j;
				}
			}
		}
	}
	
	public void quicksort(int[] data,int p,int r){
		if (p<r) {
			int key=data[r];
			int index,high;
			int low=p-1;
			for (high=p; high<r	; high++) {
				if (data[high]>key) {
					low++;
					swap(data, high, low);
				}
			}
			
			index=low+1;
			swap(data, index, r);
			quicksort(data, p, index-1);
			quicksort(data, index+1, r);
			
		}
		
	}
	
	
	public void heapSort(int[] data){
		int size=data.length-1;
		buildHeap(data);
		for (int i =size ; i >0; i--) {
			swap(data, 0, i);
			heapMaxify(data, 0, i);
		}
	}
	
	public void heapMaxify(int[] data,int i,int size){
		int largest=i;
		int l=2*(i+1)-1;
		int r=2*(i+1);
		if (l<size&&data[l]<data[largest]) {
			
			largest=l;
		}
		if (r<size&&data[r]<data[largest]) {
			largest=r;
		}
		if (largest!=i) {
			swap(data, i, largest);
			heapMaxify(data, largest, size);
		}
		
	}
	
	
	
	public void buildHeap(int[] data){
		int size=data.length;
		for (int i = size/2-1; i>=0; i--) {
			heapMaxify(data, i, size);
		}
	}
	
	public void swap(int[] data,int a,int b){
		int c=data[a];
		data[a]=data[b];
		data[b]=c;
	}
	
	
	
	public int binarySearch(int[] data,int val){
		
		int n=data.length;
		int low=0;
		int high=data.length;
		int mid;
		while (low<high) {
			mid=(low+high)/2;
			if (data[mid]==val) {
				return mid;
			}
			if (data[mid]<val) {
				high=mid;
			}else {
				low=mid;
			}
		}
		return -1;
	}
	
	public void mergeSort(int[] data,int p,int r) {
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
		
		for (int i = 0; i < n1; i++) {
			L[i]=data[p+i];
		}
		for (int i = 0; i < n2; i++) {
			R[i]=data[q+i+1];
		}
		int i,j,k;
		for(i=0,j=0,k=p;k<=r;k++){
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
					i++;
					k++;
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
	
	
	public TreeNode buildTree(TreeNode root,int val,int index){
		
		if (root==null) {
			root=new TreeNode(val, index);
		}
		if (val<root.val) {
			root.left=buildTree(root.left, val, index);
		}
		if (val>root.val) {
			root.right=buildTree(root.right, val, index);
		}
		return root;
	}
	
	
	public int search(TreeNode root,int val){
		if (root==null) {
			return -1;
		}
		if (root.val==val) {
			return root.index;
		}
		if (val<root.val) {
			return search(root.left, val);
		}
		if (val>root.val) {
			return search(root.right, val);
		}
		return -1;
	}
	
	public int TreeSearch(int[] data, int val){
		
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			root=buildTree(root, data[i], i);
		}
		return search(root, val);
	}
	
	
	
	public static void output(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data={3,6,4,9,7,8};
		SortAndSearch sortAndSearch=new SortAndSearch();
		//sortAndSearch.bubbleSort(data);
		//sortAndSearch.quicksort(data, 0, data.length-1);
		//sortAndSearch.heapSort(data);
		//System.out.println(sortAndSearch.binarySearch(data, 11));
		//sortAndSearch.mergeSort(data, 0, data.length-1);
		System.out.println(sortAndSearch.TreeSearch(data, 9));
		output(data);
		
		
	}

	
}

class TreeNode{
	public TreeNode left;
	public TreeNode right;
	public int val;
	public int index;
	public TreeNode(int val, int index) {
		super();
		this.val = val;
		this.index = index;
	}
	@Override
	public String toString() {
		return "TreeNode [left=" + left + ", right=" + right + ", val=" + val + ", index=" + index + "]";
	}
	

	
	
	
}

package prebaidu;

public class SortAndSearch {

	public static void main(String[] args) {
		SortAndSearch main=new SortAndSearch();
		main.exec();
	}
	
	public void exec() {
		int[] data=new int[]{2,8,7,1,3,6,5,4};
//		quickSort(data, 0, data.length-1);
//		insertSort(data);
//		selectSort(data);
//		heapSort(data);
//		mergeSort(data, 0, data.length-1);
//		heapSort(data);
//		output(data);
//		int index=binarySearch(data, 4);
		int index=TreeSearch(data, 2);
		System.out.println(index);
		
	}
	
	
	public int  TreeSearch(int[] data,int val) {
		TreeNode root=buildTree(data);
		return TreeSearchReal(root, val);
//		System.out.println(index);
	}
	
	public int TreeSearchReal(TreeNode root,int  val) {
		if (root==null) {
			return -1;
		}else if (root.val==val) {
			return root.index;
		}else if (root.val>val) {
			return TreeSearchReal(root.left, val);
		}else {
			return TreeSearchReal(root.right, val);
		}
	}
	
	
	public TreeNode buildTree(int[] data) {
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			root=insertTree(root, data[i], i);
		}
		return root;
	}
	
	public TreeNode insertTree(TreeNode root,int val,int index) {
		if (root==null) {
			root=new TreeNode(val, index);
		}else if (root.val>val) {
			root.left=insertTree(root.left, val, index);
		}else {
			root.right=insertTree(root.right, val, index);
		}
		return root;
		
	}
	
	
	public int binarySearch(int[] data,int val) {
		int low=0;
		int high=data.length-1;
		while (low<=high) {
			int mid=low+((high-low)>>1);
			if (data[mid]==val) {
				return mid;
			}else if (data[mid]>val) {
				high=mid-1;
			}else {
				low=mid+1;
			}
			
		}
		return -1;
	}
	
	
	
	public void mergeSort(int[] data,int p,int r){
		if (p<r) {
			int q=(p+r)/2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
	}
	
	
	public void merge(int[] data,int p,int q,int r) {
		int[] L=new int[q-p+2];
		int[] R=new int[r-q+1];
		for (int i = 0; i < L.length-1; i++) {
			L[i]=data[p+i];
		}
		for (int i = 0; i < R.length-1; i++) {
			R[i]=data[q+i+1];
		}
		L[L.length-1]=Integer.MAX_VALUE;
		R[R.length-1]=Integer.MAX_VALUE;
		for(int k=p,i=0,j=0;k<=r;k++){
			if (L[i]>R[j]) {
				data[k]=R[j];
				j++;
			}else {
				data[k]=L[i];
				i++;
			}
		}
		
		
		
	}
	
	public void heapSort(int[] data){
		buildHeap(data);
		for (int i = data.length-1; i >=0; i--) {
			swap(data, 0, i);
			heapMaxfiy(data, 0, i);
		}
		
	}
	
	public void buildHeap(int[] data) {
		for (int i = data.length-1; i >= 0	; i--) {
			heapMaxfiy(data, i, data.length);
		}
	}
	
	
	public void heapMaxfiy(int[] data,int index,int size) {
		int l=2*index;
		int r=2*index+1;
		int max=index;
		if (l<size&&data[l]>data[max]) {
			max=l;
		}
		if (r<size&&data[r]>data[max]) {
			max=r;
		}
		if (index!=max) {
			swap(data, max, index);
			heapMaxfiy(data, max, size);
		}

		
	}
	
	public void selectSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int minIndex=i;
			for(int j=i;j<data.length;j++){
				if (data[minIndex]>data[j]) {
					minIndex=j;
				}
			}
			
			swap(data, i, minIndex);
		}
	}
	
	
	
	
	public void insertSort(int[] data){
		for (int i = 0; i < data.length; i++) {
			int tmp=data[i];
			int j=i-1;
			while (j>=0&&tmp<data[j]) {
				data[j+1]=data[j];
				j--;
			}
			j++;
			data[j]=tmp;
		}
	}
	
	
	public void quickSort(int[] data,int p,int r){
		if (p<r) {
			int low=p-1;
			int high=p;
			for(;high<r;high++){
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
	
	public void output(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
	public void swap(int[] data,int a,int b) {
		int tmp=data[a];
		data[a]=data[b];
		data[b]=tmp;
	}
	
	static class TreeNode{
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

}

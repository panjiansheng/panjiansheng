package leetsort;

public class LeetSort3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data={1,3,8,5,4,2};
		LeetSort3 leetSort3=new LeetSort3();
//		leetSort3.insertSort(data);
//		leetSort3.selectSort(data);
//		leetSort3.quickSort(data, 0, data.length-1);
//		leetSort3.heapsort(data);
		leetSort3.bubbleSort(data);
//		leetSort3.treeSearch(data, 8);
		System.out.println(leetSort3.binarySearch(data, 8));
		printArray(data);
	}
	
	public int binarySearch(int[] data,int val) {
		int low=0;
		int high=data.length-1;
		while (low<=high) {
			int mid=low+(high-low)/2;
			if (data[mid]==val) {
				return mid;
			}else if(data[mid]>val){
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return -1;
	}
	
	
	public void treeSearch(int[] data,int val) {
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			root=insertTree(root, data[i], i);
		}
		System.out.println(TreeSearchReal(root, val));
	}
	
	
	public int TreeSearchReal(TreeNode root,int val) {
		if (root==null) {
			return -1;
		}
		if (root.val==val) {
			return root.index;
		}else if(root.val>val){
			return TreeSearchReal(root.left, val);
		}else {
			return TreeSearchReal(root.right, val);
		}
	}
	
	
	public TreeNode insertTree(TreeNode root,int val,int index){
		if (root==null) {
			return new TreeNode(val,index);
		}
		if (root.val>val) {
			
			root.left= insertTree(root.left, val, index);
		}else {
			root.right=insertTree(root.right, val, index);
		}
		return root;
	}
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		int index;
		public TreeNode() {
			// TODO Auto-generated constructor stub
		}
		public TreeNode(int val, int index) {
			super();
			this.val = val;
			this.index = index;
		}
		
		
	}
	
	public void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 1 ; j < data.length-i; j++) {
				if (data[j]<data[j-1]) {
					swap(data, j, j-1);
				}
			}
		}
	}
	
	
	public void heapsort(int[] data){
		buildHead(data);
		for (int i = data.length-1; i >=0; i--) {
			swap(data, 0, i);
			heapMaxify(data, 0, i);
		}
	}
	
	public void buildHead(int[] data) {
		for (int i = data.length-1; i >=0; i--) {
			heapMaxify(data, i, data.length-1);
		}
		
	}
	
	
	public void heapMaxify(int[] data,int index,int size) {
		int l=2*(index+1)-1;
		int r=2*(index+1);
		int max=index;
		if (l<size&&data[l]>data[max]) {
			max=l;
		}
		if (r<size&&data[r]>data[max]) {
			max=r;
		}
		if (max!=index) {
			swap(data, index, max);
			heapMaxify(data, max, size);
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
	
	public void merge(int[] data,int p,int q,int r) {
		int n1=q-p+1;
		int n2=r-q;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		for (int i = 0; i < L.length; i++) {
			L[i]=data[p+i];
		}
		for (int i = 0; i < R.length; i++) {
			R[i]=data[q+i+1];
		}
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {// 一共是r-p+1个数
			if (L[i] < R[j]) {
				data[k] = L[i];
				i++;
			} else {
				data[k] = R[j];
				j++;
			}
		}
			
	}
	
	public void quickSort(int[] data,int p,int r) {
		if (p<r) {
			int low=p-1;
			int high=p;
			for (; high < r; high++) {
				if (data[high]<data[r]) {
					low++;
					swap(data, low, high);
				}
			}

			int index=low+1;
			swap(data, r, index);
			quickSort(data, p, index-1);
			quickSort(data, index+1, r);
		}
	}
	
	
	public void selectSort(int[] data){
		for (int i = 0; i < data.length; i++) {
			int minIndex=i;
			for (int j = i+1; j < data.length; j++) {
				if (data[j]<data[minIndex]) {
					minIndex=j;
				}
			}
			if (minIndex!=i) {
				swap(data, minIndex, i);
			}
		}
	}
	
	public void swap(int[] data,int a,int b) {
		int tmp=data[a];
		data[a]=data[b];
		data[b]=tmp;
	}
	
	public void insertSort(int[] data){
		for (int i = 1; i < data.length; i++) {
			if (data[i]<data[i-1]) {
				int tmp=data[i];
				int j=i;
				while(data[j-1]>tmp){
					data[j]=data[j-1];
					j--;
				}
				data[j]=tmp;
			}
		}
	}
	
	public static void	 printArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

}

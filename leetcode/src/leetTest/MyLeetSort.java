package leetTest;

import java.util.Iterator;
import java.util.Stack;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.SystemException;

import leetcode.Leetcode.ListNode;

public class MyLeetSort {

	int deepth = 0;
	int maxDepth = 0;

	public static void main(String[] args) {
		int[] data = { 2, 7, 43, 6, 98, 44, 21 };
		MyLeetSort myLeetSort = new MyLeetSort();
		// myLeetSort.quickSort(data, 0, data.length-1);
		// myLeetSort.bubbleSort(data);
		// myLeetSort.mergeSort(data, 0, data.length - 1);
		// myLeetSort.heapSort(data);
		printData(data);
		// System.out.println(myLeetSort.binarySearch(data, 44));
//		System.out.println(myLeetSort.treeSearch(data, 43));
//		TreeNode root = myLeetSort.buildTree(data);
//		myLeetSort.PreTreeTraversal(root);
//		System.out.println();
//		myLeetSort.MidTreeTraversal(root);
//		System.out.println();
//		myLeetSort.PostTreeTraversal(root);
//		System.out.println();
//		System.out.println(myLeetSort.maxDepth);
//		myLeetSort.preTreeTrversalLoop(root);
		
		myLeetSort.quickQSort(data, 0, data.length-1);
		// myLeetSort.insertSort(data);
		//System.out.println();
		//printData(data);
		// myLeetSort.selectSort(data);
		//myLeetSort.insertSort(data);
		System.out.println();
		printData(data);

	}

	public void bubbleSort(int[] data) {
		int n = data.length;
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length - i; j++) {
				if (data[j] < data[j - 1]) {
					swap(data, j, j - 1);
				}
			}
		}
	}
	

	// public void insertSort(int[] data){
	// int n=data.length;
	// for (int i = 0; i < data.length; i++) {
	// for (int j = i; j < data.length; j++) {
	//
	// }
	// }
	// }

	
	
	public void selectSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int index = i;
			for (int j = i; j < data.length; j++) {
				if (data[j] < data[index]) {
					index = j;
				}
			}
			swap(data, i, index);
		}
	}

	public void insertSort(int[] data) {
		int n = data.length;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < i; j++) {
				if (data[j] > data[i]) {
					int t = data[i];
					for (int k = i - 1; k >= j; k--) {
						data[k + 1] = data[k];
					}
					data[j] = t;
				}
			}
		}
	}

	
	public void partion(int[] data,int p,int r){
		int low=p-1;
		int high,index;
		for(high=p;high<r;high++){
			if (data[high]<data[r]) {
				
			}
		}
	}
	
	public void sortList(ListNode pHead) {
		ListNode pAhead = pHead;
		ListNode pNode = null;
		ListNode preAhead = null;
		ListNode preBehind = null;
		while (pAhead.next != null) {
			preAhead = pAhead;
			pAhead = pAhead.next;
			pNode = pHead;
			while (pNode.next != pAhead) {
				preBehind = pNode;
				pNode = pNode.next;
				if (pNode.val < pAhead.val) {
					preAhead.next = pAhead.next;
					pAhead.next = preBehind.next;
					preBehind.next = pAhead;
				}
			}
		}
	}

	public void PostTreeTraversal(TreeNode root) {

		if (root == null) {
			return;
		}

		deepth++;
		if (deepth > maxDepth) {
			maxDepth = deepth;
		}
		PostTreeTraversal(root.left);

		PostTreeTraversal(root.right);
		deepth--;
		System.out.print(root.val + " ");
	}

	
	public void quickQSort(int[] data,int p,int r){
		if (p<r) {
			int key=data[r];
			int low=p-1;
			int high,index;
			for (high=p;  high<r ; high++) {
				if (data[high]<key) {
					low++;
					swap(data, low, high);
				}
			}
			index=low+1;
			swap(data, index, r);
			quickQSort(data, p, index-1);
			quickQSort(data, index+1, r);
		}
	}
	
	
	public void preTreeTrversalLoop(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while (true) {
			if (p == null && !stack.isEmpty()) {
				p = stack.pop();
				// System.out.print(p.val+" ");
				p = p.right;
				continue;
			}
			if (p == null) {
				break;
			}

			System.out.print(p.val + " ");
			stack.push(p);
			p = p.left;

		}

		// preTraversalLoop(root);

	}

	public static Stack<TreeNode> preTvsLoopStack = new Stack<>();

	public static void preTraversalLoop(TreeNode root) {
		TreeNode p = root;
		while (true) {

			while (p == null && !preTvsLoopStack.isEmpty()) {
				p = preTvsLoopStack.pop().right;
			}
			if (p == null) {
				break;
			}

			System.out.print(p.val + " ");
			preTvsLoopStack.push(p);
			p = p.left;
		}
	}

	public void MidTreeTraversal(TreeNode root) {

		if (root == null) {
			return;
		}

		MidTreeTraversal(root.left);
		System.out.print(root.val + " ");
		MidTreeTraversal(root.right);
	}

	public void PreTreeTraversal(TreeNode root) {

		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		PreTreeTraversal(root.left);
		PreTreeTraversal(root.right);
	}

	public int treeSearch(int[] data, int val) {
		TreeNode root = null;
		int n = data.length;
		for (int i = 0; i < data.length; i++) {
			root = insertTree(root, data[i], i);
		}
		return treeSearch(root, val);

	}

	public TreeNode buildTree(int[] data) {
		TreeNode root = null;
		int n = data.length;
		for (int i = 0; i < data.length; i++) {
			root = insertTree(root, data[i], i);
		}
		return root;
	}

	public TreeNode insertTree(TreeNode root, int val, int index) {
		if (root == null) {
			root = new TreeNode(val, index);

		} else if (root.val > val) {
			root.left = insertTree(root.left, val, index);
		} else {
			root.right = insertTree(root.right, val, index);
		}
		return root;
	}

	public int treeSearch(TreeNode root, int val) {
		if (root == null) {
			return -1;
		}
		if (root.val == val) {
			return root.index;
		} else if (root.val > val) {
			return treeSearch(root.left, val);
		} else {
			return treeSearch(root.right, val);
		}
	}

	public void heapSort(int[] data) {
		int n = data.length;
		bulidHeap(data);
		for (int i = n - 1; i > 0; i--) {
			swap(data, 0, i);
			heapMaxfiy(data, 0, i);
		}
	}

	public void bulidHeap(int[] data) {
		int n = data.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapMaxfiy(data, i, n);
		}
	}

	public void heapMaxfiy(int[] data, int index, int size) {
		int l = 2 * (index + 1) - 1;
		int r = 2 * (index + 1);
		int largest = index;
		if (l < size && data[l] > data[largest]) {
			largest = l;
		}
		if (r < size && data[r] > data[largest]) {

			largest = r;
		}
		if (largest != index) {
			swap(data, largest, index);
			heapMaxfiy(data, largest, size);
		}

	}

	public int binarySearch(int[] data, int val) {
		int n = data.length;
		int mid, p = 0, r = n - 1;
		while (p < r) {
			mid = (p + r) / 2;
			if (data[mid] == val) {
				return mid;
			}
			if (data[mid] > val) {
				r = mid;

			} else {
				p = mid;
			}

		}
		return -1;
	}

	// 不要漏merge,R数组从q开始，注意i和j
	public void mergeSort(int[] data, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(data, p, q);
			mergeSort(data, q + 1, r);
			merge(data, p, q, r);
		}
	}

	public void merge(int[] data, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = data[p + i];
		}

		for (int i = 0; i < n2; i++) {
			R[i] = data[q + i + 1];
		}

		int i = 0, j = 0;
		for (int k = p; k <= r; k++) {
			if (i >= n1) {
				while (j < n2) {
					data[k] = R[j];
					k++;
					j++;
				}
				break;
			}

			if (j >= n2) {
				while (i < n1) {
					data[k] = L[i];
					k++;
					i++;
				}
				break;
			}

			if (L[i] < R[j]) {
				data[k] = L[i];
				i++;
			} else {
				data[k] = R[j];
				j++;
			}
		}

	}

	public void quickSort(int[] data, int p, int r) {

		if (p < r) {
			int low = p - 1;
			int high, index;

			for (high = p; high < r; high++) {
				if (data[high] > data[r]) {
					low++;
					swap(data, high, low);
				}
			}

			index = low + 1;
			swap(data, index, r);
			quickSort(data, p, index - 1);
			quickSort(data, index + 1, r);
		}
	}

	public void swap(int[] data, int a, int b) {
		int c = data[a];
		data[a] = data[b];
		data[b] = c;
	}

	public static void printData(int[] data) {
		for (int i : data) {
			System.out.print(i + " ");

		}
		System.out.println();
	}

	static class TreeNode {
		public int val;
		public int index;
		public TreeNode left;
		public TreeNode right;

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public TreeNode(int val, int index) {
			super();
			this.index = index;
			this.val = val;
		}
	}

}

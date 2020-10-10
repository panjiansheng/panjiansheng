package array;

import java.util.ArrayList;

public class LeetArray {

	public int firstMissingPositive(int[] nums) {
		// int min=Integer.MAX_VALUE;
		// int max=0;
		// int count=0;
		// int tmp=0;
		// int sum=0;
		// for (int num : nums) {
		// if (num>0) {
		// count++;
		// tmp+=num;
		// min=num<min?num:min;
		// max=num>max?num:max;
		// }
		//
		// }
		// for(int i=min;i<=max;i++){
		// sum=sum+i;
		// }
		// int diff=sum-tmp;
		// return sum-tmp;
		if (nums == null) {
			return 1;
		}
		if (nums.length == 1) {
			if (nums[0] == 1) {
				return 2;
			} else {
				return 1;
			}
		}
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int count = 0;
		for (int num : nums) {
			if (num > 0) {
				count++;
				if (num < min1) {
					if (min2 - min1 > 1) {
						min2 = min1;
					}
					min1 = num;
				}
			}

		}
		if (min1 == Integer.MAX_VALUE && min2 == Integer.MAX_VALUE) {
			return 1;
		}
		if (nums.length == 1) {
			if (min1 == 1) {
				return 2;
			} else {
				return min1 - 1;
			}
		}
		if (min2 == Integer.MAX_VALUE && count == 1) {
			if (min1 == 1) {
				return 2;
			} else {
				return min1 - 1;
			}
		}
		if (min2 == Integer.MAX_VALUE) {
			if (min1 == 1) {

			}
		}

		return min2 == Integer.MAX_VALUE ? min1 + 2 : min1 + 1;

	}

	public void quickSork(int[] array, int p, int r) {
		if (p < r) {
			int key = array[r];
			int low = p - 1;
			int high, index;
			for (high = p; high < r; high++) {
				if (array[high] < key) {
					low++;
					swap(array, low, high);
				}
			}
			index = low + 1;
			swap(array, index, r);
			quickSork(array, p, index - 1);
			quickSork(array, index + 1, r);

		}
	}

	public void radixSort(int[] array, int index) {

		for (int z = 0; z < index; z++) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < i; j++) {
					if (array[j] / (int) Math.pow(10, z) % 10 > array[i] / (int) Math.pow(10, z) % 10) {
						int t = array[i];
						for (int k = i - 1; k >= j; k--) {
							array[k + 1] = array[k];
						}
						array[j] = t;
					}
				}
			}

		}

	}

	public void insertSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[i]) {
					int t = array[i];
					for (int k = i - 1; k >= j; k--) {
						array[k + 1] = array[k];
					}
					array[j] = t;
				}
			}
		}
	}

//	public void selectSort(int[] array) {
//
//		for (int i = 0; i < array.length; i++) {
//			int min = array[i];
//			int index;
//			for (int j = i; j < array.length; j++) {
//				if (array[j] < min) {
//					min = array[j];
//					index = j;
//					swap(array, i, index);
//				}
//			}
//		}
//	}
	
	public void selectSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int index=i;
			for (int j = i; j < data.length; j++) {
				if (data[j] < data[index]) {
					index = j;
				}
			}
			swap(data, i, index);
		}
	}

	public void quickSort(int[] array, int p, int r) {
		if (p < r) {
			int key = array[r];
			int low = p - 1;
			int high, index;
			for (high = p; high < r - 1; high++) {
				if (array[high] < key) {
					low++;
					swap(array, low, high);
				}
			}
			index = low + 1;
			quickSork(array, p, index - 1);
			quickSork(array, index + 1, r);
		}
	}

	public void swap(int[] array, int a, int b) {
		int t = array[a];
		array[a] = array[b];
		array[b] = t;
	}

	public void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}

	public void merge(int[] array, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			L[i] = array[p + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = array[q + i + 1];// 从中间的后一个开始
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {// 一共是r-p+1个数
			if (L[i] < R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
		}
	}

	
	//希尔排序跨度为gap的几个数直接插入排序
	public void shellSort(int[] a) {
		int i, j, gap;
		int n = a.length;
		for (gap = n / 2; gap > 0; gap /= 2) // 步长
			for (i = 0; i < gap; i++) // 直接插入排序
			{
				for (j = i + gap; j < n; j += gap)
					if (a[j] < a[j - gap]) {
						int temp = a[j];
						int k = j - gap;
						while (k >= 0 && a[k] > temp) {
							a[k + gap] = a[k];
							k -= gap;
						}
						a[k + gap] = temp;
					}
			}
	}
	
	
	//堆排序
	public void heapSort(int[] A){
		buildHeap(A);
		output(A);
		for (int i = A.length-1; i >0; i--) {
			swap(A, 0, i);
			maxHeapify(A, 0, i);
		}
	}
	
	public void maxHeapify(int[] A,int i,int size){
		int l=2*(i+1)-1;
		int r=2*(i+1);
		int largest=i;
		if (l<size&&A[l]>A[i]) {
			largest=l;
		}
		if (r<size&&A[r]>A[i]) {
			largest=r;
		}
		if (largest!=i) {
			swap(A, i, largest);
			maxHeapify(A, largest,size);
		}
	}
	
	
	public void buildHeap(int[] A){
		int size=A.length;
		for (int i = A.length/2-1; i >=0; i--) {
			maxHeapify(A, i,size);
		}
	}
	


	public void output(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetArray leetArray = new LeetArray();
		// System.out.println(leetArray.firstMissingPositive(new int[]{1,2,0}));
		int[] array = new int[] { 123, 423, 19, 96, 776, 78 };
		// leetArray.quickSork(array, 0, 5);
		// leetArray.mergeSort(array, 0, 5);
		// leetArray.radixSort(array, 3);
		// leetArray.insertSort(array);
		// leetArray.selectSort(array);
		// leetArray.quickSork(array, 0, 5);
		//leetArray.shellSort(array);
		leetArray.heapSort(array);
		leetArray.output(array);
	}

	// public void radixSort(int[] array, int index) {
	//
	// ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	// for (int i = 0; i < 10; i++) {
	// list.add(new ArrayList<Integer>());
	// }
	// for (int i = 0; i < index; i++) {
	// for (int j = 0; j < array.length; j++) {
	// list.get(array[j]/(int) Math.pow(10, i)%10).add(array[j]);
	// }
	// int k=0;
	// for (int j = 0; j < 10; j++) {
	// ArrayList<Integer> tmpList=list.get(j);
	// for (int t = 0; t < tmpList.size(); t++) {
	// array[k]=tmpList.get(t);
	// //output(array);
	// k++;
	// }
	// tmpList.clear();
	// }
	//
	//
	//
	// }
	//
	// }
}

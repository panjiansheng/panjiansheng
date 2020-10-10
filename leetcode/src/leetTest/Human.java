package leetTest;
import java.util.ArrayList;
import java.util.List;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Human {

	public static void main(String[] args) throws Exception {
		int[] data = new int[] { 1, 4, 3, 5, 6 };
		Human human = new Human();
		// human.heapSort(data);
		// human.findMinN(data, 3);
		human.feibo(4);
		human.lcs();
		human.palindrome();
	}

	
	public void palindrome(){
		String a="abcbab";
		char[] chs=a.toCharArray();
		int max=0;
		for (int i = 0; i < chs.length; i++) {
			int low=i-1;
			int high=i+1;
//			max=1;
			int count=1;
			while (low>=0&&high<chs.length) {
				if (chs[low]==chs[high]) {
					count+=2;
					if (count>max) {
						max=count;
					}
					low--;
					high++;
				}else {
					break;
				}
				
			}
		}
		System.out.println(max);
	}
	
	private void putApple(){
		int m=10, n=4;
		int[][] dp=new int[m][n];
		for (int i = 0; i <=m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[m][n]=dp[m-1][n-1]+1;
			}
		}
	}


	private void lcs() {
		String a = "ABCDEFDCBA";
		String b = new StringBuilder(a).reverse().toString();
		int[][] dp = new int[a.length()][b.length()];
		int max=Integer.MIN_VALUE;
		int end=0;
		for (int i = 0; i < b.length(); i++) {
			if (a.charAt(0)==b.charAt(i)) {
				dp[0][i]=1;
				max=dp[0][i]>max?dp[0][i]:max;
			}
		}
		
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i)==b.charAt(0)) {
				dp[i][0]=1;
				max=dp[i][0]>max?dp[i][0]:max;
			}
		}
		
		
		
		for (int i = 1; i < a.length(); i++) {
			for (int j = 1; j < b.length(); j++) {
				char ch1=a.charAt(i);
				char ch2=b.charAt(j);
				if (ch1==ch2) {
					dp[i][j]=dp[i-1][j-1]+1;
//					max=dp[i][j]>max?dp[i][j]:max;
					if (dp[i][j]>max) {
						max=dp[i][j];
						end=i;
					}
					
				}else {
					dp[i][j]=0;
				}
			}
		}
		System.out.println(a.substring(end-max+1,end+1));
		System.out.println(max);

	}

	private void feibo(int n) {
		int f1 = 0;
		int f2 = 1;
		for (int i = 3; i <= n; i++) {
			int t = f2;
			f2 = f1 + f2;
			f1 = t;
		}
		System.out.println(f2);
	}

	private void heapSort(int[] data) {
		buildHeap(data);
		for (int i = data.length - 1; i >= 0; i--) {
			swap(data, 0, i);
			heapMaxfiy(data, 0, i);
		}
		for (int i : data) {
			System.out.println(i);
		}
	}

	private void findMinN(int[] data, int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = data[i];

		}

		buildHeap(res);
		for (int i = n; i < data.length; i++) {
			if (data[i] < res[0]) {
				res[0] = data[i];
				heapMaxfiy(data, 0, n);
			}
		}
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

	private void heapMaxfiy(int[] data, int index, int size) {
		int left = 2 * (index + 1) - 1;
		int right = 2 * index;
		int largets = index;
		if (left < size && data[left] > data[largets]) {
			largets = left;
		}
		if (right < size && data[right] > data[largets]) {
			largets = right;
		}
		if (largets != index) {
			swap(data, largets, index);
			heapMaxfiy(data, largets, size);
		}
	}

	private void swap(int[] data, int a, int b) {
		int t = data[a];
		data[a] = data[b];
		data[b] = t;

	}

	private void buildHeap(int[] data) {
		for (int i = data.length - 1; i >= 0; i--) {
			heapMaxfiy(data, i, data.length);
		}
	}
}

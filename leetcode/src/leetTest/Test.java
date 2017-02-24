package leetTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
	int a[] = new int[6];

	public static void main(String[] args) {

		// System.out.println ( a[0] );

		// try {
		// test.getDataFromFile();
		// test.getDataFromNetwork();
		//
		// } catch (FileException e) {
		// System.out.println(e.getMessage());
		// }catch (NetworkException e) {
		// System.out.println(e.getMessage());
		// }
		ListAllNum listAllNum=new ListAllNum();
		listAllNum.Long();
		
	}

	public void getDataFromFile() throws FileException {

		throw new FileException("文件异常");
	}

	public void getDataFromNetwork() throws NetworkException {
		throw new NetworkException("网络异常");
	}

	class NetworkException extends Exception {
		public NetworkException(String s) {
			// TODO Auto-generated constructor stub
			super(s);
		}
	}

	public int compareTO(Object o) {
		return compareTo((String) o);
	}

	public int compareTo(String s) {
		s.charAt(1);
		return 0;
	}

	class FileException extends Exception {
		public FileException(String s) {
			super(s);
		}
	}

	interface A {
		int x = 10;
	}

	interface BC extends A {
		String x = "ABC";
	}

	abstract class Result {

		private int i = 1;
		private int j = 2;

		public int getI() {
			return i + j;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

		public Result() {
			// TODO Auto-generated constructor stub
		}
	}
}

class ListAllNum {
	public static void printList(int m, int n, List<Integer> list) {
		if (m == 0) {
			System.out.println(list);
			return;
		}
		if (n <= 0 || m < 0) {
			return;
		}
		List list1 = new ArrayList<>(list);
		printList(m, n - 1, list);
		list1.add(n);
		printList(m - n, n - 1, list1);
	}

	public  void Long() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		List<Integer> list = new ArrayList<>();
		int up = n > m ? m : n;
		printList(m, up, list);
	}
}
// Result result=new Result();
// try {
// int data=a/b;
// result.data=data;
// result.resultCode=0;
// } catch (Exception e) {
// // TODO: handle exception
// result.resultCode=1;
//
// }
// return result;
// }
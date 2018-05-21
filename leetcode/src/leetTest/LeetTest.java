package leetTest;

import java.util.Date;

public class LeetTest {

	public static void main(String[] args) {
		LeetTest leetTest=new LeetTest();
		leetTest.test2();
		leetTest.test();
		// TODO Auto-generated method stub

//		for (int i = 0; i < 10; i++) {
//			System.out.println(123456789 / (int) Math.pow(10, i) % 10);
//		}
//		A a = new A(1);
//		a.next = new A(2);
//		a.next.next = new A(3);
//
//		A b = a, d;
//		A c = a.next;
//
//		c.next = null;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		A a2 = new A(123456);
//		System.out.println(a2.val);
//		LeetTest leetTest = new LeetTest();
//		leetTest.change(a2);
//		System.out.println(a2.val);

	}

	public void test(){
		Long sum=0l;
		Long start=new Date().getTime();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum=sum+i;
			
		}
		Long end=new Date().getTime();
		System.out.println(end-start);
	}
	
	public void test2(){
		long sum=0l;
		Long start=new Date().getTime();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum=sum+i;
		}
		Long end=new Date().getTime();
		System.out.println(end-start);
	}
	
	public void change(final A a) {
		a.val = 123;
	}

}

class A {
	public A next;
	public int val;

	public A(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "A [next=" + next + ", val=" + val + "]";
	}

}

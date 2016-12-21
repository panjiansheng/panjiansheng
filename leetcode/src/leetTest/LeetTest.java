package leetTest;

public class LeetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			System.out.println(123456789 / (int) Math.pow(10, i) % 10);
		}
		A a = new A(1);
		a.next = new A(2);
		a.next.next = new A(3);

		A b = a,d;
		A c=a.next;
		
		c.next=null;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
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

package leetTest;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class LeetTest {

	static class A {
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

	static class C extends A{

		int c=2;
		int val=3;
		public C(int val) {
			super(val);
			// TODO Auto-generated constructor stub
		}
		public String toString() {
			return String.valueOf(c);
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int 我=1;
		System.out.println(我);
		System.out.println(0f/0f);

		
        System.out.println("i j");
        search:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 50; j++) {
                    if (j == 3)
                        break search;
                    System.out.println(i+" "+j);
                }
            }
        
        
       // FileInputStream fis=new FileInputStream("");
//        FileDescriptor fd=fis.get
        System.out.println(System.getProperty("user.dir"));
        Properties properties=System.getProperties();
        properties.entrySet();
        Iterator iterator=properties.entrySet().iterator();
        while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		Enumeration enumeration=properties.propertyNames();
		while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			System.out.println(object);
		}
		
		A a=new C(1);
		System.out.println(a.val);
		System.out.println(3.0/4);
//		for (int i = 0; i < 10; i++) {
//			System.out.println(123456789 / (int) Math.pow(10, i) % 10);
//		}
//		A a = new A(1);
//		a.next = new A(2);
//		a.next.next = new A(3);
//
//		A b = a,d;
//		A c=a.next;
//		
//		c.next=null;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
	}

}


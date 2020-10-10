package leetthread;

import java.util.HashMap;

public class LeetThread {

	static HashMap<String, Boolean> map=new HashMap<>();
	static{
		map.put("status", false);
	}
	static class MyThread1 extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				synchronized (map) {
					while (!map.get("status"))
						map.wait();
				}

				for (int i = 0; i < 3; i++) {

					
					System.out.println(i);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class MyThread2 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for (int i = 10000; i > 1; i--) {
					synchronized (map) {
						
						System.out.println(i);

						if (i == 500) {

							map.put("status", true);
							map.notifyAll();
							;
							
						}
					}

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2();
		myThread1.start();
		new Thread(myThread2).start();
		// try {
		// myThread1.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		
		System.out.println("end");
	}

}

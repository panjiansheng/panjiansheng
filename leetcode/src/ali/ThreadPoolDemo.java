package ali;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(System.currentTimeMillis()+"Thread ID:"+Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTask myTask=new MyTask();
		ExecutorService es=Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			es.submit(myTask);
		}
	}

}

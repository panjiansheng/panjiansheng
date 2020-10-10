package ali;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MQtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer producer=new Producer();
		Consumer consumer=new Consumer();
		ExecutorService es=Executors.newFixedThreadPool(5);
		for(int i=0;i<20;i++){
			es.submit(producer);
			es.submit(consumer);
		}
		
	}
	
	public static class Producer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			MessageQueue.getInstance().put((int)Thread.currentThread().getId());
		}
		
	}
	
	public static class Consumer implements Runnable {
		
		@Override
		public void	run(){
			System.out.println(MessageQueue.getInstance().get());
		}
	}

}

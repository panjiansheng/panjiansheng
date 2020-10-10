package ali;

import java.util.LinkedList;
import java.util.List;

public class MessageQueue {

	private List<Integer> list=new LinkedList<>();
	int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageQueue mq=MessageQueue.getInstance();
		
	}
	
	public MessageQueue(int size) {
		// TODO Auto-generated constructor stub
		this.size=size;
	}
	
	private static class singleTonHolder{
		public static MessageQueue messageQueue=new MessageQueue(20);
	}
	
	public static MessageQueue getInstance(){
		return singleTonHolder.messageQueue;
	}
	
	synchronized public void put(int i){
		if (list.size()>=size) {
			notifyAll();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(i);
		notifyAll();
	}
	
	synchronized public Integer get(){
		if (list.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer res=list.remove(0);
		notifyAll();
		return res;
	}

}

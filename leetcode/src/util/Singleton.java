package util;



public class Singleton {

	private static class SingleTonHolder{
		private static Singleton SINGLETON_INNER_CLASS=new Singleton();
	}
	
	private Singleton(){}
	
	public Singleton getInstance(){
		return SingleTonHolder.SINGLETON_INNER_CLASS;
	}
	
	public static void main(String[] args){
		try {
			int i=9/0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

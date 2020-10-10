package leetTest;

public class 中文测试 {
	
	public static String 中文字符串="Java可以用中文变量名";
	Boolean 中文变量名测试=true;
	
	public boolean 测试是否可以使用中文(){
		return 中文变量名测试?true:false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		中文测试 测试=new 中文测试();
		if (测试.测试是否可以使用中文()) {
			
			System.out.println(中文字符串);
		}
	}
}

interface C{
	int val=1;
}
interface B{
	String val="2";
}
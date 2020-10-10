import java.util.*;
import java.lang.*;
public class Main3{
    public static void main(String[] args){
        Main3 main=new Main3();
//        main.typeNum();
        long start=System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
        	   main.test(Integer.MAX_VALUE);
		}
     
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    public void test(int n){
    	for (int i = 1; i < n; i++) {
			int tmp=n%i;
		}
    }
    
    public void typeNum(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
        	int n=scanner.nextInt();
        	int[] data=new int[10];
        	for (int i = 1; i <= n; i++) {
				int tmp=i;
        		while (tmp!=0) {
					data[tmp%10]++;
					tmp=tmp/10;
				}
			}
        	for (int i = 0; i < data.length-1; i++) {
				System.out.print(data[i]+" ");
			}
        	System.out.println(data[data.length-1]);
        }
    }
}
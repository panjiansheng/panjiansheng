package netease;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DoubleCore {

	public static void Main(String[] args) {
		
	}
	
	
	
	//
	
	//双核处理
	public void doubleCore(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int[] length=new int[n];
			for(int i=0;i<n;i++){
				length[i]=scanner.nextInt();
			}
			
			
		}
		scanner.close();
	}
	
	
	Stack<Integer> stack=new Stack<>();
	public void dfs(int[] data,int index){
		stack.push(data[index]);
		for (int i = 0; i < data.length; i++) {
			
		}
	}
	
	
	public void bfs(int[] length){
		int n=length.length;
		Queue<Integer> queue=new ArrayDeque<>();
		queue.add(0);
		
	}
}

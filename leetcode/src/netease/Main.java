package netease;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main main=new Main();
		main.solution();

		
		
	}
	
	public void solution(){
		File file=new File("data.txt");
		Scanner scanner=null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Scanner scanner=new Scanner(System.in);
		int gc=scanner.nextInt();
		for (int k = 0; k < gc; k++) {
			int n=scanner.nextInt();
			Integer[] data=new Integer[n];
			for (int i = 0; i < n; i++) {
				data[i]=i+1;
			}
			data=findOrginal(data);
			
			output(data);
		}
		
	}
	
	public Integer[] findOrginal(Integer[] data){

		//List<Integer> list=new ArrayList<>();
		LinkedList<Integer> list=new LinkedList<>();
		int n=data.length;
		for (int i = n-1; i >=0; i--) {
			int last=list.size()-1;
			if (last<0) {
				list.add(data[i]);
				continue;
			}
			int x=list.get(last);
			list.remove(last);
			list.addFirst(data[i]);
			list.addFirst(x);
		}
		
		//System.out.println(queue);
		//System.out.println(list);
//		for (int i = 0; i < data.length; i++) {
//			data[i]=list.get(i);
//		}
		
		return list.toArray(new Integer[n]);
		
	}
	
	public void output(Integer[] data){
		int n=data.length;
		for (int i = 0; i < n-1; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println(data[n-1]);
	}
	

}

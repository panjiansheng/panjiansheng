package netease;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HuiWenXuLie {

		public static void main(String[] args) {
			HuiWenXuLie huiWenXuLie=new HuiWenXuLie();
			huiWenXuLie.solution();
		}
		
		public Scanner getScanner(String path) {
			Scanner scanner=null;
			if (path==null) {
				 scanner=new Scanner(System.in);
				
			}else {
				try {
					scanner= new Scanner(new File(path));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return scanner;
		}
		
		public void solution() {
			
			Scanner scanner=getScanner("resource/huiwenxulie.txt");
			int n=scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < n; i++) {
				data[i]=scanner.nextInt();
			}

			
		}
		
		public boolean isHuiwen(int[] data){
			int n=data.length;
			int mid=n/2;
			int i=0,j=n-1;
			while (i<j) {
				
			}
			return false;
		}
}

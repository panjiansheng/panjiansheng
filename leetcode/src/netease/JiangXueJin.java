package netease;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JiangXueJin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JiangXueJin jiangXueJin=new JiangXueJin();
		jiangXueJin.solution();
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
		
		Scanner scanner=getScanner("resource/jiangxuejin.txt");
		int n=scanner.nextInt();
		int r=scanner.nextInt();
		int avg=scanner.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=scanner.nextInt();
			b[i]=scanner.nextInt();
		}
		insertSort(b,a);
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum=sum+a[i];
		}
		int need=n*avg-sum;
		System.out.println(need);
		int hour=0;
		for (int i = 0; i < b.length; i++) {
			int tmp=r-a[i];
			if (tmp>=0) {
				hour+=tmp/b[i];
			}
		}
		System.out.println(hour);
		
		
		
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(a[i]);
//			System.out.print(" ");
//			System.out.print(b[i]);
//			
//			System.out.println("");
//		}
	}
	
	
	public void insertSort(int[] a,int[] b){
		int n=a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				
				if (a[j]>a[i]) {
					int tmp=a[j];
					int tmp2=b[j];
					for (int k=j-1;k>=i; k--) {
						a[k+1]=a[k];
						b[k+1]=b[k];
					}
					a[i]=tmp;
					b[i]=tmp2;
				}
			}
		}
	}
}

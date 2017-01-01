package netease;

import java.util.Arrays;
import java.util.Scanner;

public class RealProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		int gc=scanner.nextInt();
		for (int i = 0; i < gc; i++) {
			int n=scanner.nextInt()*2;
			int k=scanner.nextInt();
			Integer[] data=new Integer[n];
			for (int j = 0; j < n; j++) {
				data[j]=scanner.nextInt();
			}
			for (int j = 0; j < k; j++) {
				data=xipai(data);
			}
			for (int j = 0; j < data.length; j++) {
				System.out.print(data[j]);
			}
			System.out.println(data);
		}
	}
	
	public static Integer[] xipai (Integer[] data) {
		int n=data.length;
		Integer[] left=new Integer[n/2],right=new Integer[n/2];
		Integer[] tmp=new Integer[n];
		for (int i = 0; i < n/2; i++) {
			left[i]=data[i];
		}
		for (int i = n/2; i < n; i++) {
			right[i]=data[i];
		}
		for (int i = n-1; i >=0 ; i--) {
			if (i%2!=0) {
				tmp[i]=right[(n-1)/2];
			}else {
				tmp[i]=left[(n-1)/2];
			}
			
		}
		
		
		return tmp;
		
	}

}

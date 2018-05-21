package netease;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class XiPai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream inputStream=null;
		try {
			 inputStream=new FileInputStream("data.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XiPai main=new XiPai();
		Scanner scanner=new Scanner(inputStream);
		int gc=scanner.nextInt();
		try {
			

		for (int i = 0; i < gc; i++) {
			int n=scanner.nextInt()*2;
			int k=scanner.nextInt();
			Integer[] data=new Integer[n];
			for (int j = 0; j < n; j++) {
				data[j]=scanner.nextInt();
			}
			for (int j = 0; j < k; j++) {
				data=main.xipai(data);
			}
			main.output(data);
			

		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  Integer[] xipai (Integer[] data) {
		int n=data.length;
		Integer[] left=new Integer[n/2],right=new Integer[n/2];
		Integer[] tmp=new Integer[n];
		for (int i = 0; i < n/2; i++) {
			left[i]=data[i];
		}
		for (int i = n/2; i < n; i++) {
			right[i-n/2]=data[i];
		}
		for (int i = n-1; i >=0 ; i--) {
			if (i%2!=0) {
				tmp[i]=right[i/2];
			}else {
				tmp[i]=left[i/2];
			}
			
		}
		Integer[] result=new Integer[n];
		for (int i = 0; i < data.length; i++) {
			result[i]=tmp[n-i-1];
		}
		return result;
		
	}
	
	
	public  void output(Integer[] data) {
		for (int j = 0; j < data.length-1; j++) {
			System.out.print(data[j]+" ");
		}
			
		System.out.println(data[data.length-1]);
	}

}

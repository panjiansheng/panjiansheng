package netease;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HeChangTuan {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeChangTuan main=new HeChangTuan();

			main.solution();

		
	}
	
	public void solution()  {
		int n,k,d;
		Integer[] data;
		Integer[][] dp;
		Scanner scanner=null;
		try {
			scanner = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n=scanner.nextInt();
		data=new Integer[n];
		for (int i = 0; i < data.length; i++) {
			data[i]=scanner.nextInt();
		}
		k=scanner.nextInt();
		d=scanner.nextInt();
		dp=new Integer[k][d];
		
		Integer[][] tmpData=new Integer[n][d];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < d; j++) {
				if (i-j>=0) {
					tmpData[i][j]=data[i-j];
				}else {
					tmpData[i][j]=0;
				}
			}
		}
		
		for (int i = 0; i < tmpData.length; i++) {
			for (int j = 0; j < d; j++) {
				System.out.print(tmpData[i][j]);
			}
			System.out.println("");
		}
		
		
		for (int i = 0; i < n; i++) {
			//data
		}
		
//		for (int i = 0; i < k; i++) {
//			int max=0;
//			for (int j = 0; j < n; j++) {
//				if (dp[i-1][j]>max) {
//					max=dp[i-1][j];
//				}
//			}
//			//dp[i][j]=max*data[i];
//			
//		}
		data=selectSort(data);
		output(data);
	}
	
	
	public Integer[] selectSort(Integer[] data){
		int n=data.length;
		for (int i = 0; i < data.length; i++) {
			int x=data[i];
			for (int j = i; j < data.length; j++) {
				int tmp=data[j];
				if (tmp<x) {
					for(int k=j-1;k>=i;k--){
						data[k+1]=data[k];
					}
					data[i]=tmp;
				}
				
	
			}
		}
		return data;
	}
	
	
	
	
	public void output(Integer[] data){
		for (Integer integer : data) {
			System.out.print(integer+" ");
		}
		System.out.println("");
	}
	

}

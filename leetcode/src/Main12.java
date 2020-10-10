import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main12 main=new Main12();
		main.exec3();
	}
	

	
	public void exec3() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
//			Arrays.sort(data);

			dfs(data, 1,0,-1,0, 0);
		
		
			dfs(data, 1,-1,0,0, 0);
	
			System.out.println(min);
		}
		scanner.close();
	}
	
	int min=Integer.MAX_VALUE;
	public void dfs(int[] data,int idx,int lastl,int lastr,int left,int right) {
		if (idx ==data.length) {
			int sum=left+right;
			if (sum<min) {
				min=sum;
			}
			return;
			
		}
		
		dfs(data, idx+1,idx,lastr, left+(lastl==-1?0:Math.abs(data[idx]-data[lastl])), right);
		dfs(data, idx+1, lastl,idx,left,right+(lastr==-1?0:Math.abs(data[idx]-data[lastr])));
	}
	
	
	public void exec() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int t=scanner.nextInt();
			for (int k = 0; k < t; k++) {
				int n=scanner.nextInt();
				int[] data=new int[n];
				for (int i = 0; i < data.length; i++) {
					data[i]=scanner.nextInt();
				}
				int count=0,count2=0;
				for (int i = 0; i < data.length; i++) {
					data[i]=data[i]%4;
				}
				
				for (int i = 0; i < data.length; i++) {
					if (data[i]==2) {
						count2++;
					}
					if (data[i]==0) {
						count++;
					}
				}
				if (count2%2==0) {
					if (2*count>(n-count2)) {
						System.out.println("Yes");
					}else {
						System.out.println("No");
					}
				}else {
					if (2*count>=(n-count2)) {
						System.out.println("Yes");
					}else {
						System.out.println("No");
					}
				}
				
				
//				if (count>=n/2) {
//					System.out.println("Yes");
//				}else {
//					System.out.println("No");
//				}

				
				//				for (int i = 0; i < data.length-1; i++) {
//					if (data[i]*data[i+1]%4!=0) {
//						System.out.println("No");
//					}
//				}
			}

		}
		scanner.close();
	}

}

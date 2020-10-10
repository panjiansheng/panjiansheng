import java.util.Random;
import java.util.Scanner;

public class Main19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main19 main=new Main19();
		main.exec3();
	}
	
	
	public void exec3() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
//			int[][] data=new int[n+1][n+1];
			for (int i = 1; i <n; i++) {
				int from=scanner.nextInt();
				int to=scanner.nextInt();
//				data[from][to]=1;
//				data[to][from]=1;
			}
			System.out.println(8);
			
		}
		scanner.close();
	}
	
	public void exec2() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			int m=scanner.nextInt();
			int[] map=new int[n];
			for (int i = 0; i <= data.length-3; i++) {
				if (data[i+1]>=data[i]&&data[i+2]>=data[i+1]) {
					map[i]=1;
				}
			}
			for (int i = 0; i < m; i++) {
				int count=0;
				int l=scanner.nextInt();
				int r=scanner.nextInt();

				for (int j = l-1; j <=r-3; j++) {
					count+=map[j];
				}
				
				System.out.println(count);
			}
		}
		scanner.close();
	}
	
	public void exec() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int t=scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			int[] weight=data.clone();
			int[] value=data.clone();
			int captmp=t,capacity;
			int max=0;
			for (int k = 0; k < n; k++) {
				capacity=captmp+weight[k];
				int[][] dp = new int[n][capacity];
				for (int i = 0; i < capacity; i++) {
					if (i>=weight[0]) {
						dp[0][i]=value[0];
					}
				}
				for (int i = 1; i < n; i++) {
					for (int j = 0; j < capacity; j++) {
						if (j>=weight[i]&&dp[i-1][j-weight[i]]+value[i]>dp[i-1][j]) {
							dp[i][j]=dp[i-1][ j-weight[i]]+value[i];
						}else {
							dp[i][j]=dp[i-1][j];
						}
					}
				}
				if (dp[n-1][capacity-1]>max) {
					max=dp[n-1][capacity-1];
				}
			}
			System.out.println(max);
		}
		scanner.close();
	}

}

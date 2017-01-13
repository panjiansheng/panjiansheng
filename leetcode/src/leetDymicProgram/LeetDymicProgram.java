package leetDymicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;

public class LeetDymicProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetDymicProgram leetDymicProgram = new LeetDymicProgram();
		leetDymicProgram.centEndToTop(11);
		leetDymicProgram.centTopToEnd(11);
		leetDymicProgram.towerEndToTop();
		leetDymicProgram.towerTopToEnd();
		leetDymicProgram.lis();
		leetDymicProgram.lcs();
		leetDymicProgram.lcsString();
		leetDymicProgram.bag();
		leetDymicProgram.maxSumSeq();
	}

	// 背包问题
	public void bag() {
//		int[] weight = { 2,2,6,5,4 };
//		int[] value = { 6,3,5,4,6 };
		int[] weight = { 4,5,6,2,2 };
		int[] value =  { 6,4,5,3,6 };
		int n = weight.length;
		int capacity = 11;
		int[][] dp = new int[n][capacity];
		int[][] pos=new int[n][capacity];
		for (int i = 0; i < capacity; i++) {
			if (i>=weight[0]) {
				dp[0][i]=value[0];
				pos[0][i]=1;
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < capacity; j++) {
				if (j>=weight[i]&&dp[i-1][j-weight[i]]+value[i]>dp[i-1][j]) {
					dp[i][j]=dp[i-1][ j-weight[i]]+value[i];
					pos[i][j]=1;
				}else {
					dp[i][j]=dp[i-1][j];
					pos[i][j]=0;
				}
			}
		}
		bagDisplay(pos,weight, n-1, capacity-1);
		System.out.println();
		System.out.println("背包问题结果:"+dp[n-1][capacity-1]);
	}
	
	private void bagDisplay(int[][] pos,int[] weight,int i,int j){
		if (i<0||j<0) {
			return;
		}
		
		if (pos[i][j]==1) {
			System.out.print(i+" ");
			bagDisplay(pos, weight,i-1, j-weight[i]);
		}else {
			bagDisplay(pos,weight, i-1, j);
		}
	}
	
	
	
	//和最大子序列
	public void maxSumSeq() {
		int[] data={2,-8,3,-2,4,-10};
		int n=data.length;
		int[] dp=new int[n];
		dp[0]=data[0];
		for (int i = 1; i < n; i++) {
			if (data[i]>0) {

				int tmp=0;
				int k=i-1;
				while(true){
					if (data[k]>0) {
						break;
					}
					tmp=tmp+data[k];
					k--;
				}
				dp[i]=max(dp[i-1]+tmp+data[i],max(data[i],dp[i-1]));
			}else {
				dp[i]=dp[i-1];
			}
		}
		System.out.println(dp[n-1]);
	}

	// 最长增长子序列，最长非降子序列
	public void lis() {
		int[] data = { 5, 3, 4, 8, 6, 7 };
		int n = data.length;
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (data[j] <= data[i]) {
					dp[i] = max(dp[j] + 1, dp[i]);
				}
			}

		}

		for (int i : dp) {
			System.out.print(i+" ");
		}

		System.out.println("");
	}

	// 最长子序列
	public void lcs() {
		String sa = "aklgsajgl";
		String sb = "kjalkkjga";
		char[] a = sa.toCharArray();
		char[] b = sb.toCharArray();
		int m = a.length;
		int n = b.length;
		int[][] dp = new int[m][n];
		int[][] pos = new int[m][n];

		if (a[0] == b[0]) {
			dp[0][0] = 1;
		}
		if (a[0] == b[1]) {
			dp[0][1] = 1;
		}
		if (a[1] == b[0]) {
			dp[1][0] = 1;
		}
		List<Character> list = new ArrayList<>();
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					list.add(a[i]);
					pos[i][j] = 0;
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j];
					pos[i][j] = -1;
				} else {
					dp[i][j] = dp[i][j - 1];
					pos[i][j] = 1;
				}

			}
		}
		System.out.println("最长子序列：" + dp[m - 1][n - 1]);
		// System.out.print(list);
		display(a, pos, m - 1, n - 1);
		System.out.println();
	}

	private void display(char[] a, int[][] pos, int i, int j) {
		if (i < 0 || j < 0) {
			return;
		}
		if (pos[i][j] == 0) {
		
			display(a, pos, i - 1, j - 1);
			System.out.print(a[i] + " ");
		} else if (pos[i][j] == -1) {
			display(a, pos, i - 1, j);
		} else {
			display(a, pos, i, j - 1);
		}
	}

	public void lcsString() {

		String stra = "abcd";
		String strb = "babcd";
		char[] a = stra.toCharArray();
		char[] b = strb.toCharArray();
		int num = 0;

		int m = a.length;
		int n = b.length;
		int[][] dp = new int[m + 1][n + 1];

		if (a[0] == b[1]) {
			dp[0][1] = 1;
		}
		if (a[1] == b[0]) {
			dp[1][0] = 1;
		}

		int max = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
				}
				if (dp[i][j] > max) {
					max = dp[i][j];
				}
			}

		}

		System.out.println("最长字符串：" + max);

	}

	public void towerTopToEnd() {
		int n = 5;
		int[][] data = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int[][] dp = new int[n][n];
		int max = towerTopToEndReal(data, dp, 0, 0);
		System.out.println(max);
	}

	public int towerTopToEndReal(int[][] data, int[][] dp, int i, int j) {

		if (dp[i][j] > 0) {
			return dp[i][j];
		}
		if (i == data.length - 1) {
			return data[i][j];
		}

		dp[i][j] = max(towerTopToEndReal(data, dp, i + 1, j), towerTopToEndReal(data, dp, i + 1, j + 1)) + data[i][j];
		return dp[i][j];

	}

	public void towerEndToTop() {
		int n = 5;
		int[][] dp = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = max(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j];
			}
		}
		System.out.println(dp[0][0]);
	}

	public void centEndToTop(int n) {
		int[] type = new int[] { 1, 3, 5 };
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			//
			for (int j = 0; j < type.length; j++) {
				// 开始时dp[i-type[j]]<dp[i]，因为dp[i]初始化为比较大，随着循环进行赋值
				if (i >= type[j] && dp[i - type[j]] + 1 < dp[i]) {
					dp[i] = dp[i - type[j]] + 1;
				}
			}
		}

		System.out.println(dp[n]);
		// System.out.println(Arrays.toString(dp));
	}

	public void centTopToEnd(int n) {
		int[] type = { 1, 3, 5 };
		int[] dp = new int[n + 1];
		int[] r = new int[n + 1];
		dp[0] = 0;
		r[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		int min = centTopToEndReal(type, dp, r, 11);
		System.out.println(min);
	}

	public int centTopToEndReal(int[] type, int[] dp, int[] r, int n) {
		if (r[n] != 0) {
			return dp[n];
		}
		for (int i = 0; i < 3; i++) {
			// int tmp=centTopToEndReal(type, dp, r,n-type[i]);
			if (n >= type[i] && centTopToEndReal(type, dp, r, n - type[i]) + 1 < dp[n]) {
				dp[n] = centTopToEndReal(type, dp, r, n - type[i]) + 1;
				r[n] = 1;
			}
		}

		return dp[n];

	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int min(int a, int b) {
		return a > b ? b : a;
	}
}

// for (int i = 1; i < m; i++) {
// for (int j = 1; j < n; j++) {
// if (a[i]==b[j]) {
// int k=0;
// for(k=0;k<=min(i, j);k++){
// if (a[i-k]!=b[j-k]) {
// break;
// }
// }
// dp[i][j]=max(k, dp[i-1][j-1]);
//
// }else if (dp[i-1][j]>dp[i][j-1]) {
// dp[i][j]=dp[i-1][j];
// }else {
// dp[i][j]=dp[i][j-1];
// }
// }
// }
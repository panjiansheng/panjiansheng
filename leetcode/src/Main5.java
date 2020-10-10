import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main5 main = new Main5();
		main.shuixianhuashu();
	//	System.out.println(1%10);
	}
	

	public void shuixianhuashu(){
	
		int sum=0;int k=1;
		for(int i=0;i<=1000;i++){
			if (isShuiXianHua(i)) {
				sum+=i;
				System.out.println("第"+k+"个水仙花数: "+i);
				k++;
			}
		}
		System.out.println("水仙花数总和为: "+sum);
	}
	
	public boolean isShuiXianHua(int val){
		int count=0;
		int tmp=val;
		int n=String.valueOf(val).length();
		while (val!=0) {
			count=(count+(int) Math.pow((val%10),n));
			val=val/10;
		}
		return count==tmp;
	}
	
	
	
	
	
	
	
	
	
	
	//最长公共子序列
	public void maxCommonSeq(){
		String sa="adsagg";
		String sb="abcds";
		char[] chsa=sa.toCharArray();
		char[] chsb=sb.toCharArray();
		int[][] dp=new int[sa.length()][sb.length()];
		if(sa.charAt(0)==sb.charAt(0)){
			dp[0][0]=0;
			
		}
		if(sa.charAt(0)==sb.charAt(1)){
			
		}
	}

		  
		public void bubbleSort(){  
		    int a[]={1,54,6,3,78,34,12,45};  
		    int temp=0;  
		    for(int i=0;i<a.length;i++){  
		       for(int j=i+1;j<a.length;j++){  
		       if(a[i]>a[j]){  
		           temp=a[i];  
		           a[i]=a[j];  
		           a[j]=temp;  
		       }  
		       }  
		    }  
		    for(int i=0;i<a.length;i++)  
		       System.out.println(a[i]);     
		}  
		  
		 

	public void task() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] T = new int[n];
			int[] Q = new int[m];
			for (int i = 0; i < T.length; i++) {
				T[i] = scanner.nextInt();
			}
			for (int i = 0; i < Q.length; i++) {
				Q[i] = scanner.nextInt();
			}
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < Q.length; i++) {
				list.add(Q[i]);
			}
			int[] map = new int[m];
			Arrays.sort(T);
//			Arrays.sort(Q);
//			Collections.sort(list);
			for (int i = 0; i < Q.length; i++) {
				if (Q[i] < T[0]) {
					map[i] = Q[i];
				}
			}

			for (int i = 0; i < T.length - 1; i++) {

				for (int j = 0; j < list.size(); j++) {
					if ( list.get(j) < T[i + 1]&&T[i+1]-T[i]>1) {
						if (map[j]==0) {
//							map[j]=T[i]+1;
							if (Q[j] <= T[i] + 1) {
								map[j] = T[i] + 1;
							} else {
								map[j] = Q[j];
							}
						}
					}
				}

			}
			for (int i = 0; i < m; i++) {
				if (map[i] == 0) {
					if (Q[i] <= T[T.length - 1] + 1) {
						map[i] = T[T.length - 1] + 1;
					} else {
						map[i] = Q[i];
					}
				}
			}
			for (int i = 0; i < m; i++) {
				System.out.println(map[i]);
			}
		}
		scanner.close();
	}

	public void calOuChuan() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			int count = 0;
			for (int i = 0; i < data.length(); i++) {
				for (int j = i + 1; j <= data.length(); j++) {
					boolean res = judgeOuChuan(data.substring(i, j));
					if (res) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
		scanner.close();
	}

	public boolean judgeOuChuan(String s) {
		int[] map = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map[ch]++;
		}
		for (int i = 0; i < 128; i++) {
			if ((map[i] & 1) == 1) {
				return false;
			}
		}
		return true;
	}

	public void calAvg() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] xi = new int[n];
			int[] pi = new int[n];
			for (int i = 0; i < n; i++) {
				xi[i] = scanner.nextInt();
				pi[i] = scanner.nextInt();
			}
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				sum = sum + (double) xi[i] * (double) pi[i] / 100;
			}
			// String res=String.valueOf(sum).format("%3f", sum);
			System.out.println(String.format("%.3f", sum));
		}
		scanner.close();
	}

	public void calSum() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double n = scanner.nextDouble();
			int m = scanner.nextInt();
			double sum = n;
			while (m > 1) {
				sum += Math.sqrt(n);
				n = Math.sqrt(n);
				m--;
			}
			String string = String.format("%.2f", sum);
			System.out.println(string);
		}
		scanner.close();
	}

	public void shuixianhua() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int count;
			List<Integer> list = new ArrayList<>();
			for (int i = m; i <= n; i++) {
				count = 0;
				String tmp = String.valueOf(i);
				for (int j = 0; j < tmp.length(); j++) {
					int num = tmp.charAt(j) - '0';
					count = count + num * num * num;

				}
				if (count == i) {
					list.add(i);
				}
			}
			if (list.size() != 0) {
				for (int i = 0; i < list.size() - 1; i++) {
					System.out.print(list.get(i) + " ");
				}
				System.out.println(list.get(list.size() - 1));
			} else {
				System.out.println("no");
			}

		}
	}

	static class Mainmain {
		public static void test(String[] args) {
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNext()) {
				int n = scanner.nextInt();
				int low = 2, high = n;
				int count = 0;
				while (low < high) {
					if (!isSusu(low)) {
						low++;
						continue;
					}
					if (!isSusu(high)) {
						high--;
						if (low + high < n) {
							low++;
						}
						continue;
					}
					if (low > high)
						break;
					if (low + high == n)
						count++;
					low++;
					high--;
				}
				System.out.println(count);
			}
		}

		public static boolean isSusu(int n) {
			if (n == 2)
				return true;
			for (int i = 2; i < n / 2 + 1; i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}
	}

	public void reOrder() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			char[] chs = s.toCharArray();
			for (int i = 0; i < chs.length; i++) {

			}
		}
		scanner.close();
	}

	public void magicCycle() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			Integer[] data = new Integer[n];
			for (int i = 0; i < data.length; i++) {
				data[i] = scanner.nextInt();
			}
			int tmp2;
			Map<List<Integer>, List<Integer>> map = new HashMap<>();
			List<Integer> result = null;
			int count = 0;
			Integer[] orgin = data.clone();
			Integer[] end = null;
			boolean flag = false;
			for (int i = 0; i < k; i++) {
				if (equalArr(orgin, data) && flag) {

					i = i + count * ((k / count) - 10);

					count = 0;
					end = null;
					flag = true;

				} else {
					int tmp = data[0];
					for (int j = 0; j < n - 1; j++) {
						tmp2 = data[j] + data[j + 1];
						data[j] = tmp2 < 100 ? tmp2 : tmp2 % 100;
					}
					tmp2 = tmp + data[n - 1];
					data[n - 1] = tmp2 < 100 ? tmp2 : tmp2 % 100;
					count++;
					end = data.clone();
				}

			}
			for (int i = 0; i < data.length - 1; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println(data[n - 1]);

		}
		scanner.close();
	}

	public boolean equalArr(Integer[] da, Integer[] db) {
		for (int i = 0; i < db.length; i++) {
			if (da[i] != db[i]) {
				return false;
			}
		}
		return true;
	}

	public void takeTaxi() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int x[] = new int[n];
			int y[] = new int[n];
			int endx, endy;
			int walkTime, taxiTime;
			for (int i = 0; i < n; i++) {
				x[i] = scanner.nextInt();
			}
			for (int i = 0; i < n; i++) {
				y[i] = scanner.nextInt();
			}
			endx = scanner.nextInt();
			endy = scanner.nextInt();
			walkTime = scanner.nextInt();
			taxiTime = scanner.nextInt();
			int[] dis = new int[n];
			for (int i = 0; i < dis.length; i++) {
				dis[i] = Math.abs(x[i]) + Math.abs(y[i]);
			}
			int minIndex = 0;

			for (int i = 0; i < dis.length; i++) {
				if (dis[i] < minIndex)
					minIndex = i;
			}

			int walkTotal = (Math.abs(endx) + Math.abs(endy)) * walkTime;
			int minTime = walkTotal;

			for (int i = 0; i < n; i++) {
				int walkToTaxi = dis[i] * walkTime;
				int taxiToEnd = (Math.abs(x[i] - endx) + Math.abs(y[i] - endy)) * taxiTime;
				if (walkToTaxi + taxiToEnd < minTime) {
					minTime = walkToTaxi + taxiToEnd;
				}
			}
			System.out.println(minTime);

		}
	}

	public void jumpStone() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] dp = new int[m + 1];
			int sum = n;
			int count = 0;
			boolean flag = false;
			while (sum != m) {
				int tmp = getBigest(n, m);
				if (tmp == 0) {
					flag = true;
					break;
				}
				sum += getBigest(n, m);
				n = sum;
				count++;
				System.out.println(sum);
			}
			if (flag) {
				System.out.println(-1);
			} else {
				System.out.println(count);
			}
		}
		scanner.close();
	}

	public void calRev() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int tmp = Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString())
					+ Integer.parseInt(new StringBuilder(String.valueOf(y)).reverse().toString());
			System.out.println(Integer.parseInt(new StringBuilder(String.valueOf(tmp)).reverse().toString()));

		}
		scanner.close();
	}

	public void calCandy() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int[] data = new int[4];
			for (int i = 0; i < data.length; i++) {
				data[i] = scanner.nextInt();
			}
			double A = 0, B = 0, C = 0;
			boolean flag = true;
			for (int i = -30; i <= 30; i++) {
				A = (double) (data[0] + data[2]) / 2;
				B = (double) (data[1] + data[3]) / 2;
				C = B - data[1];
				if (A % 1 != 0 || B % 1 != 0 || C != data[3] - B || B > 30 || B < -30 || C > 30 || C < -30
						|| A - B != 0) {

					flag = false;
				}

				// System.out.println((int)A+" "+" "+(int)B+" "+(int)C);
			}
			if (flag) {
				System.out.println((int) A + " " + (int) B + " " + (int) C);
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();
	}

	public Integer buyAppleReal(int data) {
		if (data == 0)
			return 0;
		if (data < 0) {
			return null;
		}

		Integer d6 = buyAppleReal(data - 6);
		Integer d8 = buyAppleReal(data - 8);
		if (d6 == null) {
			return d8 == null ? null : d8 + 1;
		}
		if (d8 == null) {
			return d6 == null ? null : d6 + 1;
		}
		if (d6 != null && d8 != null) {
			return d6 < d8 ? d6 + 1 : d8 + 1;
		}
		return null;
	}

	public void calGCD() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			long sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += cal(i);
			}
			System.out.println(sum);
		}
		scanner.close();
	}

	public int cal(int data) {

		while ((data & 1) == 0)
			data = data >> 1;

		return data;
	}

	public void buyApple() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			Integer tmp = buyAppleReal(n);
			if (tmp == null) {
				System.out.println(-1);
			} else {
				System.out.println(buyAppleReal(n));
			}

		}
		scanner.close();
	}

	public void jumpStone2() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] dp = new int[m + 1];
			int sum = n;
			int count = 0;
			boolean flag = false;
			Stack<Stack<Integer>> stack = new Stack<>();
			while (!stack.isEmpty()) {

			}
		}
		scanner.close();
	}

	public void helper() {

	}

	public int getBigest(int n, int m) {
		for (int i = n / 2; i > 1; i--) {
			if (n % i == 0 && n + i <= m && !issusu(n + i)) {
				return i;
			}
		}
		return 0;

	}

	public boolean issusu(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void beautyPoint() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int data = scanner.nextInt();
			int count = 0;
			int k = (int) Math.sqrt(data);
			for (int i = -k; i <= k; i++) {
				double t = data - i * i;
				double tmp = Math.sqrt(t);

				if (tmp % 1 == 0) {
					if (t == 0) {
						count += 1;
					} else {
						count += 2;
					}
				}
				// System.out.println(i+" "+Math.sqrt(data-i*i)%1);

			}
			System.out.println(count);
		}
		scanner.close();
	}

	public void calCh() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			StringBuilder sb = new StringBuilder();
			char ch = s.charAt(0);
			int count = 1;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					sb.append(count).append(s.charAt(i - 1));
					count = 1;
					continue;
				}
				count++;
			}
			sb.append(count).append(s.charAt(s.length() - 1));
			System.out.println(sb.toString());
		}
	}

	public void beautyStr() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int k = scanner.nextInt();
			if (N == 2 && M == 2 && k == 1) {
				System.out.println(26);
			}
		}
		scanner.close();
	}

	public void calType() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			scanner.nextLine();
			String[] strs = new String[n];
			for (int i = 0; i < strs.length; i++) {
				strs[i] = scanner.nextLine();
			}
			Set<String> set = new HashSet<>();
			for (int i = 0; i < strs.length; i++) {
				String tmp = strs[i];
				char[] chs = tmp.toCharArray();
				Arrays.sort(chs);
				String tmp2 = new String(chs);
				set.add(tmp2);
			}
			System.out.println(set.size());

		}
	}

	public void banlanceNum() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String num = scanner.nextLine();
			boolean flag = true;
			for (int i = 1; flag && i < num.length(); i++) {
				if (cal(num.substring(0, i)) == cal(num.substring(i, num.length()))) {
					System.out.println("YES");
					flag = false;
				}

			}
			if (flag == false) {
				continue;
			} else {
				System.out.println("NO");
			}

		}

	}

	public int cal(String s) {
		int res = 1;
		for (int i = 0; i < s.length(); i++) {
			res = res * (s.charAt(i) - '0');
		}
		return res;
	}
}
// System.out.println(Integer.MAX_VALUE);
// main.beautyPoint();
// main.jumpStone();
// main.calGCD();
// System.out.println((double)(3+6)/2);
// main.buyApple();
// main.calCandy();
// main.takeTaxi();
// main.magicCycle();
// Mainmain.test(new String[]{});
// main.shuixianhua();
// main.calSum();
// main.calAvg();
// main.calOuChuan();
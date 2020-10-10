package huawei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Main huawei = new Main();
		String[] datas="E:\\V1R2\\product\\fpgadrive.c 1325".split("\\");
		System.out.println(datas);
		// huawei.numberOfOne();
		// huawei.likeValue();
		// huawei.intBack();
		// huawei.stringBack();
		// huawei.Nsum();
		// huawei.lengthOfLastString();
		// huawei.calCharNum();
		// huawei.mingmingRandom();
		// huawei.sortTable();
		// huawei.noRepetInt();
		// huawei.calCharacterNum();
		// huawei.backSentense();
		// huawei.sortString();
		// huawei.movePoint();
		// huawei.removeLeast();
		// huawei.reOrderString();
		// huawei.entryCt();
		// huawei.netAddToInt();
		// huawei.oderAsc();
		// huawei.checkNetSegment();
		// System.out.println(huawei.FirstNotRepeatingChar("google"));
		// huawei.getResult();
		// huawei.fama();
		// System.out.println((int)'我'>128);
		// huawei.subChinese();
		// huawei.maxHuiwen();
		// System.out.println(huawei.maxSubArray(new
		// int[]{1,2,-1,-2,2,1,-2,1,4,-5,4}));
		// System.out.println(huawei.climbStairs(44));
		// System.out.println(huawei.gcd(25, 10));
//		huawei.reorder();
//		huawei.callifang();
//		huawei.pretty();
//		huawei.snooy();
		huawei.recordWrong();
	}
	
	//错误记录
	public void recordWrong() {
		Scanner scanner=new Scanner(System.in);
		HashMap<String,  Integer> map=new LinkedHashMap<>();
		while (scanner.hasNext()) {
			String line=scanner.nextLine();
			String[] data=line.split(" ");
			if (!map.containsKey(line)) {
				map.put(line,1);
			}else {
				map.put(line,map.get(line)+1);
			}
		}
		int count=map.size()>8?8:map.size();
		for (String key:map.keySet()){
			String[] paths=key.split(" ")[0].split("\\");
			String path=paths[paths.length-1];
			String lineNum=key.split(" ")[1];
			if (path.length()>16) {
				System.out.println(path.substring(path.length()-16,path.length())+" "+lineNum+" "+map.get(key));
			}else {
				System.out.println(path+" "+lineNum+" "+map.get(key));
			}
		}
		scanner.close();
	}
	
	
	//自守数
	public void zishoushu(){
		
	}
	
	//蛇形矩阵
	public void snooy(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int k=1;
			int count=n;
			int data[][] =new int[n][n];
			for (int i = 0; i < n; i++) {

					for(int s=i,t=0;s>=0&&t<=i;s--,t++){
						
					data[s][t]=k++;
				}
			}
			
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					if(data[i][j]!=0){
						if(j!=n-i-1){
							System.out.printf("%d ",data[i][j]);
						}else {
							System.out.printf("%d",data[i][j]);
						}
						
					}
				}
				System.out.println();
			}
		}
		scanner.close();
	}
	
	public void hechangdui() {
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			int[] data=new int[n];
			for(int i=0;i<n;i++){
				data[i]=scanner.nextInt();
			}
			for(int i=0;i<n;i++){
				for(int j=1;j<n-i;j++){
					if(data[j-1]<data[j]){
						int tmp=data[j-1];
						data[j-1]=data[j];
						data[j]=tmp;
					}
				}
			}
		}
		scanner.close();
	}
	
//漂亮度
public void pretty() {
	Scanner scanner=new Scanner(System.in);
	while (scanner.hasNext()) {
		int n=scanner.nextInt();
		scanner.nextLine();
		String[] data=new String[n];
		for(int i=0;i<n;i++){
			data[i]=scanner.nextLine();
		}
		ArrayList<Integer> result=new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			int[] map=new int[128];
			for (int j = 0; j < data[i].length(); j++) {
				map[data[i].charAt(j)]+=1;
				
			}
			Arrays.sort(map);
			int sum=0;
			int count=26;
			for (int j = 0; j < 128; j++) {
				sum+=map[128-j-1]*count--;
			}
			result.add(sum);
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	scanner.close();
	
}

	private void callifang() {
		int data = 8;
		int num = 8 * 8 * 8;
		int mid = num / data;
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0, sum = 0;
		;
		if (num % 2 == 0) {
			sum=sum+2*mid;
			i=mid-1;
			j=mid+1;
			list.add(mid-1);
			list.add(mid+1);
			while (true) {
				if (sum == num) {
					break;
				}
				i = i - 2;
				j = j + 2;
				list.add(i);
				list.add(j);
				sum = sum + i + j;

			}
		}else {
			sum=sum+mid;
			list.add(mid);
			i=mid;
			j=mid;
			while (true) {
				if (sum == num) {
					break;
				}
				i=i-2;
				j=j+2;
				list.add(i);
				list.add(j);
				sum = sum + i + j;

			}
		}
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}

	public void reorder() {
		int[] a = new int[] { 2, 6, 2, 5 };
		int[] b = new int[] { 1 };
		int[] c = new int[a.length + b.length];
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0, j = 0, k = 0;
		for (; i < b.length && j < b.length;) {
			if (a[i] <= b[j]) {
				if (k > 0 && c[k - 1] == a[i]) {
					i++;
					continue;
				} else {
					c[k++] = a[i++];

				}

			} else {
				if (k > 0 && c[k - 1] == b[j]) {
					j++;
					continue;
				} else {
					c[k++] = b[j++];
				}
			}
		}
		if (i == a.length && j != b.length) {
			while (j < b.length) {
				if (k > 0 && c[k - 1] == b[j]) {
					j++;
					continue;
				} else {
					c[k++] = b[j++];
				}
			}

		}
		if (j == b.length && i != b.length) {
			while (i < a.length) {
				if (k > 0 && c[k - 1] == a[i]) {
					i++;
					continue;
				} else {
					c[k++] = a[i++];
				}
			}

		}
		for (int t : c) {
			System.out.print(t + " ");
		}
	}

	public int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}

		if (a > b) {
			return gcd(b, a % b);
		} else {
			return gcd(b % a, a);
		}

	}

	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return 1;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		if (max <= 0)
			return max;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				int j = i - 1;
				int tmp = 0;
				// if(nums[i-1]>0)dp[i]=dp[i-1]+nums[i];else dp[i]=nums[i];
				while (j >= 0 && nums[j] < 0) {
					tmp = tmp + nums[j];
					j--;
				}
				if (j == -1)
					dp[i] = nums[i];
				else {

					// int tmp=max(max(dp[j],dp[j]+tmp+nums[i]),nums[i]);
					if (dp[j] + tmp + nums[i] > dp[j]) {
						if (dp[j] + tmp + nums[i] > nums[i]) {
							dp[i] = dp[j] + tmp + nums[i];
						} else {
							dp[i] = nums[i];
						}

					} else {
						dp[i] = nums[i];
					}
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	// 最长回文序列
	public void maxHuiwen() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s1 = scanner.nextLine();
			String s2 = new StringBuilder(s1).reverse().toString();
			char[] a = s1.toCharArray();
			char[] b = s2.toCharArray();
			int[][] dp = new int[a.length + 1][b.length + 1];
			int max = 0;
			for (int i = 1; i <= a.length; i++) {
				for (int j = 1; j <= b.length; j++) {
					if (a[i - 1] == b[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = 0;
					}
					if (dp[i][j] > max) {
						max = dp[i][j];
					}
				}
			}
			System.out.println(max);
		}
	}

	public void subChinese() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			int n = scanner.nextInt();
			scanner.nextLine();
			int count = 0;
			int i = 0;
			for (i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if ((int) ch > 128) {
					count += 2;
				} else {
					count++;
				}
				if (count >= n) {
					System.out.print(ch);
					break;
				} else {
					System.out.print(ch);
				}
			}

			System.out.println();
		}
	}

	public void readEnglish() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long n = scanner.nextLong();
			if (n > 10000000000l) {

			}
		}
	}

	public void fama() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] weight = new int[n];
			int[] num = new int[n];
			for (int i = 0; i < num.length; i++) {
				weight[i] = scanner.nextInt();

			}
			for (int i = 0; i < num.length; i++) {
				num[i] = scanner.nextInt();
			}
			int numTotal = 0;
			for (int i = 0; i < num.length; i++) {
				numTotal += num[i];
			}

			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			ArrayList<HashSet<Integer>> list2 = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				for (int j = 0; j < num[i]; j++) {
					tmp.add(weight[i] * (j + 1));
				}
				list.add(tmp);
			}
			list2.add(new HashSet<>(list.get(0)));
			for (int i = 1; i < n; i++) {
				HashSet<Integer> tmp = new HashSet<>();
				for (int j = 0; j < list.get(i).size(); j++) {
					for (int k = 0; k < list2.get(i - 1).size(); k++) {
						tmp.add(list.get(i).get(j) + list.get(i - 1).get(k));
					}
				}
				list2.add(tmp);
			}

			int a = 2;

			// int total=0;
			// for(int i=0;i<n;i++){
			// total+=num[i];
			// }
			// int all[]=new int[total];
			// int k=0;
			// for (int i = 0; i < n; i++) {
			// for (int j = 0; j < weight[i]; j++) {
			// all[k++]=weight[i];
			// }
			// }
			// for (int i = 0; i < all.length; i++) {
			// for (int j = 0; j < all.length; j++) {
			// if
			// }
			// }
		}
	}

	public int famaReal(int[] weight, int[] num, int i, int j) {
		if (i == 1 && j == 1) {
			return 1;
		}
		return 0;
	}

	ArrayList<Long> listGet = new ArrayList<>();
	long numm;
	HashSet<Long> set = new HashSet<>();

	// 质数因子
	public void getResult() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			numm = scanner.nextLong();

			getResultReal(numm);
			for (int i = 0; i < listGet.size(); i++) {
				System.out.println(listGet.get(i) + " ");
			}
			System.out.println();
		}
	}

	private void getResultReal(long data) {

		if (data < 2) {
			return;
		}
		long i;
		for (i = 2; i <= data;) {
			if (data % i == 0) {
				listGet.add(new Long(i));
				data = data / i;
			} else {
				i++;
			}

		}
		// getResultReal(data/i);

	}

	private boolean issusu(long data) {
		if (set.contains(new Long(data))) {
			return true;
		}
		for (long i = 2; i < data; i++) {
			if (data % i == 0) {

				return false;
			}
		}
		set.add(new Long(data));
		return true;
	}

	public int FirstNotRepeatingChar(String str) {
		int[] data = new int[26];

		for (int i = 0; i < str.length(); i++) {
			int pos = (int) str.charAt(i) - 'a';
			if (data[pos] == 0) {
				data[pos] = i + 1;
			} else {
				data[pos] = -1;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > 0 && data[i] < min) {
				min = data[i];
			}
		}
		return min - 1;
	}

	public void checkNetSegment() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String mask = scanner.nextLine();
			String ip1 = scanner.nextLine();
			String ip2 = scanner.nextLine();
			String[] data1 = ip1.split("\\.");
			String[] data2 = ip2.split("\\.");
			String[] dataMask = mask.split("\\.");
			if (data1.length != 4 || data2.length != 4 || dataMask.length != 4) {
				System.out.println(1);
				return;
			}
			for (int i = 0; i < dataMask.length; i++) {
				if (Integer.parseInt(data1[i]) > 255 || Integer.parseInt(data2[i]) > 255) {
					System.out.println(1);
					return;
				}
			}
			for (int i = 0; i < dataMask.length; i++) {

				int t1 = Integer.parseInt(data1[i]) & Integer.parseInt(dataMask[i]);
				int t2 = Integer.parseInt(data2[i]) & Integer.parseInt(dataMask[i]);

				if (t1 != t2) {
					System.out.println(2);
					return;
				}
			}
			System.out.println(1);
			return;
		}
	}

	public void oderAsc() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			char[] data = s.toCharArray();
			for (int i = 0; i < data.length; i++) {
				for (int j = 1; j < data.length - i; j++) {
					if (data[j - 1] > data[j]) {
						char t = data[j - 1];
						data[j - 1] = data[j];
						data[j] = t;
					}
				}
			}
			System.out.println(new String(data));
		}
	}

	public void netAddToInt() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			String[] data = s.split("\\.");
			StringBuilder sb = new StringBuilder();
			int num = 0;
			for (int i = 0; i < data.length; i++) {
				num = (int) (num + Integer.parseInt(data[i]) * Math.pow(2, 32 - 8 * (i + 1)));
			}

			s = scanner.nextLine();
			int val = Integer.parseInt(s);
			int[] re = new int[4];

			for (int i = 0; i < 4; i++) {
				re[i] = (int) (val / Math.pow(2, 32 - 8 * (i + 1)));
				val = (int) (val % Math.pow(2, 32 - 8 * (i + 1)));
			}
			System.out.println(num);
			for (int i = 0; i < re.length - 1; i++) {
				System.out.print(re[i] + ".");
			}

			System.out.println(re[re.length - 1]);
		}
	}

	public void longestChildStr() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			int[] dp = new int[s.length()];
		}
	}

	public void entryCt() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			StringBuilder sb = new StringBuilder();
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < 26; i++) {
				if (i < 3)
					map.put((char) ('a' + i), 2);
				else if (i < 6)
					map.put((char) ('a' + i), 3);
				else if (i < 9)
					map.put((char) ('a' + i), 4);
				else if (i < 12)
					map.put((char) ('a' + i), 5);
				else if (i < 15)
					map.put((char) ('a' + i), 6);
				else if (i < 19)
					map.put((char) ('a' + i), 7);
				else if (i < 22)
					map.put((char) ('a' + i), 8);
				else if (i < 26)
					map.put((char) ('a' + i), 9);
			}
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				switch (checkType(ch)) {
				case 0:
					sb.append(map.get(new Character(ch)));
					break;

				case 1:
					if (ch != 'Z') {
						sb.append((char) ((int) Character.toLowerCase(ch) + 1));
					} else {
						sb.append('a');
					}

					break;

				case 2:
					sb.append(ch);
					break;
				default:
					break;
				}
			}
			System.out.println(sb.toString());
		}
	}

	private int checkType(Character c) {
		if (c >= 'a' && c <= 'z') {
			return 0;
		} else if (c >= 'A' && c <= 'Z') {
			return 1;
		} else {
			return 2;
		}
	}

	public void reOrderString() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();

			Character[] chs = new Character[s.length()];
			for (int i = 0; i < s.length(); i++) {
				chs[i] = s.charAt(i);
			}
			int n = s.length();
			int step = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n - i; j++) {
					if (Character.toLowerCase(chs[j - 1]) > Character.toLowerCase(chs[j])) {
						swap(chs, j, j - 1);
					}
				}
			}
			List<Character> list = new ArrayList<>(Arrays.asList(chs));

			List<Character> list2 = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (isChar(list.get(i))) {
					list2.add(list.get(i));
				}
			}

			for (int i = 0; i < s.length(); i++) {
				if (!isChar(s.charAt(i))) {
					list2.add(i, s.charAt(i));
				}
			}
			for (int i = 0; i < list2.size(); i++) {
				System.out.print(list2.get(i));
			}
			System.out.println();
		}

	}

	public boolean isChar(char a) {
		if (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z') {
			return true;
		} else {
			return false;
		}
	}

	public void swap(Character[] data, int a, int b) {
		char t = data[a];
		data[a] = data[b];
		data[b] = t;
	}

	public void removeLeast() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			int[] tmp = new int[26];
			for (int i = 0; i < s.length(); i++) {
				tmp[(int) (s.charAt(i) - 'a')]++;
			}
			int minIdx = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i] != 0 && tmp[i] < min) {
					minIdx = i;
					min = tmp[i];
				}
			}
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i] == min) {
					tmp[i] = 0;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (tmp[(int) (s.charAt(i) - 'a')] != 0) {
					sb.append(s.charAt(i));
				}
			}
			System.out.println(sb.toString());

		}
	}

	public void passwdVerify() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			if (s.length() < 8)
				System.out.println("NG");
		}
	}

	// 识别有效IP地址和掩码并进行分类统计
	public void verifyIP() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		while (scanner.hasNext()) {
			list.add(scanner.nextLine());
		}
		Integer dInteger;
	}

	// 坐标移动
	public void movePoint() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			String[] ds = data.split(";");
			int x = 0;
			int y = 0;
			for (int i = 0; i < ds.length; i++) {
				if (!ds[i].equals("") && movePointVerify(ds[i])) {
					char[] chs = ds[i].toCharArray();
					int t = Integer.parseInt(ds[i].substring(1, ds[i].length()));
					switch (chs[0]) {
					case 'A':
						x = x - t;
						break;

					case 'D':
						x = x + t;
						break;
					case 'W':
						y = y + t;
						break;
					case 'S':
						y = y - t;
						break;
					default:
						break;
					}
				}
			}
			System.out.println(x + "," + y);

		}
	}

	public boolean movePointVerify(String data) {
		// System.out.println(data);
		char[] chs = data.toCharArray();
		Character[] preDef = { 'A', 'D', 'W', 'S' };
		List<Character> preList = Arrays.asList('A', 'D', 'W', 'S');
		if (chs.length > 3) {
			return false;
		}
		if (!preList.contains(chs[0]))
			return false;
		for (int i = 1; i < chs.length; i++) {
			if (chs[i] > '9' || chs[i] < '0') {
				return false;
			}
		}
		return true;
	}

	// 字符串字典排序
	public void sortString() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {

			int n = scanner.nextInt();
			scanner.nextLine();
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(scanner.nextLine());
			}
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n - i; j++) {
					if (list.get(j).compareTo(list.get(j - 1)) < 0) {
						String t = list.get(j - 1);
						list.set(j - 1, list.get(j));
						list.set(j, t);
					}
				}
			}
			for (String string : list) {
				System.out.println(string);
			}

		}
	}

	// 句子逆序
	public String reverse(String sentence) {
		String data = sentence;
		String[] ds = data.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int k = ds.length - 1; k > 0; k--) {
			sb.append(ds[k] + " ");
		}
		sb.append(ds[0]);
		return sb.toString();

	}

	// 句子逆序
	public void backSentense() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			String[] ds = data.split(" ");
			for (int k = ds.length - 1; k >= 0; k--) {
				System.out.print(ds[k] + " ");
			}
			System.out.println();
		}

	}

	// 字符个数统计
	public void calCharacterNum() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			int num = 0;
			char[] ds = data.toCharArray();
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < ds.length; i++) {
				int tmp = (int) ds[i];
				if (tmp >= 0 && tmp <= 127) {
					set.add(ds[i]);
				}
			}

			System.out.println(set.size());
		}
	}

	// 提取不重复的正数
	public void noRepetInt() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			Integer data = scanner.nextInt();
			Integer result = 0;
			int index = 0;
			Set<Integer> set = new HashSet<>();
			while (data != 0) {
				int num = data % 10;
				if (!set.contains(num)) {
					set.add(num);
					result = (int) (result + num * Math.pow(10, index));
					index++;
				}
				data = data / 10;
			}
			char[] ds = result.toString().toCharArray();
			int low = 0;
			int high = ds.length - 1;
			while (low < high) {
				char tmp = ds[low];
				ds[low] = ds[high];
				ds[high] = tmp;
				low++;
				high--;
			}
			String t = new String(ds);
			result = Integer.parseInt(t);
			System.out.println(result);
		}
	}

	public void sortTable() {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Integer> map = new TreeMap<>();
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {

				int key = scanner.nextInt();
				int value = scanner.nextInt();
				if (!map.containsKey(key)) {
					map.put(key, value);
				} else {
					map.put(key, map.get(key) + value);
				}
			}
			Set<Entry<Integer, Integer>> set = map.entrySet();
			Iterator<Entry<Integer, Integer>> it = set.iterator();
			for (Entry<Integer, Integer> entry : set) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}

	public void mingmingRandom() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("resource/mingmingRandom.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = scanner.nextInt();
		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int data = scanner.nextInt();
			set.add(data);

		}
		Object[] data = set.toArray();
		n = data.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if ((int) data[j] < (int) data[j - 1]) {
					swap(data, j, j - 1);
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		scanner.close();

	}

	// 明明的随机数
	public void mingmingRandom2() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("resource/mingmingRandom.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int data = scanner.nextInt();
				if (!map.containsKey(data)) {
					map.put(data, 1);
				} else {
					map.put(data, map.get(data) + 1);
				}
			}

			Set<Entry<Integer, Integer>> entries = map.entrySet();
			Iterator<Entry<Integer, Integer>> it = entries.iterator();
			Integer[] ct = new Integer[entries.size()];
			Integer[] data = new Integer[entries.size()];
			int index = 0;
			while (it.hasNext()) {
				Map.Entry<java.lang.Integer, java.lang.Integer> entry = (Map.Entry<java.lang.Integer, java.lang.Integer>) it
						.next();
				data[index] = entry.getKey();
				ct[index] = entry.getValue();
				index++;
			}
			n = data.length;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n - i; j++) {
					if (ct[j] > ct[j - 1]) {
						swap(ct, j, j - 1);
						swap(data, j, j - 1);
					}
				}
			}

			for (int i = 0; i < ct.length; i++) {
				System.out.println(data[i]);
			}
		}

		scanner.close();
	}

	public void swap(Object[] data, int a, int b) {
		Object t = data[a];
		data[a] = data[b];
		data[b] = t;
	}

	public void calCharNum() {
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		Character ch = scanner.nextLine().toCharArray()[0];
		int count = 0;
		for (int i = 0; i < data.length(); i++) {
			Character ch2 = data.charAt(i);
			if (Character.toLowerCase(ch) == Character.toLowerCase(ch2)) {

				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}

	public void lengthOfLastString() {
		Scanner scanner = new Scanner(System.in);
		// String data=scanner.nextLine();
		String data = "agdsg sdg";
		String[] da = data.split(" ");
		System.out.println(da[da.length - 1].length());
	}

	public static int count(int m, int n) {

		return 0;
	}

	public void stringBack() {
		Scanner scanner = new Scanner(System.in);
		// String data=scanner.nextLine();
		String data = "agagd";
		for (int i = 0; i < data.length(); i++) {
			System.out.print(data.charAt(data.length() - i - 1));
		}
	}

	public void intBack() {
		Scanner scanner = new Scanner(System.in);
		// Integer data=scanner.nextInt();
		Integer data = 783;
		while (data != 0) {
			System.out.print(data % 10);
			data = data / 10;
		}
	}

	public void likeValue() {
		Scanner scanner = new Scanner(System.in);
		// float data=scanner.nextFloat();
		float data = 7.5f;
		float tmp = (int) data;
		float result;
		if (data - tmp >= 0.5f) {
			result = tmp + 1;
		} else {
			result = tmp;
		}

		System.out.println((int) result);
	}

	public void numberOfOne() {
		Scanner scanner = new Scanner(System.in);
		// Integer data=scanner.nextInt();
		Integer data = 7;
		int count = 0;
		while (data != 0) {
			int tmp = data % 2;
			if (tmp == 1) {
				count++;
			}
			data = data >> 1;
		}

		System.out.println(count);
	}

	public void print(Object o) {
		System.out.println(o);
	}
}

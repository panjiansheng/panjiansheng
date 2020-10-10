import java.util.*;

import java.lang.*;

public class Main16 {
	public static void main(String[] args) {
		Main16 main = new Main16();
		main.exec();
	}

	public void exec() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] data = new int[n];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < data.length; i++) {
				data[i] = scanner.nextInt();
				if (data[i] < min) {
					min = data[i];
				}
			}
			int[] q = new int[m];
			for (int i = 0; i < q.length; i++) {
				q[i] = scanner.nextInt();
			}
			for (int i = 0; i < data.length; i++) {
				data[i] = data[i] / min;
			}
			int count = 0;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < data.length; i++) {
				if (!map.containsKey(data[i])) {
					map.put(data[i], 1);
				} else {
					map.put(data[i], map.get(data[i]) + 1);
				}
			}
			List<Integer> list=new ArrayList<>();
			for (Integer t : map.keySet()) {
				int tmp=map.get(t);
				for (int i = 1; i <=tmp; i++) {
					list.add(t*i);
				}
			}
			int[] data2=new int[list.size()];
			for (int i = 0; i < data2.length; i++) {
				data2[i]=list.get(i);
			}
			for (int i = 0; i < m; i++) {
				if (q[i] % min != 0) {
					continue;
				}
				int k = q[i] / min;
				if (sumToK(data2, 0, k)) {
					count++;
				}
			}
			System.out.println(count);

		}
		scanner.close();
	}

	public boolean sumToK(int[] data, int start, int k) {
		if (k < 0) {
			return false;
		} else if (k == 0) {
			return true;
		} else {
			for (int i = start; i < data.length; i++) {
				boolean res = sumToK(data, i + 1, k - data[i]);
				if (res)
					return true;
			}
			return false;
		}
	}

}
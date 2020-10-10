import java.util.*;

import java.util.Scanner;

public class Main13 {
	public static void main(String[] args) {
		Main13 main=new Main13();
		main.exec();
	}
	
	public void exec() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			Set<Integer> set = new HashSet<>();
			int  cnt = 0,tmp = 0;

			set.add(tmp);
			for (int i = 0; i < n; i++) {
				tmp = tmp ^ data[i];
				if (set.contains(tmp)) {
					set.clear();
					cnt++;
				}
				set.add(tmp);
			}
			System.out.println(cnt);
		}
		scanner.close();
	}
}
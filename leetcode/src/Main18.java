import java.util.*;

public class Main18 {
	public static void main(String[] args) {

		Main18 main = new Main18();
		// System.out.println("12".substring(0, 2));
		main.exec();
	}

	public void exec() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			Set<List<String>> set = new HashSet<>();

			dfs(s, set, 0, new ArrayList<String>());
			List<List<String>> list = new ArrayList<>(set);
			List<String> res=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				List<String> tmp = list.get(i);
				
				String st = "";
				for (int j = 0; j < tmp.size(); j++) {
					int a = Integer.valueOf(tmp.get(j)) + 'a' - 1;
					st = st + (char) a;
				}
				res.add(st);

			}
			Collections.sort(res);
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i));
				if (i != list.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		scanner.close();
	}

	public void dfs(String s, Set<List<String>> result, int start, List<String> tmp) {
		if (start >= s.length()) {
			result.add(new ArrayList<>(tmp));
		}

		if (start + 2 <= s.length()) {
			for (int i = start; i < s.length(); i = i + 2) {
				String st2 = s.substring(start, start + 2);
				if (st2.compareTo("26") <= 0) {
					tmp.add(st2);
					dfs(s, result, start + 2, tmp);
					tmp.remove(tmp.size() - 1);
				}
			}
		}
		if (start + 1 <= s.length()) {
			for (int i = start; i < s.length(); i++) {
				String st1 = s.substring(start, start + 1);
				tmp.add(st1);
				dfs(s, result, start + 1, tmp);
				tmp.remove(tmp.size() - 1);
			}

		}

	}
}
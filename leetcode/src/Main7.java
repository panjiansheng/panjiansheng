import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main7 main=new Main7();
		main.exec();
	}

	public void exec() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String data = scanner.nextLine();
			String pattern = scanner.nextLine();
			//boolean res=test(data, pattern);
			pattern=pattern.replace("*", ".*");
			pattern=pattern.replace("?", ".?");
			boolean res= java.util.regex.Pattern.matches(pattern, data);
			if (res) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		scanner.close();
	}

	public boolean test(String data,String pattern) {
		int k=0;
		for (int i = 0; i < pattern.length(); i++) {
			char ch=pattern.charAt(i);

			if (ch=='*') {
				if (i<pattern.length()-1&&pattern.charAt(i+1)=='*') {
					continue;
				}
				if (i==pattern.length()-1) {
					return true;
				}
				while (data.charAt(k)!=pattern.charAt(i+1)) {
					
					k++;
					if (k>=data.length()) {
						return false;
					}
				}
				continue;
			}
			if (k>=data.length()) {
				return false;
			}
			if (ch=='?') {
				k++;
				continue;
			}
			if (ch!=data.charAt(k)) {
				return false;
			}
			k++;
		}
		if (k==data.length()) {
			return true;
		}else {
			return false;
		}
	}
}

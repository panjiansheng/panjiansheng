import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Main9 main=new Main9();
		main.exec();
	}
	
	public void exec() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = scanner.nextInt();
		}
		int K = scanner.nextInt();
		int length = 0;
		boolean flag=false;
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = 0; j + i < data.length; j++) {
				int sum = 0;
				for (int k = j; k <= j + i; k++) {
					sum += data[k];
				}
				if (sum % K == 0) {
					length = i;
					flag = true;
					break;
				}
			}
			if (flag)break;
		}
		if (flag){
			System.out.println(length + 1);
        }else{
			System.out.println(0);
        }
	}
}

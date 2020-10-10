import java.io.BufferedReader;
import java.util.*;

public class Main20 {
	public static void main(String[] args) {
		Main20 main = new Main20();
		main.exec();

	}

	public void exec() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			double[] data=new double[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextDouble();
			}
			Arrays.sort(data);
			int count=0;
			for (int i = 0; i < data.length; i++) {
				for (int j = i+1; j < data.length; j++) {
					for (int k = j+1; k < data.length; k++) {
						if (data[i]>=180) {
							count++;
						}else {
							if (data[j]>=180) {
								if (data[k]<data[i]+180)count++;
							}else if (data[k]<data[i]+180||data[k]>data[j]+180) {
								count++;
							}
						}

					}
				}
			}
			System.out.println(count);
		}
		scanner.close();
	}
}
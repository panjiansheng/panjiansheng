import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main=new Main();
		main.exec();
	}
	
	public void exec() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int x=scanner.nextInt()-1;
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			int minIndex=0;
			for (int i = 0; i < data.length; i++) {
				if (data[i]<minIndex) {
					minIndex=data[0];
				}
			}
			for (int i = 0; i < data.length; i++) {
				if (i<=minIndex) {
					data[i]=data[i]-data[minIndex];
				}
			}
			int count=0;
			while (true) {
				if (data[x]!=0) {
					data[x]--;
					count++;
					if (x!=0) {
						x=x-1;
					}else {
						x=n-1;
					}
				}else {
					break;
				}
			}
			data[x]=count;
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i]);
				if (i!=data.length-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}

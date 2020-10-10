import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main17 main=new Main17();
		main.exec2();
	}

	public void exec2() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			int low=-1;
			int high=-1;
			int flag=0;
			for (int i = 1; i < data.length-1; i++) {
				if (data[i]==data[i+1]) {
					low=i;
					high=i+1;
				}
				if (data[i-1]==data[i+1]) {
					low=i-1;
					high=i+1;
					flag=1;
				}
			}
			if (flag==0) {
				int sum=dfs(data, low, high);
				System.out.println(sum);
				continue;
			}else {
				int sum=data[low+1]+dfs(data, low, high);
				System.out.println(sum);
				continue;
			}

		}
		scanner.close();
	}
	
	

	
	public int dfs(int[] data,int i,int j) {
		int ii=i;
		int jj=j;
		if (i<=0||j>=data.length) {
			return 0;
		}
		int tmp=0;
		if (data[i]==data[j]) {
			tmp=2*data[i];
			return 2*data[i]+dfs(data, i-1, j+1);
		}
		int count1=0;
		int tmp1=0;
		while (i>=0&&j<data.length&&data[i]!=data[j]) {
			count1++;
			tmp1=tmp+2*data[i];
			i--;
		}
		i=ii;
		j=jj;
		int count2=0,tmp2=0;
		while (i>=0&&j<data.length&&data[i]!=data[j]) {
			count2++;
			tmp2+=2*data[j];
			j++;
			
		}
		if (count1<count2) {
			tmp= tmp1+2*data[j];
			return tmp1+2*data[j]+dfs(data, i-count1-1, j+1);
		}else {
			tmp=tmp2+2*data[i];
			return tmp2+2*data[i]+dfs(data, i-1, j+count2+1);
		}
		
		
	}
	
	public void exec() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String s=scanner.nextLine();
			String[] data=s.split("/");
			Stack<String> stack=new Stack<>();
			for (int i = 0; i < data.length; i++) {
				if (data[i].equals(".")||data[i].equals("")) {
					continue;
				}
				if (data[i].equals("..")) {
					if(!stack.empty())stack.pop();
				}else {
					stack.push(data[i]);
				}
				
			}
			System.out.print("/");

			for (int i = 0; i < stack.size(); i++) {
				System.out.print(stack.get(i));
				if(i!=stack.size()-1)System.out.print("/");
			}
			System.out.println();
		}
		scanner.close();
	}


}

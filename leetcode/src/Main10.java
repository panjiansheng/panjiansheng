import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE/(32)*4);
		Main10 main=new Main10();
		//main.exec();
		System.out.println(main.maxProfit(new int[]{1,4,2,7}));
	}
	
	String[] names;
	int[] parents;
	public void exec() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			Map<String,  String> map1=new TreeMap<>();
			names=new String[n];
			parents=new int[n];
			String file=null;
			scanner.nextLine();
			for (int i = 0; i < n; i++) {
				String string=scanner.nextLine();
				String[] s=string.split(" ");
				String name=s[0];
				int parent=Integer.parseInt(s[1]);
				names[i]=name;
				parents[i]=parent;
				if (parent==-1) {
					file=name;
					continue;
				}
				

			}
			System.out.println(map1.size());
			
			for (int i = 0; i < parents.length; i++) {

				if (names[i]==null) {
					names[i]="";
				}
			}
			//dfs(file, names,parents);
			for(int i=0;i<n;i++){
				
			}
		}
		scanner.close();
	}
	
	int depth=0;
    public  void print(int f){  
        for(int i=1; i<depth; i++) {  
            System.out.print("   ");  
        }  
        System.out.println("|--" + f);  
    } 
	
	public void dfs(int file,String[] names,int[] parents) {
		depth++;
		List<String> files=listFile(file, names, parents);
		if (files.size()!=0) {
			print(file);
			for(int i=0;i<files.size();i++){
				//dfs(files.get(i),  names, parents);
			}
		}
		depth--;
	}
	
	public List<String> listFile(int file,String[] names,int[] parents) {
		List<String> files=new ArrayList<>();
		for (int i = 0; i < parents.length; i++) {
			if (parents[i]==file) {
				files.add(names[i]);
			}
		}
		return files;
	}
	
	
	public void exec4() {
//		Scanner scanner=new Scanner(System.in);
//		while (scanner.hasNext()) {
//			int n=scanner.nextInt();
//			int m=scanner.nextInt();
//			int K=scanner.nextInt();
//			int L=scanner.nextInt();
//			int R=scanner.nextInt();
//			
//		}
//		scanner.close();
		lis();
	}
	
	
	

	
	// 最长增长子序列，最长非降子序列
	public void lis() {
		int[] data = { 5, 3, 4, 8, 6, 7 };
		int n = data.length;
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (data[j] <= data[i]) {
					dp[i] = max(dp[j] + 1, dp[i]);
				}
			}
		}

		for (int i : dp) {
			System.out.print(i+" ");
		}

		System.out.println("");
	}
	
	public int max(int a,int b) {
		return a>b?a:b;
	}
	

	
	
	
	public void exec2() {
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int m=scanner.nextInt();
			int[] data=new int[m];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			int[] bearsa=new int[n];
			int[] bearsb=new int[n];
			//TreeMap<Integer, Integer> map=new TreeMap<>();
			for (int i = 0; i < n; i++) {
				int key=scanner.nextInt();
				int val=scanner.nextInt();
				bearsa[i]=key;
				bearsb[i]=val;
				//map.put(key, val);
			}
			int a=1;
			a=a+1;
			while (true) {
				int bear=getMaxBear(bearsa, bearsb);
				if (bear==-1) {
					break;
				}
				int suger=getMaxSuger(data,bearsb[bear]);
				if (suger==0) {
					bearsa[bear]=-Math.abs(bearsa[bear]);
					continue;
				}
				
				bearsb[bear]=bearsb[bear]-suger>0?bearsb[bear]-suger:0;
				
			}
			
			for (int i = 0; i < n; i++) {
				System.out.println(bearsb[i]);
			}
		}
		scanner.close();
	}
	
	
	public int getMaxBear(int[] a,int[] b) {
		int maxIndex=0;
	
		for (int i = 0; i < a.length; i++) {
				if(a[i]>0&&a[i]>a[maxIndex]){
					maxIndex=i;
				}
			
		}
		if (a[maxIndex]<0) {
			return -1;
		}
		return maxIndex;
	}
	
	public int getMaxSuger(int[] data,int num) {
		int max=0;
		int index=-1;
		for (int i = 0; i < data.length; i++) {
			if (data[i]>max&&data[i]<=num) {
				max=data[i];
				index=i;
			}
		}
		if(index!=-1)data[index]=0;
		return max;
	}
	
    public int maxProfit(int[] prices) {
    	if (prices.length==0) {
			return 0;
		}
    	int maxIndex=1;
    	if (prices.length>=4) {
        	for (int i = 1; i <prices.length-2; i++) {
    			if (prices[i]>=prices[maxIndex]) {
    				maxIndex=i;
    			}
    		}
		}else {
			maxIndex=prices.length-1;
		}

    	int min=prices[0];
    	int profit1=0,profit2=0;
    	for (int i = 1; i <= maxIndex; i++) {
			if (prices[i]<min) {
				min=prices[i];
			}else {
				if (prices[i]-min>profit1) {
					profit1=prices[i]-min;
				}
			}
		}
    	if (maxIndex<prices.length-1) {
    		min=prices[maxIndex+1];
    		for (int i = maxIndex+1; i < prices.length; i++) {
				if (prices[i]<min) {
					min=prices[i];
				}else {
					if (prices[i]-min>profit2) {
						profit2=prices[i]-min;
					}
				}
			}
		}
    	return profit1+profit2;
        
    }

}

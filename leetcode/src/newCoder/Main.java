package newCoder;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.*;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

public class Main {

	boolean flag=false;
	int k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main newCoder=new Main();
//		//newCoder.moreThanHalf();
//		newCoder.mostSmallKNum();
////		newCoder.lcs();
//		newCoder.selectNSum();
//		newCoder.test2();
//		for (int i = 0; i < 100; i++) {
//			newCoder.test2();
//		}
		B b=new B();
		Integer x=new Integer(5);
		Integer y=5;
		System.out.println(x==y);
		newCoder.subsets(new int[]{1,3,5,4,2});
		

	}
	
	
	
	
	
	//subset
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<Integer>(), nums, 0);
	    System.out.println(list);
	    //Collections.sort();
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	    //Collections.sort(list);
	}
	
	public void test() {
		Long sum=0l;
		Long start=new Date().getTime();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum=sum+i;
		}
		Long end=new Date().getTime();
		System.out.println(end-start);
		
	}
	
	public void test2() {
		long sum=0l;
		Long start=new Date().getTime();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum=sum+i;
		}
		Long end=new Date().getTime();
		System.out.println(end-start);
		
	}
	
	
	public void selectNSum(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            for(int i=1;i<=n&&i<=m/2;i++){
                System.out.println(i+" "+(m-i));
            }
            System.out.println(m);
        }
        scanner.close();
	}
	
	
	
	public void Nsum(int n,int m){
		if (n==0) {
			return;
		}
		if (m>0) {
			
		}
	}
	
	
	
	
	
	public void moreThanHalf(){
		Scanner scanner=new Scanner(System.in);
		
		while (scanner.hasNext()) {
			Integer data[]=new Integer[100];
			String s=scanner.nextLine();
			String[] sa=s.split(" ");
			for(int i=0;i<sa.length;i++){
				data[i]=Integer.parseInt(sa[i]);
			}
			int index=sa.length;
			HashMap<Integer,Integer> map=new HashMap<>();
			for (int i = 0; i < index; i++) {
				if (!map.containsKey(data[i])) {
					map.put(data[i], 1);
				}else {
					map.put(data[i],map.get(data[i])+1);
				}
			}
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue()>=index/2) {
					System.out.println(entry.getKey());
				}
			}
		}

	}
	
	public void mostSmallKNum(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String[] sa=scanner.nextLine().split(" ");
			int[] data=new int[sa.length-1];
			for (int i = 0; i < data.length; i++) {
				data[i]=Integer.parseInt(sa[i]);
			}
			k=Integer.parseInt(sa[sa.length-1]);
			quickSort(data, 0, data.length-1);
			for (int i = 0; i < k-1; i++) {
				System.out.print(data[i]+" ");
			}
			System.out.println(data[k-1]);
			flag=false;
		}
		scanner.close();
	}
	
	

	
	public void quickSort(int[] data,int p,int r){
		
		if (p<r&&flag==false) {
			int low=p-1;
			int high,index;
			for(high=p;high<r;high++){
				if (data[high]<data[r]) {
					low++;
					swap(data, low, high);
				}
			}
			
			index=low+1 ;
			System.out.println(index);
			if (index==k) {
				flag=true;
				System.out.println("true");
			}
			swap(data, index, r);
			if (index>k) {
				quickSort(data, p, index-1);
			}else {
				quickSort(data, index+1, r);
			}
			
			
		}
	}
	
	
	public void lcs(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String data=scanner.nextLine();
			int[] dp=new int[data.length()];
			if(isNum(data, 0))	 {
				dp[0]=1;
			}else {
				dp[0]=0;
			}
			for (int i = 1; i < data.length(); i++) {
				if (isNum(data, i)) {
					if (dp[i-1]==0) {
						dp[i]=1;
					}else {
						dp[i]=dp[i-1]+1;
					}
				}else {
					dp[i]=0;
				}
			}
			
			int max=dp[0], index=0;
			for (int i = 0; i < dp.length; i++) {
				if (dp[i]>dp[index]) {
					max=dp[i];
					index=i;
				}
			}
			
			for (int i = index-max+1; i <=index; i++) {
				System.out.print(data.charAt(i));
			}
			System.out.println();
		}
	}
	
	public boolean isNum(String data,int i){
		if (data.charAt(i)>='0'&&data.charAt(i)<='9') return true;
		else {
			return false;
		}
	}
	
	public  void swap(int[] data,int a,int b){
		int t=data[a];
		data[a]=data[b];
		data[b]=t;
	}

}


class A{
	static int a=1;
	int b=2;
}

class B extends A{
	static int c=3;
	int d=4;
}

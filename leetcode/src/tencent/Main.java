package tencent;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main=new Main();
		main.exec();
	}

	public void exec(){
		Scanner scanner=new Scanner(System.in);
		int K=scanner.nextInt();
		int[] nums=new int[3];
		nums[0]=scanner.nextInt();
		nums[1]=scanner.nextInt();
		nums[2]=scanner.nextInt();
		int start=1;
		int end=(int)Math.pow(2, K)-1;
		while (start<end) {
			int mid=start+(end-start)/2;
			int checkRes=check(mid, nums);
			if (checkRes==0) {
				System.out.println(mid);
				scanner.close();
				return;
			}else if (checkRes==1) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		System.out.println((int)Math.pow(2, K)/2);
		scanner.close();
		return;
	}
	
	public int check(int mid,int[] nums) {
		int countSmaller=0;
		int countBigger=0;
		for(int i:nums){
			if (i<mid) {
				countSmaller++;
			}else if (i>mid) {
				countBigger++;
			}else {
				return 0;
			}
		}
		if (countSmaller==3) {
			return 2;
		}
		if (countBigger==3) {
			return 1;
		}
		return 0;
	}
}

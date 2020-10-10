package ali;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.net.ssl.SSLException;

public class Intern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long start=new Date().getTime();
		// long max=0;
		// for (long i = 0; i < 100000000l; i++) {
		// if (i>max) {
		// max=i;
		// }
		// }
		// System.out.println();
		// System.out.println(new Date().getTime()-start);
//		String s="123";
//		 System.out.print(s.substring(1-2+1,1+1));
//		 
		Intern intern = new Intern();
		//intern.Max();
		int[] data = new int[40000003];
		for (int i = 0; i < data.length; i++) {
			// data[i] = Math.abs((int) (Math.random() * 1000));
			data[i] = 10000000;
		}
		//
//		 data=new int[]{2,5,2,4,2,3,2};
//		data = new int[] { 2, 5, 3, 4, 4, 1, 1, 1, 3, -3, 7, 3, 6, 3, 7 };
		System.out.println(intern.partation(data));
	}

	public boolean partation(int[] A) {
		// print(data);

		// 预先遍历数组，记录各个位置从后往前和从前往后的累加和，以及负数和0出现的位置，时间复杂度o(n),low,lowMid,high,highMid四个指针往中间走，不会后退，根据累加和判断是否位于中间位置，时间复杂度o(n),空间复杂度o(n)

		if (A.length<7) {
			return false;
		}
		int n = A.length, low = 0, high = n - 1, lowMid = 3, highMid = n - 3;
		long [] preSum = new long[n];
		long [] backSum = new long[n];
		List<Integer> negPosRec = new ArrayList<>();
		preSum[0] = A[0];
		backSum[n - 1] = A[n - 1];
		for (int i = 1; i < n; i++) {
			preSum[i] = preSum[i - 1] + A[i];
			backSum[n - i - 1] = backSum[n - i] + A[n - i - 1];
			if (A[i] <= 0) {
				negPosRec.add(i);
				if (negPosRec.size()>3) {
					return false;
				}
			}
		}

		while (high - low >= 4) {

			if (A[low] <= 0 || A[high] <= 0) {
				break;
			}

			if (preSum[low] == backSum[high]) {
				if (A[low + 2] <= 0 || A[high - 2] <= 0) {
					low++;
					high--;
					continue;
				}
				if (lowMid < low + 3)
					lowMid = low + 3;
				if (highMid > high - 3)
					highMid = high - 3;
				while (lowMid <= highMid) {
					if (A[lowMid] <= 0 && lowMid != highMid
							&& checkNegtiveByRecords(A, negPosRec, lowMid, high - 1))
						break;
					if (A[highMid] <= 0 && lowMid != highMid
							&& checkNegtiveByRecords(A, negPosRec, low + 1, highMid))
						break;

					long leftMidSum = preSum[lowMid] - preSum[low + 1] - A[lowMid];
					long rightMidSum = backSum[highMid] - backSum[high - 1] - A[highMid];

					if (leftMidSum == preSum[low] && rightMidSum == backSum[high]) {
						if (lowMid == highMid) {
//							System.out.println(lowMid);
							return true;
						} else {
							break;
						}
					}
					if (leftMidSum > preSum[low] || rightMidSum > backSum[high]) {
						break;
					}
					if (leftMidSum < preSum[low]) {
						lowMid++;
					}
					if (rightMidSum < backSum[high]) {
						highMid--;
					}
				}
				low++;
				high--;

			} else if (preSum[low] > backSum[high]) {
				high--;
			} else if (preSum[low] < backSum[high]) {
				low++;
			}

		}

		return false;
		// print(preSum);
		// print(backSum);

	}

//    public void Max(){
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNext()){
//            String s=scanner.nextLine();
//            int[] dp=new int[s.length()];
//            dp[0]=isNum(s.charAt(0))?1:0;
//            int max=dp[0];
//            for(int i=1;i<s.length();i++){
//                char ch=s.charAt(i);
//                if(isNum(ch)){
//                    dp[i]=dp[i-1]+1;
//                    if(dp[i]>max)max=dp[i];
//                }else{
//                    dp[i]=0;
//                }
//            }
//            for(int i=0;i<dp.length;i++){
//                if(dp[i]==max){
//                    System.out.print(s.substring(i-max+1,i+1)+",");
//                }
//            }
//            System.out.println(max);
//        }
//    }
    
//    private static boolean isNum(char ch){
//        if(ch<='9'&&ch>='0'){
//            return true;
//        }
//        return false;
//    }
	
	private boolean checkNegtiveByRecords(int[] data, List<Integer> list, int from, int end) {
		for (Integer pos : list) {
			if (pos < end && pos > from) {
				return true;
			}
		}
		return false;
	}


}

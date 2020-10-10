package ali;

import java.util.Scanner;

public class Main {

    /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    private static int [] compute(int queueNums, int msgNums, int expandTime, int sendSpeed, int consumeSpeed, int targetTime) { 
    
    	int[] result=new int[queueNums];
    	int count=0;
//    	msgNums=msgNums+sendSpeed*targetTime;
    	if (targetTime<=expandTime) {
			for (int i = 0; i < result.length; i++) {
				result[i]=i;
				result[i]=targetTime*consumeSpeed;
			}
		}else {
			int time=(msgNums+sendSpeed*expandTime)/queueNums;
			 result=new int[queueNums*2];
			if (targetTime<time) {
				for (int i = 0; i < queueNums; i++) {
					result[i]=targetTime*consumeSpeed;
				}
				for (int i = queueNums; i < 2*queueNums; i++) {
					result[i]=0;
				}
			}else {
			}
		}
    	
       return result;
    }
    /******************************结束写代码******************************/

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int queueNums = in.nextInt(), msgNums = in.nextInt(), expandTime = in.nextInt();
//        in.nextLine();
//        int sendSpeed = in.nextInt(), consumeSpeed = in.nextInt();
//        in.nextLine();
//        int targetTime = in.nextInt();
//        in.close();

        int [] result = compute(2, 20, 5, 5,2, 5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(String.format("%d %d", i,  result[i]));
        }
    }
}
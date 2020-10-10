package ali;

import java.util.Date;
import java.util.Random;

import javax.net.ssl.SSLException;

public class Intern2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Intern2 intern=new Intern2();

        int[] data=new int[400003];
        for (int i = 0; i < data.length; i++) {
            data[i]=1;
        }

        intern.partation(data);
    }


    public boolean partation(int[] data){
    	if (data.length<7) {
			return false;
		}
        int n=data.length,low=0,high=n-1,mid=-1;
        int[] preSum=new int[n];
        int[] backSum= new int[n];
        preSum[0]=data[0];
        backSum[n-1]=data[n-1];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]+data[i];
            backSum[n-i-1]=backSum[n-i]+data[n-i-1];
        }
        while (high-low>=4) {

            if (preSum[low]==backSum[high]) {
                if(mid<low)mid=low+2;

                while (mid>=low+2&&mid<=high-2) {
                    int leftMidSum=preSum[mid]-preSum[low+1]-data[mid];

                    int rightMidSum=backSum[mid]-backSum[high-1]-data[mid];

                    if (leftMidSum>preSum[low]&&rightMidSum>backSum[high]) {
                        break;
                    }
                    int leftMidSumNext=preSum[mid+1]-data[mid+1]-preSum[low+1];
                    if (leftMidSum<preSum[low]&&leftMidSumNext>preSum[low]||leftMidSum>preSum[low]&&leftMidSumNext<preSum[low]) {
//                        low=1;
                        break;
                    }
                    int rightMidSumNext=backSum[mid-1]-data[mid-1]-backSum[high-1];
                    if (rightMidSum<backSum[high]&&(rightMidSumNext>backSum[high]||rightMidSum>backSum[high]&&(rightMidSumNext<backSum[high]))) {
                        break;
                    }

                    if(leftMidSum==preSum[low]){
                        if (leftMidSum==rightMidSum) {
                            return true;
                        }
                        break;
                    }else if (leftMidSum>preSum[low]) {
                        mid--;

                    }else if (leftMidSum<preSum[low]) {
                        mid++;
                    }
                }
                low++;
                high--;

            }else {
                if (preSum[low]>backSum[high]) {
                    high--;
                }else {
                    low++;
                }
            }

        }
        return false;

//        print(preSum);
//        print(backSum);

    }


//    public void print(int[] data){
//        for (int i : data) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//    }
}

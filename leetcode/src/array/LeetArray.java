package array;

public class LeetArray {

    public int firstMissingPositive(int[] nums) {
//    	int min=Integer.MAX_VALUE;
//    	int max=0;
//    	int count=0;
//    	int tmp=0;
//    	int sum=0;
//    	for (int num : nums) {
//    		if (num>0) {
//    			count++;
//    			tmp+=num;
//    			min=num<min?num:min;
//    			max=num>max?num:max;
//			}
//
//		}
//    	for(int i=min;i<=max;i++){
//    		sum=sum+i;
//    	}
//    	int diff=sum-tmp;
//		return sum-tmp;
    	if (nums==null) {
			return 1;
		}
    	if (nums.length==1) {
			if (nums[0]==1) {
				return 2;
			}else  {
				return 1;
			}
		}
    	int min1=Integer.MAX_VALUE;
    	int min2=Integer.MAX_VALUE;
    	int count=0;
    	for (int num : nums) {
    		if (num>0) {
    			count++;
    			if (num<min1) {
    				if (min2-min1>1) {
    					min2=min1;
    				}
    				min1=num;
    			}
			}


		}
    	if (min1==Integer.MAX_VALUE&&min2==Integer.MAX_VALUE) {
			return 1;
		}
    	if (nums.length==1) {
			if (min1==1) {
				return 2;
			}else {
				return min1-1;
			}
		}
    	if (min2==Integer.MAX_VALUE&&count==1) {
			if (min1==1) {
				return 2;
			}else {
				return min1-1;
			}
    	}
    	if (min2==Integer.MAX_VALUE) {
        	if (min1==1) {
    			
    		}
		}

    	return min2==Integer.MAX_VALUE?min1+2:min1+1;
        
    }
	
	
    public void print(String s){
    	System.out.println(s);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetArray leetArray=new LeetArray();
		System.out.println(leetArray.firstMissingPositive(new int[]{1,2,0}));
	}

}

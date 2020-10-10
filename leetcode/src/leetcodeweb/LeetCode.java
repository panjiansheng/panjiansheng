package leetcodeweb;

import java.util.*;

import org.omg.CORBA.SystemException;

public class LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("12".substring(0, 0));
		LeetCode leetCode = new LeetCode();
		// int data=leetCode.hammingDistance(1, 3);
		String[] data = { "Hello", "Alaska", "Dad", "Peace" };
		// System.out.println(leetCode.findWords(data));
		// System.out.println(leetCode.detectCapitalUse("FlaG"));
		// System.out.println(leetCode.missingNumber(new int[]{1}));
		// System.out.println(leetCode.addStrings("999", "9999"));
		// System.out.println(leetCode.toHex(-1));
		// System.out.println(leetCode.repeatedSubstringPattern("bb"));
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		// System.out.println(leetCode.plusOne(new int[]{1,0}));
		// System.out.println(leetCode.guessNumber(2126753390));
//		String s = "eklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmou";
//		String p = "yqrbgjdwtcaxzsnifvhmou";
//		System.out.println(leetCode.wordPattern("abba", "dog cat cat dog"));
//		System.out.println("ok");
		MyStack myStack=new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
//		System.out.println(myStack.top());
//		System.out.println(leetCode.twoSum(new int[]{3, 2,4},6));
//		System.out.println(leetCode.addBinary("1", "111"));
//		System.out.println(leetCode.longestCommonPrefix(new String[]{"abab","aba","abc"}));
//		System.out.println(leetCode.findRadius(new int[]{1,2,3,4,5}, new int[]{2}));
//		System.out.println(leetCode.mySqrt(2147483647));
//		System.out.println(leetCode.thirdMax2(new int[]{2,2,3,1}));
		System.out.println(leetCode.convertToTitle(26));
	}
	
    public void rotate(int[] nums, int k) {
        int low=0;
        int high=k;
        while(low<=high){
        	
        }
        low=0;
        high=k;
        while(low<=high){
            int t=nums[low];
            nums[low]=nums[high];
            nums[high]=t;
            low++;
            high--;
        }
    }
	
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            
            sb.insert(0,(char)((n-1)%26+'A'));
            n=(n-1)/26;
 
        }
        return sb.toString();
    }
	
    public boolean isPalindrome(String s) {
        if(s.equals(""))return true;
        int i=0;
        int j=s.length()-1;
        
            char ch1;
            char ch2;
        while(i<j){
            while(i<s.length()){
                ch1=s.toLowerCase().charAt(i);
                if(ch1>='a'&&ch1<='z'||ch1>='0'&&ch1<='9'){
                    break;
                }
                i++;
            }
            while(j>=0){
                ch2=s.toLowerCase().charAt(j);
                if(ch2>='a'&&ch2<='z'||ch2>='0'&&ch2<='9'){
                    break;
                }
                j--;
            }
            if(i==s.length()||j==-1)return false;
            ch1=s.toLowerCase().charAt(i);
               ch2=s.toLowerCase().charAt(j);
            if(ch1!=ch2){
                return false;
            }
            i++;j--;
        }
        return true;
    }
	
    public int thirdMax2(int[] nums) {
        if (nums.length<3) {
			return nums[0]>nums[1]?nums[0]:nums[1];
		}
        Integer max1=null,max2=null,max3=null;
        for(int i=0;i<nums.length;i++){
        	if (max1==null||nums[i]>max1) {
        		max3=max2;
        		max2=max1;
				max1=nums[i]; 
			}else if (max2==null||nums[i]>max2) {
				max3=max2;
				max2=nums[i];
				
			}else if (max3==null||nums[i]>max3) {
				max3=nums[i];
			}
        }
    	return max3==null?max1:max3;
    	
    }
    public int thirdMax(int[] nums) {
        if (nums.length<3) {
			return nums[0]>nums[1]?nums[0]:nums[1];
		}
        partition(nums, 0, nums.length-1);
        
        return result;
        
    }
    Integer result=null;
    
    private void partition(int[] nums,int p,int r){
    	if (p<=r) {
			int low=p-1;
			int high=p;
			for(;high<r;high++){
				if (nums[high]>nums[r]) {
					low++;
					swap(nums, low, high);
				}
			}
			int index=low+1;
			swap(nums, index, r);
			if (index==2) {
				result=nums[index];
			}
			if (index<2) {
				partition(nums, index+1, r);
			}else {
				partition(nums, p, index-1);
			}
    	}
    }
    
    public void swap(int[] nums,int a,int b){
    	int t=nums[a];
    	nums[a]=nums[b];
    	nums[b]=t;
    }
	
    public int mySqrt(int x) {
        int low=0;int high=x;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            long num=(long)mid*(long)mid;
            if(num==x)return mid;
            else if(num<x){
                low=mid+1;
            }else if(num>x){
            	if((long)(mid-1)*(long)(mid-1)<x)return mid-1;
                high=mid-1;
            }
        }
        return -1;
    }
    public int strStr(String h, String n) {
        if(h.equals(n))return 0;
        for(int i=0;i<h.length()-n.length()+1;i++){
            int j=0;
            for(;i+j<h.length()&&j<n.length();j++){
                if(h.charAt(i+j)!=n.charAt(j)){
                    break;
                }
            }
            if(j==n.length())return i;
        }
        return -1;
    }
	
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int k=0;
        int i=0;
        while(i<32){
            int tmp=n&1;
            n=n>>1;
            k=(k<<1)+tmp;
            i++;
        }
        return k;
    }
    public int findRadius(int[] houses, int[] heaters) {
        int start=heaters[0];
        int end=heaters[heaters.length-1];
        int maxM=Integer.MIN_VALUE;
        for (int i = 0; i < heaters.length; i++) {
			houses[heaters[i]-1]=-houses[heaters[i]-1];
		}
        int pre=0;
        for (int i = 0; i < houses.length; i++) {
			if (houses[i]<0) {
				if (maxM<i-pre) {
					maxM=i-pre;
				}
				pre=i;
			}
		}
        maxM=Math.max(Math.max(maxM/2, start-1),houses.length-end);
        return maxM;
    }
	
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String com=strs[0];
        String comNow="";
        for (int i = 1; i < strs.length; i++) {
        	for (int j = 0; j <= strs[i].length()&&j<=com.length(); j++) {
				if (strs[i].substring(0, j).equals(com.substring(0, j))) {
					if (comNow.equals("")||comNow.length()<j) {
						comNow=strs[i].substring(0,j);
					}
				}
			}
        	if (com.equals("")||com.length()>comNow.length()) {
				com=comNow;
				
			}
        	comNow="";
		}
        return com;
    }
	
    public String addBinary(String a, String b) {
        if (a.equals("")||b.equals("")) {
			return a.length()>=b.length()?a:b;
		}
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int re;
        int boot=0;
        while (i>=0&&j>=0) {
			re=addChar(a.charAt(i), b.charAt(j),boot);
			boot=re/2;
			sb.insert(0, re%2);
			i--;
			j--;
		}
        while (i>=0) {
			re=a.charAt(i)-'0'+boot;
			boot=re/2;
			sb.insert(0, re%2);
			i--;
		}
        while (j>=0) {
			re=b.charAt(j)-'0'+boot;
			boot=re/2;
			sb.insert(0, re%2);
			j--;
		}
        if (boot==1) {
			sb.insert(0, 1);
		}
        return sb.toString();
        
    }
    
    public int addChar(char a,char b,int c){
    	int i=a-'0';
    	int j=b-'0';
    	return i+j+c;
    }
	
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])&&!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                Integer idx=map.get(target-nums[i]);
                if(idx!=null){
                    return new int[]{idx,i};
                }
            }
        }
        return null;
    }
	
	static class MyStack{
		 Queue<Integer> queue1=new ArrayDeque<>();
		 Queue<Integer> queue2=new ArrayDeque<>();
		 public MyStack(){}
		 public void push(int x){
			 queue1.add(x);
		 }
		 
		 
		 public int pop(){
			 if (queue2.isEmpty()) {
				for (int i = 0; i < queue1.size()-1; i++) {
					queue2.add(queue1.poll());
				}
			}
			 for (int i = 0; i < queue2.size(); i++) {
				queue1.add(queue2.poll());
			}
			 return queue1.poll();
		 }
		 
		 public int top() {
		     int n;
			 if (queue2.isEmpty()) {
			      n=queue1.size();
				for (int i = 0; i < queue1.size()-1; i++) {
					queue2.add(queue1.poll());
				}
			}
			 n=queue2.size();
			for (int i = 0; i < queue2.size(); i++) {
				queue1.add(queue2.poll());
			}
			 Integer j=queue1.poll();
			 if(j!=null)
			 queue2.add(j);
			 return j;
		}
		 
		 public boolean empty() {
				return queue1.isEmpty()&&queue2.isEmpty();
		}
	}
	
    public boolean wordPattern(String pattern, String str) {
        String[] data=str.split(" ");
       
        list.set(1000, new ArrayList<Integer>());
        Map<Character, String> map=new HashMap<>();
        if(pattern.length()<data.length)return false; 
        for (int i = 0; i < data.length; i++) {
        	Character ch=pattern.charAt(i);
        	if (!map.containsKey(ch)) {
				if (map.containsValue(data[i])) {
					return false;
				}
				map.put(ch, data[i]);

			}else {
				if (map.get(ch).equals(data[i])) {
					return false;
				}
			}
        }
        return true;
    }

	public List<Integer> findAnagrams(String s, String p) {
		int n = p.length();
		int[] map = new int[26];
		int[] map2 = new int[26];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < p.length(); i++) {
			map2[p.charAt(i) - 'a']++;
		}
		for (int i = 0; i <= s.length() - p.length(); i++) {
			for (int j = i; j < n + i; j++) {
				map[s.charAt(j) - 'a']++;
			}

			boolean flag = true;
			for (int k = 0; k < 26; k++) {
				if (map[k] != map2[k])
					flag = false;
				map[k]=0;
			}
			if (flag) {
				list.add(new Integer(i));
			}
		}
		return list;
	}

	public int guessNumber(int n) {
		System.out.println(n);
		int low = 0;
		int high = n;
		long mid = -1;
		int tmp;
		while (low <= high) {
			mid = (low + high) / 2;
			tmp = guess(mid);
			if (tmp == 0)
				return (int) mid;
			else if (tmp > 0)
				low = (int) mid + 1;
			else if (tmp < 0)
				high = (int) mid - 1;
		}
		return -1;
	}

	private int guess(long n) {
		return (int) (1702766719 - n);
	}

	int level = 0;
	List<List<Integer>> list = new LinkedList<>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return list;
		}
		if (list.size() <= level) {
			List<Integer> tmp = new LinkedList<>();
			tmp.add(new Integer(root.val));
			list.add(tmp);
		} else {
			list.get(level).add(new Integer(root.val));
		}
		level++;
		levelOrderBottom(root.left);
		levelOrderBottom(root.right);
		level--;
		if (level == 0) {
			int low = 0;
			int high = list.size() - 1;
			while (low < high) {
				List<Integer> tmp = list.get(low);
				list.set(low, list.get(high));
				list.set(high, tmp);
			}

		}
		return list;

	}

	public int[] plusOne(int[] digits) {
		LinkedList<Integer> list = new LinkedList<>();
		int tmp = 1;
		for (int i = digits.length - 1; i >= 0; i--) {

			list.addFirst(new Integer((digits[i] + tmp) % 10));
			tmp = (digits[i] + tmp) / 10;
		}

		if (tmp == 1)
			list.addFirst(new Integer(1));
		int[] re = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			re[i] = list.get(i);
		}
		return re;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isUgly(int num) {
		int[] factor = new int[] { 2, 3, 5 };
		for (int i = 0; i < 3; i++) {
			while (num % factor[i] == 0) {
				num = num / factor[i];
			}
		}
		return num == 1;
	}

	public boolean repeatedSubstringPattern(String s) {
		int[] pos = new int[s.length()];
		String[] data = new String[s.length()];

		for (int i = 0; i < pos.length; i++) {
			data[i] = s.substring(i);
		}
		Arrays.sort(data);
		for (int i = 0; i < data.length - 1; i++) {
			if (strcmp(data[i], data[i + 1]) > 1) {
				return true;
			}
		}
		return false;

	}

	public int strcmp(String s1, String s2) {
		int k = 0;
		for (k = 0; k < s1.length() && k < s2.length(); k++) {
			if (s1.charAt(k) != s2.charAt(k)) {
				break;
			}

		}
		return k;
	}

	public String toHex(int num) {
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			int tmp = (num) % 16;
			if (tmp < 0) {
				tmp = tmp + 16;
			}
			switch (tmp) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9: {
				sb.append(tmp);
				break;
			}
			default:
				sb.append((char) (tmp - 10 + 'a'));
				break;

			}
			num = num >>> 4;
		}
		return sb.reverse().toString();

	}

	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		boolean flag = false;

		for (; i >= 0 && j >= 0; i--, j--) {
			int c;
			if (flag == true) {
				c = (int) (num1.charAt(i) - '0') + (int) (num2.charAt(i) - '0') + 1;
				flag = false;
			} else {
				c = (int) (num1.charAt(i) - '0') + (int) (num2.charAt(i) - '0');
			}
			if (c > 10) {
				flag = true;
				c = c - 10;
			}
			sb.insert(0, String.valueOf(c));
			// flag=false;

		}
		if (i == -1 && j != -1) {
			int c;
			if (flag) {
				c = (int) num2.charAt(j--) - '0' + 1;
				flag = false;
				if (c > 10) {
					c = c - 10;
					sb.insert(0, c);
					flag = true;
				} else {
					sb.insert(0, c);
				}

			} else {
				sb.insert(0, num2.charAt(j--) - '0');
			}
		} else if (j == -1 && i != -1) {
			int c;
			if (flag) {
				c = (int) num1.charAt(j--) - '0' + 1;
				flag = false;
				if (c > 10) {
					c = c - 10;
					sb.insert(0, c);
					flag = true;
				} else {
					sb.insert(0, c);
				}
			} else {
				sb.insert(0, num1.charAt(i--) - '0');
			}
		} else {
			if (flag)
				sb.insert(0, 1);
		}

		return sb.toString();

	}

	public int missingNumber(int[] nums) {
		int n = nums.length;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (Math.abs(nums[i]) != 0) {
				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
			} else {
				flag = true;
			}
		}
		if (flag == false) {
			return 0;
		}
		int index = 0, i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
			if (nums[i] == 0) {
				index = i + 1;
			}
		}
		return index;

	}

	public boolean detectCapitalUse(String word) {
		char ch = word.charAt(word.length() - 1);
		int n = word.length();
		if (ch >= 'A' && ch <= 'Z') {
			for (int i = n - 1; i >= 0; i--) {
				ch = word.charAt(i);
				if (ch >= 'a' && ch <= 'z') {
					return false;
				}
				return true;
			}
		}
		if (ch >= 'a' && ch <= 'z') {
			for (int i = n - 1; i >= 0; i--) {
				ch = word.charAt(i);
				if (ch >= 'A' && ch <= 'Z') {
					if (i != 0)
						return false;
				}
				return true;
			}
		}
		return true;
	}

	// 500. Keyboard Row
	public String[] findWords(String[] words) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
		String a = "qwertyuiop";
		String b = "lkjhgfdsa";
		String c = "zxcvbnm";
		ArrayList<String> result = new ArrayList<>();
		boolean flag = true;
		for (int i = 0; i < words.length; i++) {
			if (a.indexOf(words[i].toLowerCase().charAt(0)) != -1) {
				for (int j = 1; j < words[i].toLowerCase().length(); j++) {
					if (a.indexOf(words[i].toLowerCase().charAt(j)) == -1) {
						flag = false;
						break;
					}

				}
				if (flag) {
					result.add(words[i]);
					flag = true;
				}
				flag = true;
				continue;
			}
			if (b.indexOf(words[i].toLowerCase().charAt(0)) != -1) {
				for (int j = 1; j < words[i].toLowerCase().length(); j++) {
					if (b.indexOf(words[i].toLowerCase().charAt(j)) == -1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					result.add(words[i]);
					flag = true;
				}
				flag = true;
				continue;
			}
			if (c.indexOf(words[i].toLowerCase().charAt(0)) != -1) {
				for (int j = 1; j < words[i].toLowerCase().length(); j++) {
					if (c.indexOf(words[i].toLowerCase().charAt(j)) == -1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					result.add(words[i]);
					flag = true;
				}
				flag = true;
				continue;
			}

		}
		String[] t = new String[result.size()];
		return result.toArray(t);
	}

	// 461 Hamming Distance
	public int hammingDistance(int x, int y) {

		int z = x ^ y;

		int count = 0;
		for (int i = 0; i < 31; i++) {

			if ((z & 1) == 1) {
				count++;
			}
			z = z >>> 1;
		}

		return count;

	}
}

package leetstack;

import java.util.ArrayList;
import java.util.Stack;

public class LeetStack {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int t1;
		int t2;
		for (String s : tokens) {
			switch (s) {
			case "+":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 + t2);
				break;
			case "-":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 - t2);
				break;
			case "*":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 * t2);
				break;
			case "/":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1 / t2);
				break;
			default:
				stack.push(Integer.parseInt(s));
				break;
			}
		}
		return stack.pop();

	}

	public int largestRectangleArea(int[] height) {
		if (height.length == 0) {
			return 0;
		}
		if (height.length == 1) {
			return height[0];
		}

		Stack<Integer> stack = new Stack<>();
		int max = 0;

		for (int i = 0; i < height.length; i++) {
			int count = 1;
			for (int j = i + 1; j < height.length; j++) {
				if (height[j] >= height[i]) {
					count++;
				} else {
					break;
				}
			}
			int j = i - 1;
			while (j >= 0) {
				if (height[j] >= height[i]) {
					count++;
				} else {
					break;
				}
				j--;
			}
			if (count * height[i] > max) {
				max = count * height[i];
			}
		}
		return max;

	}
	
    public int trap(int[] heights) {

        int n=heights.length;
        int maxhigh=0;
        int left=0,right=0;
        for(int i=0;i<n;i++)//找到最大值的下标
        {
            if(heights[i]>heights[maxhigh])
                maxhigh=i;
        }
        int sum=0;
        for(int i=0;i<maxhigh;i++)//计算左边的容量
        {
            if(heights[i]<left)
               sum+=(left-heights[i]);
            else
               left=heights[i];
        }
         
        for(int j=n-1;j>maxhigh;j--)//计算右边的容量
        {
            if(heights[j]<right)
               sum+=(right-heights[j]);
            else
               right=heights[j];
        }
        return sum;
        
    }

	public int longestValidParentheses(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			stack.push(tmp);
		}
		int count = 0;
		int countMax=0;
		while (!stack.isEmpty()) {
			Character char1 = stack.pop();
			if (char1.equals( ')')) {
				
				while(!stack.isEmpty()){
					Character character=stack.pop();
					
				}
				if (!stack.isEmpty()) {
					Character char2 = stack.pop();
					if (!(char2.equals( '('))) {
						count = 0;
						stack.push(char2);
					} else {
						count = count + 2;
						stack.push(char2);
					}
				}else {
					count=0;
				}

			}else {
				count=0;
			}
			if (count>countMax) {
				countMax=count;
			}
		}
		return countMax;

	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = new String[] { "4", "13", "5", "/", "+" };
		LeetStack leetStack = new LeetStack();
		System.out.println(leetStack.evalRPN(tokens));
		System.out.println(leetStack.largestRectangleArea(new int[] { 2, 0, 2 }));
		System.out.println(leetStack.longestValidParentheses("()(())"));

		System.out.println(leetStack.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

	}

}

package finalexam;

import java.awt.geom.Ellipse2D;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.sound.midi.MidiChannel;

import finalexam.*;

public class LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.exec();
	}

	public void exec() {
		// System.out.println(generate(5));
		char[][] data = new char[][] { "XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(),
				"XOXX".toCharArray() };
		surroundedRegion(data);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}

	public ListNode reverseList(ListNode head) {

		ListNode rehead = null;
		while (head != null) {

			ListNode tmp = head;
			head = head.next;
			tmp.next = head;
			rehead = tmp;
		}
		return rehead;

	}

	public int findMaxConsecutiveOnes(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) {
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;

		return left > right ? left : right;
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			nums[nums[i]] = -nums[nums[i]];
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				list.add(i);
		}

		return list;
	}

	public int longestConsecutive(int[] num) {
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
		Iterator<Integer> iterator = set.iterator();
		for (Integer i : set) {
			if (!set.contains(i)) {
				continue;
			}
			int l = i, r = i;
			set.remove(i);
			while (set.contains(i + 1)) {
				set.remove(++r);
			}
			while (set.contains(i - 1)) {
				set.remove(--l);
			}
			max = Math.max(max, r - l + 1);
		}

		return max;
	}

	public boolean isPalindrome(int x) {
		int i = 0;
		int j = 0;

		return false;
	}

	public int maxProfit(int[] prices) {

		int[] dp = new int[prices.length];
		dp[0] = prices[0];
		return 0;
	}

	public void surroundedRegion(char[][] board) {
		int n = board.length;
		int m = n > 0 ? board[0].length : 0;
		map = new boolean[n][m];
		if (m < 3 || n < 3)
			return;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}
	}

	boolean[][] map;

	public boolean dfs(char[][] board, int i, int j) {

		if ((i == board.length - 1 || i == 0) || (j == board[0].length - 1 || j == 0)) {
			if (board[i][j] == 'O') {
				return false;
			} else {
				return true;
			}
		}
		if (map[i][j]) {
			return false;
		}
		if (board[i][j] == 'X') {
			return true;
		}
		map[i][j] = true;
		boolean left = dfs(board, i, j - 1);
		boolean right = dfs(board, i, j + 1);
		boolean up = dfs(board, i - 1, j);
		boolean down = dfs(board, i + 1, j);

		if (left && right && up && down) {
			board[i][j] = 'X';
		}
		;
		map[i][j] = false;
		return left && right && up && down;
	}

	public int[] plusOne(int[] digits) {
		int condition = 0;
		int[] result = new int[digits.length + 1];
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + condition == 10) {
				condition = 1;
				result[i] = 0;
			} else {
				result[i] = digits[i] + 1;
				break;
			}
		}

		return digits;
	}

	public int singleNonDuplicate(int[] nums) {

		int low = 0;
		int high = nums.length - 1;
		int mid = -1;
		if (nums[0] != nums[1]) {
			return nums[0];
		}
		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			return nums[nums.length - 1];
		}
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (mid % 2 == 0) {
				if (nums[mid + 1] > nums[mid] && nums[mid] > nums[mid - 1]) {
					return nums[mid];
				} else if (nums[mid] > nums[mid - 1]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (nums[mid + 1] > nums[mid] && nums[mid] > nums[mid - 1]) {
					return nums[mid];
				} else if (nums[mid] == nums[mid - 1]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

		}
		return mid;
	}

	public void sortColors(int[] A) {
		int n = A.length;
		for (int i = 0; i < A.length; i++) {
			
		}
	}
	
    public int removeDuplicates(int[] A) {
     
    	int k=1;
    	int count=0;
    	for (int i = 1; i < A.length; i++) {
			if (A[i]==A[i-1]&&count<1) {
				A[k++]=A[i];
				count++;
			}else if(A[i]!=A[i-1]){
				A[k++]=A[i];
				k++;
				count=0;
			}else {
				
				count++;
				
			}
		}
    	
    	return k;
    }
    
    public void merge(int A[], int m, int B[], int n) {
    	if (m==0){
    		for (int i = 0; i < n; i++) {
				A[i]=B[i];
			}
    	}
    	if (n==0) {
			return;
		}
    	
        int k=m+n-1;
        int i=m-1;
        int j=n-1;
        while (k>=0&&i>=0&&j>=0) {
			if (A[i]>B[j]) {
				A[k--]=A[i--];
			}else {
				A[k--]=B[j--];
			}
		}
        if (k==0) {
			return;
		}
        if (i<0) {
			while (k>=0) {
				A[k--]=B[j--];
			}
		}else {
			while (k>=0) {
				A[k--]=A[i--];
			}
		}
    }
    
    public int firstMissingPositive(int[] A) {

    	if (A.length==0) {
			return 1;
		}
    	int n=A.length;
    	for(int i=0;i<n;i++){
    		if (A[i]>0&&A[i]<n) {
    			int t=A[A[i]-1];
    			A[A[i]-1]=A[i];
    			A[i]=t;
			}
    	}
    	for (int i = 0; i < A.length; i++) {
			if (A[i]!=i+1) {
				return i+1;
			}
		}
    	return A.length+1;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> list=new ArrayList<>();
    	if (nums.length==0) {
			list.add(new ArrayList<Integer>());
    		return list;
		}
    	int idx=0;
    	subsetDFS(nums, 0,list);
    	
    	return list;
    }
    
    public void subsetDFS(int[] nums, int idx,List<List<Integer>> list) {
		if (idx==nums.length-1) {
			list.add(new ArrayList<Integer>());
		}
	}
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
    	int n=candidates.length;
    	List<Integer> tmp=new ArrayList<>();
    	List<List<Integer>> list=new ArrayList<>();
    	combineDFS(candidates, list, tmp, 0, target);
    	return list;
    }
    
    public void combineDFS(int[] data,List<List<Integer>> result,List<Integer> tmp,int start,int target) {
		if (issum(tmp, target)) {
			result.add(new ArrayList<>(tmp));
		}
		for (int i = start; i < data.length; i++) {
			tmp.add(data[i]);
			combineDFS(data, result, tmp, i+1, target);
			tmp.remove(tmp.size()-1);
		}
	}
    
    public boolean issum(List<Integer> data,int  target) {
		
    	int sum=0;
    	for (int i : data) {
			sum+=i;
		}
    	
    	return sum==target;
	}
}

class MyStack {
	Queue<Integer> queue1 = new ArrayDeque<>();
	Queue<Integer> queue2 = new ArrayDeque<>();

	public MyStack() {
	}

	public void push(int x) {
		queue1.add(x);
	}

	public int pop() {
		Queue<Integer> queueFull = queue1.isEmpty() ? queue2 : queue1;
		Queue<Integer> queueEmpty = queue1.isEmpty() ? queue1 : queue2;
		int n = queueFull.size();
		for (int i = 0; i < n - 1; i++) {
			queueEmpty.add(queueFull.poll());
		}
		return queueFull.poll();

	}

	public int top() {
		Queue<Integer> queueFull = queue1.isEmpty() ? queue2 : queue1;
		Queue<Integer> queueEmpty = queue1.isEmpty() ? queue1 : queue2;
		int n = queueFull.size();
		for (int i = 0; i < n - 1; i++) {
			queueEmpty.add(queueFull.poll());
		}
		Integer tmp = queueFull.poll();
		queueEmpty.add(tmp);
		return tmp;
	}

	public boolean empty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

}

class A {
	public void print() {
		System.out.println("A");
	}
}

class B extends A {
	public void name() {

	}
}
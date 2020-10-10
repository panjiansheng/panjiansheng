import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main4 {
	public static void main(String[] args) {
		// System.out.println(getString(1234));

	
		Main4 main=new Main4();
//		main.didi();
		TreeNode root=new TreeNode(1);
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node4.right=node5;
		node5.left=node6;
//		System.out.println(main.findLastParent(node1, node1, node2));
		Solution solution=new Solution();
		System.out.println(solution.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
		main.push(1);
		main.push(2);
		main.push(3);
		System.out.println(main.StrToInt("123"));
		System.out.println(main.FirstNotRepeatingChar("google"));
		System.out.println(main.pop());
		System.out.println(main.pop());
		System.out.println(main.VerifySquenceOfBST(new int[]{4,6,7,5}));
	}
	
    public int StrToInt(String str) {
        if(str.length()==0)return 0;
        char ch=str.charAt(0);
        int flag=1;
		if(ch=='-')flag=-1;
        int sum=0;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            if(ch=='+'&&i==0)continue;
            if(!(ch>='0'&&ch<='9'))return 0;
            sum=sum*10+(ch-'0');
        }
        return sum*flag;
    }
	
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public boolean VerifySquenceOfBST(int [] sequence) {
		int n=sequence.length;

        
        return verify(sequence,0,n-1);
    }
    public int FirstNotRepeatingChar(String str) {
        
        int[] map=new int[128];
        for(int i=0;i<str.length();i++){
           int ch=str.charAt(i);
           	if(map[ch]==0){
                map[ch]=i+1;}
            else {
                map[ch]=-1;
            }
        }
        int min=10000;
        for(int i=0;i<map.length;i++){
            if(map[i]>0&&map[i]<min)min=map[i];
        }
        
        
        return min-1;
    }
    public boolean verify(int [] sequence,int p,int r){
    	if(p>=r)return true;
        int tmp=sequence[r];
        int index=p;
        for(int i=p;i<r;i++){
            if(sequence[i]>tmp){
                index=i;
                while(i++<r){
                    if(sequence[i]<tmp)return false;
                }
            }
        }
        return verify(sequence,p,index-1)&&verify(sequence,index,r-1);
    }
    public void push(int node) {
        stack1.push(node);
        if(stack2.size()==0){
            stack1.push(node);
        }else{
            int n2=stack2.size();
            for(int i=0;i<n2;i++){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }
    }
    
    public int pop() {
        if(stack2.size()==0){
            int n=stack1.size();
            for(int i=0;i<n-1;i++){
                stack2.push(stack1.pop());
            }
            int res=stack1.pop();


            return res;
        }else{
            return stack2.pop();
        }
    }
	
	
	public TreeNode findLastParent(TreeNode root,TreeNode na,TreeNode nb){
		if (root==null||na==null||nb==null) {
			return null;
		}
		boolean a=findNode(root, na);
		boolean b=findNode(root, nb);
		TreeNode tmpa=findLastParent(root.left, na, nb);
		TreeNode tmpb=findLastParent(root.right, na, nb);
		TreeNode tmp=findLastParent(root, na, nb);
		if (findNode(root, na)&&findNode(root, nb)&&tmpa==null&&tmpb==null) {
			return root;
		}
		if (tmpa!=null) {
			return tmpa;
		}else {
			return tmpb;
		}
	}
	
	
	public boolean findNode(TreeNode root,TreeNode node) {
		if (root==null||node==null) {
			return false;
		}
		if (root==node) {
			return true;
		}
		return findNode(root.left, node)&&findNode(root.right, node);
	}
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
		}
		@Override
		public String toString() {
			return "TreeNode [, val=" + val + "]";
		}
		
	}
	
	public  static void didi(){
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int n=scanner.nextInt();
			int[] data=new int[n];
			for (int i = 0; i < data.length; i++) {
				data[i]=scanner.nextInt();
			}
			int[] dp=new int[n];
			dp[0]=data[0];
			int max=dp[0];
			for (int i = 1; i < dp.length; i++) {
				dp[i]=data[i]+(dp[i-1]>0?dp[i-1]:0);
				if (dp[i]>max) {
					max=dp[i];
				}
			}
			System.out.println(max);
			
		}
	}

	
	public static int test(int b){
		try {
			b+=10;
			return b;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			b+=10;
		}
		return 10;
	}
	public static String getString(int data) {
		if (data > 999)
			return String.valueOf(data);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (data != 0) {
			sb.append(data % 10);
			data = data / 10;
			count++;
		}
		for (int i = 0; i < 4 - count; i++) {
			sb.append("0");
		}
		return sb.reverse().toString();

	}
}



 class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int[] data=new int[k];
        for(int i=0;i<k;i++){
            data[i]=input[i];
        }
        buildHeap(data);
        for(int i=k;i<input.length;i++){
            if(input[i]<data[0]){
                data[0]=input[i];
                heapMaxify(data,0,k);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(data[i]);
        }
        Collections.sort(list);
        return list;
    }
    
    public void buildHeap(int[] data){
        for(int i=data.length-1;i>=0;i--){
			heapMaxify(data,i,data.length);
        }
    }
    
    
    public void heapMaxify(int[] data,int index,int size){
        int largest=index;
        int l=2*(index+1)-1;
        int r=2*(index+1);
        if(l<size&&data[l]>data[index]){
            largest=l;
        }
        if(r<size&&data[r]>data[largest]){
            largest=r;
        }
        if(largest!=index){
            swap(data,index,largest);
            heapMaxify(data,largest,size);
        }
    }
    
    public void swap(int[] data,int a,int b){
        int tmp=data[a];
        data[a]=data[b];
        data[b]=tmp;
    }
}
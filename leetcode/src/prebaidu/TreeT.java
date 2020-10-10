package prebaidu;

import java.util.Stack;


public class TreeT {

	public static void main(String[] args) {
		TreeT t=new TreeT();
		t.exec();
	}
	
	public void exec() {
		int[] data=new int[]{2,8,7,1,3,6,5,4};
		TreeNode root=buildTree(data);
		preTrv2(root);
	}
	
	public void preTrv2(TreeNode root) {
		if (root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();

		while (root!=null||!stack.empty()) {
			
			while (root!=null) {
				//System.out.print(root.val+" ");
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			System.out.print(root.val+" ");
			root=root.right;
		}
	}
	
	public void preTrv(TreeNode root) {
		if (root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode tmp=stack.pop();
			if (tmp.right!=null) {
				stack.push(tmp.right);
			}
			if (tmp.left!=null) {
				stack.push(tmp.left);
			}
			System.out.print(tmp.val+" ");
		}
	}
	
	
	public TreeNode buildTree(int[] data) {
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			root=insertTree(root, data[i]);
		}
		return root;
	}
	
	public TreeNode insertTree(TreeNode root,int val) {
		if (root==null) {
			root=new TreeNode(val);
		}else if (root.val>val) {
			root.left=insertTree(root.left, val);
		}else {
			root.right=insertTree(root.right, val);
		}
		return root;
		
	}
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			// TODO Auto-generated constructor stub
			this.val=val;
		}
	}
}

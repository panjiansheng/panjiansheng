package tencent;

import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree binaryTree=new BinaryTree();
		binaryTree.exec();
	}
	
	public void exec() {
		int[] data=new int[]{3,1,6,4,9,5,2};
		TreeNode root=buildTree(data);
//		preOrderTrvLoop(root);
		midOrderTrvLoop(root);
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
			return new TreeNode(val);
		}
		if (val<root.val) {
			root.left=insertTree(root.left, val);
		}else {
			root.right=insertTree(root.right, val);
		}
		return root;
	}
	
	public void midOrderTrvLoop(TreeNode root) {
		if (root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
//		stack.push(root);
		TreeNode tmp=root;
		while (!stack.isEmpty()||tmp!=null) {
			while (tmp!=null) {
				//System.out.println(tmp.val);
				stack.push(tmp);
				tmp=tmp.left;
			}
			if (!stack.isEmpty()) {
				
				tmp=stack.pop();
				System.out.println(tmp.val);
				tmp=tmp.right;
			}
		}
	}
	
	public void preOrderTrvLoop(TreeNode root){
		if (root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode tmp=stack.pop();
			System.out.println(tmp.val);
			if(tmp.left!=null)stack.push(tmp.left);
			if(tmp.right!=null)stack.push(tmp.right);
		}
	}
	
	public void  preOrderTrv(TreeNode root) {
		if (root==null) {
			return;
		}
		
		preOrderTrv(root.left);
		System.out.println(root.val);
		preOrderTrv(root.right);
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
			return "TreeNode [val=" + val + "]";
		}
		
	}

}

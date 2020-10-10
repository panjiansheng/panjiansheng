package ali;

import java.awt.print.Printable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import ali.InternFaceSortSearch.TreeNode;

public class InternFaceTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data=initData();
		InternFaceTree internFaceTree=new InternFaceTree();
		TreeNode root=internFaceTree.buildTree(data);
		internFaceTree.preOrderTrv(root);
		System.out.println();
		internFaceTree.preOrderTrvLoop(root);
		print("");
		System.out.println(internFaceTree.getNodeNum(root));
		System.out.println(internFaceTree.getDepth(root));
		List<List<Integer>> list=new ArrayList<>();
		internFaceTree.levelTravel(root, 0, list);
		System.out.println(list);
		System.out.println(internFaceTree.calLeafNum(root));
		System.out.println(internFaceTree.getKlevelNum(root, 7));
		internFaceTree.mirrorTree(root);
		list.clear();
		internFaceTree.levelTravel(root, 0, list);
		System.out.println(list);
		internFaceTree.levelOrderStack(root);
		internFaceTree.levelTrv(root);
	}
	
	public static void levelTrv(TreeNode root){
		if (root==null) {
			return;
		}
		Queue<TreeNode> queue=new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode tmp=queue.poll();
			if (tmp.left!=null) {
				queue.add(tmp.left);
			}
			if (tmp.right!=null) {
				queue.add(tmp.right);
			}
			
			System.out.print(tmp.val+" ");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public static void levelOrderStack(TreeNode p){  
        if(p==null)return;  
        List<TreeNode> queue=new LinkedList<TreeNode>();  
        queue.add(p);  
         while(!queue.isEmpty()){  
            TreeNode temp=queue.remove(0);  
            System.out.print(temp.val+" ");  
            if(temp.left!=null){  
                queue.add(temp.left);  
            }  
            if(temp.right!=null){  
                queue.add(temp.right);  
            }  
        }  
        System.out.println();  
    }  
	
	public boolean isMirrorTree(TreeNode roota,TreeNode rootb){
		if (roota==null&&rootb==null) {
			return true;
		}
		if (roota==null||rootb==null) {
			return false;
		}
		return isMirrorTree(roota.left, rootb.right)&&isMirrorTree(roota.right, rootb.left);
		
	}
	
	public void mirrorTree(TreeNode root){
		
		if (root==null) {
			return;
		}
		mirrorTree(root.left);
		mirrorTree(root.right);
		TreeNode tmp=root.left;
		root.left=root.right;
		root.right=tmp;
	}
	
	
	public boolean isAvlTree(TreeNode root){
		if (root==null) {
			return true; 
		}
		if (Math.abs(getDepth(root.left)-getDepth(root.right))>1) {
			return false;
		}
		return isAvlTree(root.left)&&isAvlTree(root.right);
		
	}
	
	public boolean isSameTree(TreeNode roota,TreeNode rootb){
		if (roota==null&&rootb==null) {
			return true;
		}
		if (roota!=null&&rootb==null||roota==null&&rootb!=null) {
			return false;
		}
		if (roota.val!=rootb.val) {
			return false;
		}
		return isSameTree(roota.left, rootb.left)&&isSameTree(roota.right, rootb.right);
	}
	
	public int getKlevelNum(TreeNode root,int k){
		if (root==null||k<1) {
			return 0;
		}
		if (k==1) {
			return 1;
		}
		return getKlevelNum(root.left, k-1)+getKlevelNum(root.right, k-1);
	}
	
	public int calLeafNum(TreeNode root){
		if (root==null) {
			return 0;
		}
		if (root.left==null&&root.right==null) {
			return 1;
		}
		
		return calLeafNum(root.left)+calLeafNum(root.right);
	}
	
	public void levelTravel(TreeNode root,int depth,List<List<Integer>> list){
		if (root==null) {
			return;
		}
		if (list.size()<=depth) {
			list.add(new ArrayList<Integer>());
			list.get(depth).add(root.val);
			
		}else {
			list.get(depth).add(root.val);
		}
		levelTravel(root.left, depth+1, list);
		levelTravel(root.right, depth+1, list);
		
	}
	
	public int getDepth(TreeNode root){
		if (root==null) {
			return 0;
		}
		if (root.left==null&&root.right==null) {
			return 1;
		}
		return Math.max(getDepth(root.left),getDepth(root.right))+1;
	}
	
	
	public int getNodeNum(TreeNode root){
		if (root==null) {
			return 0;
		}
		if (root.left==null&&root.right==null) {
			return 1;
		}
		return getNodeNum(root.left)+getNodeNum(root.right)+1;
	}
	
	public void preOrderTrvLoop(TreeNode root){
		Stack<TreeNode> stack=new Stack<>();
		while(true){
			while (root==null&&!stack.isEmpty()) {
				TreeNode tmp=stack.pop();
				System.out.print(tmp.val+" ");
				root=tmp.right;
				
			}
			if (root==null) {
				break;
			}
			
			stack.push(root);
			root=root.left;
		}
	}
	
	public void preOrderTrv(TreeNode root){
		if (root==null) {
			return;
		}
		preOrderTrv(root.left);
		System.out.print(root.val+" ");
		preOrderTrv(root.right);
	}
	
	private TreeNode buildTree(int[] data){
		TreeNode root=null;
		for (int i = 0; i < data.length; i++) {
			TreeNode node=new TreeNode(data[i], i);
			root=insertTree(root,node);
		}
		return root;
	}
	
	
	
	
	private TreeNode insertTree(TreeNode root,TreeNode node) {
		if(root==null){
			root=node;
		}else if (root.val>node.val) {
			root.left=insertTree(root.left, node);
		}else {
			root.right=insertTree(root.right, node);
		}
		return root;
	}
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		int index;
		
		public TreeNode(int val,int index) {
			// TODO Auto-generated constructor stub
			this.index=index;
			this.val=val;
		}
	}
	public static int[] initData() {
		int[] data = new int[] { 1, 3, 5, 7, 4, 2 };
		return data;
	}
	
	public static void print(String s){
		System.out.println(s);
	}

}

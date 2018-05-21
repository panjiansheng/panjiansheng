package leetSearch;

import java.beans.Statement;
import java.util.HashSet;

public class LeetSearch {

	// 顺序查找
	public int sequeSearch(int[] data, int value) {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == value) {
				return i;
			}
		}
		return -1;
	}

	// 二分查找
	public int binarySearch(int[] data, int value) {

		int low = 0, high = data.length - 1, mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (data[mid] == value) {
				return mid;
			}
			if (data[mid] < value) {
				low = mid;
			}
			if (data[mid] > value) {
				high = mid;
			}
		}
		return -1;
	}

	// 二分查找递归
	public int binarySearchResver(int[] data, int value, int low, int high) {
		int mid = low + (high - low) / 2;
		if (data[mid] == value) {
			return mid;
		}
		if (data[mid] < value) {
			return binarySearchResver(data, value, mid + 1, high);
		}
		if (data[mid] > value) {
			return binarySearchResver(data, value, low, mid - 1);
		}
		return -1;
	}

	// 二叉查找树
	public TreeNode treeSearch(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (val == root.val) {
			return root;
		}
		if (val < root.val) {
			return treeSearch(root.left, val);
		}
		if (val > root.val) {
			return treeSearch(root.right, val);
		}
		return null;

	}

	public TreeNode insertTree(TreeNode root, int x, int i) {
		if (root == null) {
			root = new TreeNode(x, i);
		}
		if (x < root.val) {
			root.left = insertTree(root.left, x, i);
		}
		if (x > root.val) {
			root.right = insertTree(root.right, x, i);
		}

		return root;

	}
	
	
	public boolean delete(TreeNode root,TreeNode parent){
		
		boolean flag=false;
		//根节点处理
		if (parent.index==-1) {
			if (root.left!=null) {
				parent.left=root.left;
				return true;
			}else if (root.right!=null) {
				parent.left=root.right;
				return true;
			}else {
				TreeNode p=root.left,q=p;
				while (p.right!=null) {
					q=p;
					p=p.right;
				}
				q.right=null;
				p.left=root.left;
				p.right=root.right;
				parent.left=p;
				return false;
			}

		}
		if (parent.left==root) {
			flag=true;
		}
		if (root.left==null) {
			if (flag) {
				parent.left=root.right;
			}else {
				parent.right=root.right;
			}
			
			return true;
		}
		else if (root.right==null) {
			if (flag) {
				parent.left=root.left;
			}else {
				parent.right=root.left;
			}
			return true;
		}else  {
			TreeNode p=root;
			p=p.left;
			TreeNode q=p;
			while (p.right!=null) {
				q=p;
				p=p.right;
			}
			q.right=null;
			if (flag) {
				parent.left=p;
				p.left=root.left;
				p.right=root.right;
			}
			return true;
		}
		
		
	}

	public boolean deleteNode(TreeNode root,TreeNode parent,int val) {
		if (root==null) {
			return false;
		}
		if (root.val==val) {
			return delete(root,parent);
		}
		if (val<root.val) {
			return deleteNode(root.left,root,val);
		}
		if (val>root.val) {
			return deleteNode(root.right,root,val);
		}
		
		return false;
	}
	
	
	
	
	public TreeNode buildTree(int[] data) {
		TreeNode root = null;
		for (int i = 0; i < data.length; i++) {
			root = insertTree(root, data[i], i);
		}
		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Object object=new Object(){
//			public boolean equals(Object object) {
//				return true;
//			}
//		};
//		System.out.println(object.equals("hello"));
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 18; j++) {
				if (i*(i-1)/2-j*(j-1)/2==58) {
					System.out.println(i);
				}
			}
		}
		
		
		
		
		
		
//		String toString="hello World";
//		System.out.println(toString.indexOf("l",3));
//		System.err.println("sag");
//		Statement statement=null;
//		Integer data=new Integer(16);
//		System.out.println(Integer.toHexString(16));
//		int[] data = new int[] { 1, 2, 3, 4, 5, 6, 7, 9, 10, 11 };
//		LeetSearch leetSearch = new LeetSearch();
//		System.out.println(leetSearch.sequeSearch(data, 4));
//		System.out.println(leetSearch.binarySearch(data, 4));
//		System.out.println(leetSearch.binarySearchResver(data, 4, 0, 9));
//		TreeNode root = leetSearch.buildTree(data);
//		System.out.println(leetSearch.treeSearch(root, 4).index);
//		TreeNode tmpNode=new TreeNode(0, -1);
//		tmpNode.left=root;
//		System.out.println(leetSearch.deleteNode(root, tmpNode,1));
//		root=tmpNode.left;
//		System.out.println(leetSearch.treeSearch(root, 2).index);

	}
}



class TreeNode {
	public TreeNode left, right;
	public int val;
	public int index;

	public TreeNode(int val, int index) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.index = index;
		String toString="hello World";
		System.out.println(toString.indexOf("l",3));
	}

	@Override
	public String toString() {
		return "TreeNode [left=" + left + ", right=" + right + ", val=" + val + "]";
	}
}

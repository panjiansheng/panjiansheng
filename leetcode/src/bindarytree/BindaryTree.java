package bindarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BindaryTree {

	public static TreeNode createBiTree(Param param) {

		int position = param.position;
		String[] datas = param.datas;
		if (datas.length <= position || datas[position].equals("#"))
			return null;

		int data = Integer.parseInt(datas[position]);
		TreeNode treeNode = new TreeNode(data);
		++param.position;
		treeNode.left = createBiTree(param);
		++param.position;
		treeNode.right = createBiTree(param);
		return treeNode;

	}

	public static TreeLinkNode createLinkBiTree(Param param) {

		int position = param.position;
		String[] datas = param.datas;
		if (datas.length <= position || datas[position].equals("#"))
			return null;

		int data = Integer.parseInt(datas[position]);
		TreeLinkNode treeNode = new TreeLinkNode(data);
		++param.position;
		treeNode.left = createLinkBiTree(param);
		++param.position;
		treeNode.right = createLinkBiTree(param);
		return treeNode;

	}

	public static void preTraversal(TreeNode root) {
		if (root == null) {
			System.out.print("#");
			return;
		}
		System.out.print(root.val);
		preTraversal(root.left);
		preTraversal(root.right);
	}

	public static void inTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inTraversal(root.left);
		System.out.print(root.val);
		inTraversal(root.right);
	}

	public static void postTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		postTraversal(root.left);
		postTraversal(root.right);
		System.out.print(root.val);
	}

	public static Stack<TreeNode> preTvsLoopStack = new Stack<>();

	public static void preTraversalLoop(TreeNode root) {
		TreeNode rootTmp = root;
		while (true) {

			while (rootTmp == null && !preTvsLoopStack.isEmpty()) {
				rootTmp = preTvsLoopStack.pop().right;
			}
			if (rootTmp == null) {
				break;
			}

			assert rootTmp != null : rootTmp;
			System.out.print(rootTmp.val);
			preTvsLoopStack.push(rootTmp);
			rootTmp = rootTmp.left;
		}
	}

	public static Stack<TreeNode> inTvsLoopStack = new Stack<>();

	public static void inTraversalLoop(TreeNode root) {
		TreeNode rootTmp = root;
		while (true) {

			while (rootTmp == null && !inTvsLoopStack.isEmpty()) {
				rootTmp = inTvsLoopStack.pop();
				System.out.print(rootTmp.val);
				rootTmp = rootTmp.right;
			}
			if (rootTmp == null) {
				break;
			}

			assert rootTmp != null : rootTmp;
			// System.out.print(rootTmp.val);
			inTvsLoopStack.push(rootTmp);
			rootTmp = rootTmp.left;
		}
	}

	public static Stack<TreeNode> postTvsLoopStack = new Stack<>();
	public static Stack<TreeNode> postTvsLoopStack2 = new Stack<>();

	public static void postTraversalLoop(TreeNode root) {
		TreeNode rootTmp = root;
		while (true) {

			while (rootTmp == null && !postTvsLoopStack.isEmpty()) {
				rootTmp = postTvsLoopStack.pop();

				rootTmp = rootTmp.right;
			}
			if (rootTmp == null) {
				break;
			}

			assert rootTmp != null : rootTmp;
			// System.out.print(rootTmp.val);
			postTvsLoopStack.push(rootTmp);
			rootTmp = rootTmp.left;
		}
	}

	public static ArrayList<Integer> postorderTraversalList = new ArrayList<>();

	public static ArrayList<Integer> postorderTraversal(TreeNode root) {

		if (root == null)
			return new ArrayList<>();

		postorderTraversal(root.left);
		postorderTraversal(root.right);
		postorderTraversalList.add(root.val);
		return postorderTraversalList;

	}

	public static int calDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = 1 + calDepth(root.left);
		int right = 1 + calDepth(root.right);

		if (left == 2 && right == 1 || left == 1 && right == 2) {
			return 2;
		}
		if (left != 1 && right != 1) {
			if (left < right) {
				return left;
			} else {
				return right;
			}
		} else {
			if (left == 1) {
				return right;
			} else {
				return left;
			}
		}

	}

	public static Stack<TreeLinkNode> connectStack = new Stack<>();
	public static HashMap<Integer, List<TreeLinkNode>> connectFloorMap = new HashMap<>();

	public static void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		List<TreeLinkNode> tmp;
		int size = connectStack.size();
		if (connectFloorMap.get(size) == null) {
			tmp = new ArrayList<>();
			tmp.add(root);
			connectFloorMap.put(size, tmp);
		} else {
			connectFloorMap.get(size).add(root);
		}
		tmp = connectFloorMap.get(size);

		if (tmp.size() > 1) {
			tmp.get(tmp.size() - 2).next = root;
		}

		connectStack.push(root);
		connect(root.left);
		connect(root.right);
		connectStack.pop();

	}

	static ArrayList<Integer> hasPathSumList = new ArrayList<>();
	static Stack<TreeNode> hasPathSumStack = new Stack<>();

	public static boolean hasPathSum(TreeNode root, int sum) {

		hasPathTvl(root);
		for (Integer tmp : hasPathSumList) {
			if (tmp == sum) {
				return true;
			}
		}
		return false;

	}

	public static void hasPathTvl(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			Stack<TreeNode> stack = (Stack<TreeNode>) hasPathSumStack.clone();
			int sumHaspath = root.val;
			for (TreeNode treeNode : stack) {
				sumHaspath += treeNode.val;
			}
			hasPathSumList.add(sumHaspath);
		}
		hasPathSumStack.push(root);
		hasPathTvl(root.left);
		hasPathTvl(root.right);
		hasPathSumStack.pop();
		return;

	}

	static ArrayList<ArrayList<Integer>> pathSumList = new ArrayList<>();
	static Stack<TreeNode> pathSumStack = new Stack<>();

	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		pathSumTvl(root, sum);
		return pathSumList;

	}

	public static void pathSumTvl(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			Stack<TreeNode> stack = (Stack<TreeNode>) pathSumStack.clone();
			int sumHaspath = root.val;
			for (TreeNode treeNode : stack) {
				sumHaspath += treeNode.val;
			}

			if (sumHaspath == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (TreeNode treeNode : pathSumStack) {
					list.add(treeNode.val);

				}
				list.add(root.val);
				pathSumList.add(list);
			}

		}
		pathSumStack.push(root);
		pathSumTvl(root.left, sum);
		pathSumTvl(root.right, sum);
		pathSumStack.pop();
		return;

	}
	
	
public static TreeNode buildTreeRoot=null;
	
	
	
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
 
    	if (inorder.length==0) {
			return null;
		}
    	if (postorder.length==0) {
			return null;
		}
       	TreeNode root=new TreeNode(postorder[postorder.length-1]);
    	int[] postmp=new int[postorder.length-1];
    	for(int i=0;i<postorder.length-1;i++){
    		postmp[i]=postorder[i];
    	}
    	
    	int index=-1;
    	
    	for(int i=0;i<inorder.length;i++){
    		if (inorder[i]==postorder[postorder.length-1]) {
    			index=i;
			}
    	}
    	
    	int[] leftInorder=new int[index];
    	
    	int[] rightInorder=new int[inorder.length-index-1];
    	
 
    	root.left=buildTree(leftInorder, postmp);
    	root.right=buildTree(rightInorder, postmp);
    	
  

    	
		return root;
        
    }

	static Stack<TreeNode> isBalancedStack = new Stack<>();
	static ArrayList<Integer> isBalancedList =new ArrayList<>();

	public static boolean isBalanced(TreeNode root) {


		
		isBalancedTvl(root);
		for (Integer tmp : isBalancedList) {
			if (tmp>1) {
				return false;
			}
		}
		return true;

	}

	public static int isBalancedTvl(TreeNode root) {
		if (root==null) {
			return 0;
		}

		int left=isBalancedTvl(root.left);
		int right=isBalancedTvl(root.right);
		isBalancedList.add(1+Math.abs(left-right));
		if (root.left==null&&root.right!=null||root.left!=null&&root.right==null) {
			return 1+Math.abs(left-right);
		}
		
		return Math.abs(left-right);

	}

	public static void test() {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		treeNode1.left = treeNode2;
		System.out.println(treeNode1);
		TreeNode treeNode3 = new TreeNode(3);
		treeNode3 = treeNode1.left;

		treeNode3.left = new TreeNode(4);
		System.out.println(treeNode1);
	}

	public static void main(String[] args) {

		TreeNode root = createBiTree(new Param());
		preTraversal(root);
		System.out.println("");
		inTraversal(root);
		System.out.println("");
		postTraversal(root);
		System.out.println("");
		int depth = calDepth(root);
		System.out.println(depth);
		ArrayList<Integer> list = postorderTraversal(root);
		System.out.println(list);
		test();
		preTraversalLoop(root);
		System.out.println("");
		inTraversalLoop(root);
		System.out.println("");
		TreeLinkNode treeLinkNodeRoot = createLinkBiTree(new Param());
		connect(treeLinkNodeRoot);
		System.out.println(treeLinkNodeRoot);
		System.out.println("");
		System.out.println(hasPathSum(root, 6));
		System.out.println("");
		System.out.println(pathSum(root, 6));
		System.out.println("");
		System.out.println(isBalanced(root));
	}

	static class Param {
		// public String[] datas = new
		// String("1,2,3,#,#,4,#,#,5,6,#,#,#").split(",");
		 public String[] datas = new String("1,2,2,3,3,#,#,4,4").split(",");
		//public String[] datas = new String("1,2,3,#,#,4,#,#,5,6,#,#,#").split(",");
		public int position = 0;

	}

	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}

	static class TreeLinkNode {
		int val;
		public TreeLinkNode left, right, next;

		public TreeLinkNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeLinkNode [val=" + val + ", left=" + left + ", right=" + right + ", next=" + next + "]";
		}

	}

}

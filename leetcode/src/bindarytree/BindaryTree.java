package bindarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BindaryTree {
	public static void main(String[] args) {

		TreeNode root = createBiTree(new Param());
		preTraversal(root);
		System.out.println("");
		inTraversal(root);
		System.out.println("");
		postTraversal(root);
		System.out.print("\ndepth:");
		int depth = calDepth(root);
		System.out.println(depth);
		ArrayList<Integer> list = inorderTraversal(root);
		System.out.println(list);
		System.out.println(depth);
		list = postorderTraversal(root);
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
		System.out.print("\nbanlance:");
		System.out.println(isBalanced(root));
		System.out.println("");
		System.out.println(sumNumbers(root));
		System.out.println("");
		System.out.println(levelOrderBottom(root));
		System.out.println("");
		System.out.println(buildTree(new int[] { 3, 2, 4, 1, 6, 5 }, new int[] { 3, 4, 2, 6, 5, 1 }));
		System.out.println("");
		System.out.println(buildTreePreIn(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 3, 2, 4, 1, 6, 5 }));
		System.out.println("");
		System.out.println(zigzagLevelOrder(root));
		System.out.println("");
		System.out.println(levelOrder(root));
		System.out.print("\nisSymmertric:");
		System.out.println(isSymmetric(root));
		System.out.println("");
		System.out.println(isValidBST(root));
		System.out.println("");
		System.out.println(isSameTree(root, root));
		System.out.println("");
		recoverTree(root);
		System.out.println(root);

	}
	

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
			// System.out.print("#");
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

	public static ArrayList<Integer> inorderTraversalList = new ArrayList<>();

	public static ArrayList<Integer> inorderTraversal(TreeNode root) {

		if (root == null)
			return new ArrayList<>();

		inorderTraversal(root.left);
		inorderTraversalList.add(root.val);
		inorderTraversal(root.right);

		return inorderTraversalList;

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

	public static TreeNode buildTreeRoot = null;

	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		int index = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length - 1]) {
				index = i;
			}
		}
		int[] leftInorder = new int[index];
		for (int i = 0; i < index; i++) {
			leftInorder[i] = inorder[i];
		}
		int[] rightInorder = new int[inorder.length - index - 1];
		for (int i = 0; i < rightInorder.length; i++) {
			rightInorder[i] = inorder[i + index + 1];
		}
		int[] postmpLeft = new int[postorder.length - rightInorder.length - 1];
		for (int i = 0; i < leftInorder.length; i++) {
			postmpLeft[i] = postorder[i];
		}
		int[] postmpRight = new int[postorder.length - leftInorder.length - 1];
		for (int i = 0; i < rightInorder.length; i++) {
			postmpRight[i] = postorder[i + leftInorder.length];
		}
		root.left = buildTree(leftInorder, postmpLeft);
		root.right = buildTree(rightInorder, postmpRight);
		return root;
	}

	public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {

		if (inorder.length == 0 || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int index = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				index = i;
			}
		}
		int[] leftInorder = new int[index];
		for (int i = 0; i < index; i++) {
			leftInorder[i] = inorder[i];
		}
		int[] rightInorder = new int[inorder.length - index - 1];
		for (int i = 0; i < rightInorder.length; i++) {
			rightInorder[i] = inorder[i + index + 1];
		}
		int[] prempLeft = new int[preorder.length - rightInorder.length - 1];
		for (int i = 0; i < leftInorder.length; i++) {
			prempLeft[i] = preorder[1 + i];
		}
		int[] prempRight = new int[preorder.length - leftInorder.length - 1];
		for (int i = 0; i < rightInorder.length; i++) {
			prempRight[i] = preorder[1 + i + leftInorder.length];
		}
		root.left = buildTreePreIn(prempLeft, leftInorder);
		root.right = buildTreePreIn(prempRight, rightInorder);
		return root;

	}

	public static boolean isBalanced(TreeNode root) {

		if (root == null || root.left == null && root.right == null) {
			return true;
		}
		try {
			isBalancedTvl(root);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;

	}

	public static int isBalancedTvl(TreeNode root) throws Exception {
		if (root == null) {
			return 0;
		}

		int left = isBalancedTvl(root.left);
		int right = isBalancedTvl(root.right);

		int num = Math.abs(left - right);
		if (root.left == null && root.right != null || root.left != null && root.right == null) {
			num = 1 + Math.abs(left - right);
		}
		if (num > 1) {
			throw new Exception();
		}
		return num;

	}

	static Stack<TreeNode> sumNumbersStack = new Stack<>();
	static ArrayList<Integer> sumNumbersList = new ArrayList<>();

	public static int sumNumbers(TreeNode root) {
		sumNumbersTvl(root);
		int sum = 0;
		for (Integer tmp : sumNumbersList) {
			sum += tmp;
		}
		return sum;

	}

	public static void sumNumbersTvl(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			int num = root.val;
			Stack<TreeNode> tmp = new Stack<>();
			tmp = (Stack<TreeNode>) sumNumbersStack.clone();
			for (int i = 0; i < sumNumbersStack.size(); i++) {
				TreeNode treeNode = tmp.pop();
				num = (int) (treeNode.val * Math.pow(10, (i + 1)) + num);

			}
			sumNumbersList.add(num);
		}
		sumNumbersStack.push(root);
		sumNumbersTvl(root.left);
		sumNumbersTvl(root.right);
		sumNumbersStack.pop();

	}

	static Stack<TreeNode> maxPathSumStack = new Stack<>();
	static ArrayList<Integer> maxPathSumList = new ArrayList<>();

	public static int maxPathSum(TreeNode root) {
		return 0;

	}

	public static void maxPathSumTvl(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			int num = root.val;

			maxPathSumList.add(num);
		}
		maxPathSumStack.push(root);
		sumNumbersTvl(root.left);
		sumNumbersTvl(root.right);
		maxPathSumStack.pop();

	}

	static ArrayList<ArrayList<Integer>> levelOrderBottomList = new ArrayList<>();
	static Stack<TreeNode> levelOrderBottomStack = new Stack<>();

	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

		if (root == null) {
			return levelOrderBottomList;
		}
		if (levelOrderBottomList.size() <= levelOrderBottomStack.size()) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.val);
			levelOrderBottomList.add(list);
		} else {
			levelOrderBottomList.get(levelOrderBottomStack.size()).add(root.val);
		}
		levelOrderBottomStack.push(root);
		levelOrderBottom(root.left);
		levelOrderBottom(root.right);
		levelOrderBottomStack.pop();
		if (levelOrderBottomStack.isEmpty()) {
			for (int i = 0; i < levelOrderBottomList.size() / 2; i++) {
				ArrayList<Integer> tmp = levelOrderBottomList.get(i);
				levelOrderBottomList.set(i, levelOrderBottomList.get(levelOrderBottomList.size() - i - 1));
				levelOrderBottomList.set(levelOrderBottomList.size() - i - 1, tmp);
			}
		}
		return levelOrderBottomList;

	}

	static ArrayList<ArrayList<Integer>> zigzagLevelOrderList = new ArrayList<>();
	static int zigzagLevelOrder = 0;

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return zigzagLevelOrderList;
		}
		if (zigzagLevelOrderList.size() <= zigzagLevelOrder) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.val);
			zigzagLevelOrderList.add(list);
		} else {
			zigzagLevelOrderList.get(zigzagLevelOrder).add(root.val);
		}
		zigzagLevelOrder++;
		zigzagLevelOrder(root.left);
		zigzagLevelOrder(root.right);
		zigzagLevelOrder--;
		if (zigzagLevelOrder == 0) {
			for (int i = 0; i < zigzagLevelOrderList.size(); i++) {
				if (i % 2 == 1) {
					ArrayList<Integer> list = zigzagLevelOrderList.get(i);
					for (int j = 0; j < list.size() / 2; j++) {
						Integer tmp = list.get(j);
						list.set(j, list.get(list.size() - 1 - j));
						list.set(list.size() - 1 - j, tmp);
					}
				}
			}
		}
		return zigzagLevelOrderList;
	}

	static ArrayList<ArrayList<Integer>> levelOrderList = new ArrayList<>();
	static int levelOrderCount = 0;

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return levelOrderList;
		}
		if (levelOrderList.size() <= levelOrderCount) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.val);
			levelOrderList.add(list);
		} else {
			levelOrderList.get(levelOrderCount).add(root.val);
		}
		levelOrderCount++;
		levelOrder(root.left);
		levelOrder(root.right);
		levelOrderCount--;
		return levelOrderList;

	}

	static ArrayList<Integer> isSymmetricList = new ArrayList<>();
	static TreeNode treeNodeRoot = null;

	public static boolean isSymmetric(TreeNode root) {

		try {
			isSymmetricTvl(root);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;

	}

	public static boolean isSymmetricTvl(TreeNode root) throws Exception {
		if (isSymmetricList.size() == 0) {
			treeNodeRoot = root;
		}
		TreeNode treeNodeTmp = treeNodeRoot;
		for (Integer tmp : isSymmetricList) {
			if (tmp == 0) {
				treeNodeTmp = treeNodeTmp.right;
			} else {
				treeNodeTmp = treeNodeTmp.left;
			}
		}
		if (treeNodeTmp == null && root == null) {
			return true;
		}
		if (treeNodeTmp != null && root == null || treeNodeTmp == null && root != null) {
			throw new Exception();
		}
		if (treeNodeTmp.val != root.val) {
			throw new Exception();
		}
		isSymmetricList.add(0);
		isSymmetricTvl(root.left);
		isSymmetricList.set(isSymmetricList.size() - 1, 1);
		isSymmetricTvl(root.right);
		isSymmetricList.remove(isSymmetricList.size() - 1);
		return true;
	}

	public static boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}
		try {
			validBSTvl(root, 3);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;

	}

	public static int validBSTvl(TreeNode root, int type) throws Exception {

		int left = 0, right = 0;
		if (root.left != null) {
			left = validBSTvl(root.left, 0);
		} else {
			left = Integer.MIN_VALUE;
		}
		if (root.right != null) {
			right = validBSTvl(root.right, 1);
		} else {
			right = Integer.MAX_VALUE;
		}

		if (left >= root.val || right <= root.val) {
			throw new Exception();
		}
		if (type == 0) {

			if (root.right != null) {
				return Math.max(root.val, right);
			} else {
				return root.val;
			}

		}

		if (type == 1) {
			if (root.left != null) {
				return Math.min(root.val, left);
			} else {
				return root.val;
			}
		}
		return root.val;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		if (p.val != q.val)
			return false;
		if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))
			return false;
		return true;
	}

	public static int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;

		int[] pre=new int[n];
		int[] in=new int[n];
		for(int i=0;i<n;i++){
			in[i]=i+1;
		}
		return 0;

	}

	public static TreeNode recoverTreeNode = null;
	public static int recoverSearch=Integer.MAX_VALUE;
	public static TreeNode recoverTmpNode=null;
	public static int lastMax=Integer.MIN_VALUE;
	public static boolean recoverFlag=true;
	public static List<TreeNode> recoverList=new ArrayList<>();
	
	
	public static void recoverTree(TreeNode root) {

		if (root == null)
			return;
		if (recoverFlag) {
			recoverTreeNode=root;
			recoverFlag=false;
		}
		recoverTree(root.left);
		if (root.val<lastMax) {
			recoverList.add(root);
		}
//		recoverTreeTvl(recoverTreeNode);
//		root.val=recoverSearch;
//		lastMax=root.val;
//		recoverSearch=Integer.MAX_VALUE;
		recoverTree(root.right);

	}
	
	public static void recoverTreeTvl(TreeNode root) {

		if (root == null)
			return;
		if (recoverTmpNode==null) {
			recoverTmpNode=root;
		}
		if (root.val<recoverTmpNode.val&&root.val>lastMax) {
			swap(recoverTmpNode, root);
		}
		recoverTreeTvl(root.left);
		recoverTreeTvl(root.right);

	}

	public static <T> void swap(T a, T b) {
		T tmp = a;
		a = b;
		b = tmp;
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



	static class Param {
		// public String[] datas = new
		// String("1,2,3,#,#,4,#,#,5,6,#,#,#").split(",");
		// public String[] datas = new String("1,2,3,4,5").split(",");
		// public String[] datas = new
		public String[] datas = new String("1,2,3,4,5,6").split(",");
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

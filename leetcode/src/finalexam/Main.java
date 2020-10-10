package finalexam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		// main.selectSort(data);
		// main.insertSort(data);
		// main.quickSort(data, 0, data.length-1);
		// main.bubbleSort(data);
		// main.mergesort(data, 0, data.length-1);
		// main.heapSort(data);
		// main.insertSort2(data);
		// main.print(data);
		main.exec();
	}

	public void exec() {
		int[] data = new int[] { 9, 8, 7, 6, 5, 40, 3, 2, 1, 0 };
		// insertSort(data);
		// System.out.println(binarySearch(data, 2));
		TreeNode root = buildTree(data);
		preTrv(root);
		System.out.println();
		midTrv(root);
		System.out.println();
		backTrv(root);
		System.out.println();
		levelTrv(root);
		System.out.println();
		preTrvLoop(root);
		System.out.println();
		midTrvLoop(root);
		System.out.println();
		System.out.println(getDepth(root));
		System.out.println(getLeafNum(root));
		System.out.println(isAvlTree(root));
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode head = node1;
		print(head);
		System.out.println(getListLength(head));
		// print(reverseList(head));
		// print(reverseListLoop(head));

		reversePrint(head);
		System.out.println();
		print(delete(head, 1));
//		getAllPath(root);
//		for(int i=0;i<list.size();i++){
//			for (int j = 0; j < list.get(i).size(); j++) {
//				System.out.print(list.get(i).get(j).val+" ");
//			}
//			System.out.println();
//		}
	}

	Stack<TreeNode> stack = new Stack<>();
	List<List<TreeNode>> list = new ArrayList<>();

	public void getAllPath(TreeNode root) {
		if (root == null) {
			return;
		}
		stack.push(root);
		if (root.left == null && root.right == null) {
			list.add((List<TreeNode>)stack.clone());
		}
		getAllPath(root.left);
		getAllPath(root.right);
		stack.pop();
	}

	// 删除节点
	public ListNode delete(ListNode head, int val) {

		ListNode tmp=new ListNode(-1);
		tmp.next=head;
		ListNode back=tmp;
		ListNode cur=head;
		while (cur != null) {
			if (cur.val==val) {
				back.next=cur.next;
				cur=back;
			}
			back=cur;
			cur=back.next;
		}
		return tmp.next;

	}

	// 求进入环中的第一个节点
	public ListNode getFirstCycleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast) {
			return null;
		}
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

	// 判断是否相交
	public boolean isIntersect(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return false;
		}
		ListNode p1 = head1;
		ListNode p2 = head2;
		while (p1.next != null) {
			p1 = p1.next;
		}
		while (p2.next != null) {
			p2 = p2.next;
		}
		return p1 == p2;
	}

	// 判断是否有环
	public boolean hasCycle(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head;
		while (p2.next != null && p2 != null) {
			p1 = head.next;
			p2 = head.next.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	// 合并单链表
	public ListNode mergeList(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		if (head1.val < head2.val) {
			head1.next = mergeList(head1.next, head2);
			return head1;
		} else {
			head2.next = mergeList(head1, head2.next);
			return head2;
		}

	}

	// 从头到尾打印链表
	public void reversePrint(ListNode head) {
		if (head == null) {
			return;
		}
		reversePrint(head.next);
		System.out.print(head.val + " ");
	}

	// 求单链表长度
	public int getListLength(ListNode head) {

		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	// 反转链表
	public ListNode reverseList(ListNode node) {
		if (node==null) {
			return null;
		}
		if (node.next == null) {
			return node;
		}
		ListNode tmp = reverseList(node.next);
		node.next.next = node;
		node.next = null;
		return tmp;
	}

	
	public ListNode reverseListLoop(ListNode node) {
		ListNode head = null;
		while (node != null) {

			ListNode tmp = node;
			node = node.next;
			tmp.next = head;
			head = tmp;
		}
		return head;
	}

	// 转换二叉树为双向链表
	public TreeNode convertBst2Dll(TreeNode root) {
		TreeNode lastNode = null;
		lastNode = convertBst2DllRec(root, lastNode);
		TreeNode head = lastNode;
		while (head.left != null) {
			head = head.left;
		}
		return head;

	}

	public TreeNode convertBst2DllRec(TreeNode root, TreeNode lastNode) {
		if (root == null) {
			return lastNode;
		}
		if (root.left != null) {
			lastNode = convertBst2DllRec(root.left, lastNode);
		}
		root.left = lastNode;
		if (lastNode != null) {
			lastNode.right = root;
		}
		lastNode = root;
		if (root.right != null) {
			lastNode = convertBst2DllRec(root.right, lastNode);
		}

		return lastNode;
	}

	// 判断完全二叉树
	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return false;
		}
		boolean MustNoChild = false;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();

			if (tmp == null) {
				MustNoChild = true;
				continue;
			}
			if (MustNoChild == true) {
				return false;
			}
			queue.add(tmp.left);
			queue.add(tmp.right);

		}

		return true;
	}

	// 二叉树节点的最大距离
	public void getMaxDistance(TreeNode root) {

	}

	// 求最低公共祖先节点
	public TreeNode getLowestParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}
		if (root == node1 || root == node2) {
			return root;

		}
		TreeNode commonInLeft = getLowestParent(root.left, node1, node2);
		TreeNode commonInRight = getLowestParent(root.right, node1, node2);
		if (commonInLeft != null && commonInRight != null) {
			return root;
		}
		if (commonInLeft == null) {
			return commonInLeft;
		}
		return commonInRight;
	}

	// 求二叉树的镜像
	public TreeNode getMirror(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = getMirror(root.left);
		TreeNode right = getMirror(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	// 求二叉树的镜像
	public TreeNode getMirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode rootm = new TreeNode(root.val);
		rootm.left = getMirrorTree(root.right);
		rootm.right = getMirrorTree(root.left);
		return rootm;

	}

	// 是否平衡二叉树
	public boolean isAvlTree(TreeNode root) {
		if (root == null) {
			return false;
		}
		if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
			return false;
		}
		return isAvlTree(root.left) & isAvlTree(root.right);

	}

	public int getLeafNum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return getLeafNum(root.left) + getLeafNum(root.right);
	}

	// 求二叉树的深度
	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int dl = getDepth(root.left);
		int dr = getDepth(root.right);
		return 1 + (dl > dr ? dl : dr);
	}

	// 先序遍历
	public void preTrv(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preTrv(root.left);
		preTrv(root.right);
	}

	// 非递归先序遍历
	public void preTrvLoop(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.print(cur.val + " ");
			if (cur.right != null) {
				stack.push(cur.right);

			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// 非递归中序遍历
	public void midTrvLoop(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			cur = stack.pop();
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
	}

	// 中序遍历
	public void midTrv(TreeNode root) {
		if (root == null) {
			return;
		}
		midTrv(root.left);
		System.out.print(root.val + " ");
		midTrv(root.right);
	}

	// 后序遍历
	public void backTrv(TreeNode root) {
		if (root == null) {
			return;
		}
		backTrv(root.left);
		backTrv(root.right);
		System.out.print(root.val + " ");
	}

	// 层次遍历
	public void levelTrv(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			System.out.print(tmp.val + " ");
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
	}

	// 二叉搜索树
	public int binaryTreeSearch(int[] data, int val) {
		TreeNode root = buildTree(data);
		return treeSearchReal(root, val);
	}

	public int treeSearchReal(TreeNode root, int val) {
		if (root == null) {
			return -1;
		} else if (root.val == val) {
			return root.index;
		} else if (root.val > val) {
			return treeSearchReal(root.left, val);
		} else if (root.val < val) {
			return treeSearchReal(root.right, val);
		}
		return -1;
	}

	public TreeNode buildTree(int[] data) {
		TreeNode root = null;
		for (int i = 0; i < data.length; i++) {
			root = insertTree(root, data[i], i);
		}
		return root;
	}

	public TreeNode insertTree(TreeNode root, int val, int index) {
		if (root == null) {
			root = new TreeNode(val, index);
		}
		if (root.val > val) {
			root.left = insertTree(root.left, val, index);
		} else if (root.val < val) {
			root.right = insertTree(root.right, val, index);
		}
		return root;
	}

	// 二分搜索
	public int binarySearch(int[] data, int val) {
		int low = 0;
		int high = data.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (data[mid] < val) {
				low = mid + 1;
			} else if (data[mid] > val) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	// 堆排序
	public void heapSort(int[] data) {
		buildHeap(data);
		for (int i = data.length - 1; i > 0; i--) {
			swap(data, 0, i);
			heapMaxify(data, 0, i);
		}
	}

	public void buildHeap(int[] data) {
		for (int i = data.length / 2 - 1; i >= 0; i--) {
			heapMaxify(data, i, data.length);
		}
	}

	public void heapMaxify(int[] data, int index, int size) {
		int l = 2 * (index + 1) - 1;
		int r = 2 * (index + 1);
		int largest = index;
		if (l < size && data[l] > data[index]) {
			largest = l;
		}
		if (r < size && data[r] > data[largest]) {
			largest = r;
		}
		if (largest != index) {
			swap(data, largest, index);
			heapMaxify(data, largest, size);
		}
	}

	// 归并排序
	public void mergesort(int[] data, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergesort(data, p, q);
			mergesort(data, q + 1, r);
			merge(data, p, q, r);
		}
	}

	public void merge(int[] data, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			L[i] = data[p + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = data[q + i + 1];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		for (int i = 0, j = 0, k = p; k <= r; k++) {
			if (L[i] < R[j]) {
				data[k] = L[i];
				i++;
			} else {
				data[k] = R[j];
				j++;
			}
		}

	}

	// 快速排序
	public void quickSort(int[] data, int p, int r) {
		if (p < r) {
			int low = p - 1;
			int high = p;
			for (; high < r; high++) {
				if (data[high] < data[r]) {
					low++;
					swap(data, high, low);
				}
			}
			int index = low + 1;
			swap(data, index, r);
			quickSort(data, p, index - 1);
			quickSort(data, index + 1, r);
		}
	}

	// 冒泡排序
	public void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 1; j < data.length - i; j++) {
				if (data[j] < data[j - 1]) {
					swap(data, j, j - 1);
				}
			}
		}
	}

	// 插入排序
	public void insertSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			int j = i - 1;
			int tmp = data[i];
			if (data[j] > data[i]) {
				while (j >= 0) {
					data[j + 1] = data[j];
					j--;
				}
				data[j + 1] = tmp;
			}
		}
	}

	// 选择排序
	public void selectSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int minIndex = i;
			for (int j = i; j < data.length; j++) {
				if (data[j] < data[minIndex])
					minIndex = j;
			}
			swap(data, i, minIndex);
		}
	}

	public void swap(int[] data, int i, int j) {
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	public void print(int[] data) {
		for (int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}

class TreeNode {
	int val;
	int index;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val, int index) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.index = index;
	}

	public TreeNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
}

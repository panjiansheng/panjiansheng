package leetcode;


class  Solution{

	int depth;



	public int run(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1+run(root.left);

	}


}

public class MinimumDepthOfBinaryTree{
	public static void main(String[] args) {
		TreeNode treeNode=new TreeNode(0);
		TreeNode t1 = null;
		TreeNode t2 = null;
		for (int i = 0; i < 100; i++) {
			if (i==0) {
				 t1=new TreeNode(i);
				 t2=treeNode;
				 
			}

			t2.left=new TreeNode(i);
			t2.right=new TreeNode(i+1);
			t2=t2.right;
			
		}
		Solution solution=new Solution();
		System.out.println(solution.run(treeNode));
	}
	
}


class TreeNode {
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

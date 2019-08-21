package JianzhiOffer;

/**
 * 二叉树的深度：
 */
public class No55 {
	/*
	 * 题目一：二叉树的深度 输入一棵二叉树的根结点，求该树的深度。
	 *  从根结点到叶结点依次经过的/结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
	 */
	public int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = TreeDepth(root.getLchild());
		int right = TreeDepth(root.getRchild());
		return Math.max(left + 1, right + 1);
	}

	/*
	 * 题目二：平衡二叉树 输入一棵二叉树的根结点，
	 * 判断该树是不是平衡二叉树。 
	 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		return getDepth(root) != -1;
	}

	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.getLchild());
		if (left == -1)
			return -1;
		int right = getDepth(root.getRchild());
		if (right == -1)
			return -1;
		return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
	}

	/*
	 * //自己开始想的方法，但是一定要把树给遍历完才行；上面的方法实现了剪枝 boolean isBalanced=true; public boolean
	 * IsBalanced_Solution(TreeNode root) { TreeDepth(root); return isBalanced; }
	 * 
	 * public int TreeDepth(TreeNode root) { if(root==null) return 0; int
	 * left=TreeDepth(root.getLchild()); int right=TreeDepth(root.getRchild());
	 * if(left-right>1 || right-left>1) isBalanced=false; return
	 * Math.max(left+1,right+1); }
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		root.setLchild(node1);
		root.setRchild(node2);
		node1.setLchild(node3);
		node1.setRchild(node4);
		node4.setLchild(node6);
		node2.setRchild(node5);
		No55 test = new No55();
		System.out.println(test.TreeDepth(root));
		System.out.println(test.IsBalanced_Solution(root));
	}
}

package JianzhiOffer;

/**
 * 树中两个结点的最低公共祖先： 输入两个树结点，求它们的最低公共祖先。
 */
public class No68 {
	/*
	 * 二叉搜索树 利用大小关系即可
	 */
	public TreeNode getLowestCommonParentBST(TreeNode root, TreeNode node1, TreeNode node2) {
		while (true) {
			if (root == null)
				return root;
			if (root.getValue() < node1.getValue() && root.getValue() < node2.getValue())
				root = root.getLchild();
			else if (root.getValue() > node1.getValue() && root.getValue() > node2.getValue())
				root = root.getRchild();
			else
				return root;
		}
	}

	/*
	 * 普通二叉树 将下面结点的信息利用递归s往上传递
	 */
	public TreeNode getLowestCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2)
			return root;
		TreeNode left = getLowestCommonParent(root.getLchild(), node1, node2);
		TreeNode right = getLowestCommonParent(root.getRchild(), node1, node2);
		return left == null ? right : right == null ? left : root;
		// 上面这句代码就是：
//		 if(left==null) {
//	          return right;
//		 }else {
//	      if(right==null)
//	          return left;
//	      else
//	          return root;
//		 }
	}
}

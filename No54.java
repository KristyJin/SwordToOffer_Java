package JianzhiOffer;

/**
 * 二叉搜索树的第k大节点： 给定一棵二叉搜索树，请找出其中的第k小的结点。
 */
public class No54 {
	int index = 0;
	TreeNode KthNode(TreeNode pRoot, int k) {
		TreeNode pNode = null;
		if (pRoot == null || k <= 0)
			return pNode;
		pNode = getKthNode(pRoot, k);
		return pNode;
	}	
	private TreeNode getKthNode(TreeNode pRoot, int k) {
		TreeNode kthNode = null;
		if (pRoot.getLchild() != null)
			kthNode = getKthNode(pRoot.getLchild() , k);

		if (kthNode == null) {
			index++;
			if (k == index)
				kthNode = pRoot;
		}

		if (kthNode == null && pRoot.getRchild() != null)
			kthNode = getKthNode(pRoot.getRchild(), k);

		return kthNode;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(8);
		root.setLchild(node1);
		root.setRchild(node2);
		node1.setLchild(node3);
		node1.setRchild(node4);
		node2.setLchild(node5);
		node2.setRchild(node6);
		No54 test = new No54();
		TreeNode resNode = test.KthNode(root, 3);
		
		if (resNode != null)
			System.out.println(resNode.value);
	}
}

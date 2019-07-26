package JianzhiOffer;
/*
 *FileName:  No36
 * Author:   Kristy
 * Date  :   2019/7/26 11:24
 * */

/**
 * 二叉搜索树与双向链表：
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建人和新的结点，只能调整树中结点指针的指向。
 */
public class No36 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(16);
        root.setLchild(node1);
        root.setRchild(node2);
        node1.setLchild(node3);
        node1.setRchild(node4);
        node2.setLchild(node5);
        node2.setRchild(node6);

        TreeNode head = covert(root);

        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getRchild();
        }
    }

    private static TreeNode covert(TreeNode root) {
        TreeNode lastNodeList = null;
        lastNodeList = convertNode(root, lastNodeList);
        while (lastNodeList != null && lastNodeList.getLchild() != null) {
            lastNodeList = lastNodeList.getLchild();
        }
        return lastNodeList;
    }

    private static TreeNode convertNode(TreeNode root,
                                              TreeNode lastNodeList) {
        if (root == null)
            return null;
        TreeNode current = root;
        if (current.getLchild() != null) {
            lastNodeList = convertNode(current.getLchild(), lastNodeList);
        }

        current.setLchild(lastNodeList);

        if (lastNodeList != null) {
            lastNodeList.setRchild(current);
        }
        lastNodeList = current;
        if (current.getRchild() != null) {
            lastNodeList = convertNode(current.getRchild(), lastNodeList);
        }
        return lastNodeList;
    }
}

package JianzhiOffer;
/*
 *FileName:  No34
 * Author:   Kristy
 * Date  :   2019/7/26 11:05
 * */

import java.util.Stack;

/**
 * 二叉树中和为某一值的路径：
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class No34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(12);
        root.setLchild(node1);
        root.setRchild(node4);
        node1.setLchild(node2);
        node1.setRchild(node3);
        findPath(root, 22);
    }

    private static void findPath(TreeNode root, int i) {
        if (root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root, i, stack, currentSum);
    }

    private static void findPath(TreeNode root, int i,
                                 Stack<Integer> stack, int currentSum) {
        currentSum += root.getValue();
        stack.push(root.getValue());
        //如果是叶节点，并且路径上的和等于输入的值，则打印出这条路径
        boolean isLeaf = root.getLchild() == null && root.getRchild() == null;
        if (currentSum == i && isLeaf) {
            System.out.print("找到路径: ");
            for (int path : stack) {
                System.out.print(path + " ");
            }
            System.out.println();
        }

        //如果不是叶节点，则遍历它的子节点
        if (root.getLchild() != null) {
            findPath(root.getLchild(), i, stack, currentSum);
        }
        if (root.getRchild() != null) {
            findPath(root.getRchild(), i, stack, currentSum);
        }
        //在返回父节点之前，在路径上删除当前节点
        stack.pop();
    }
}

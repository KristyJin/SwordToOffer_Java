package JianzhiOffer;
/*
 *FileName:  No32
 * Author:   Kristy
 * Date  :   2019/7/26 10:39
 * */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树：
 * 题目一：不分行从上到下打印二叉树
 *      从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 题目二：分行从上到下打印二叉树
 *      从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印，每一层打印一行。
 */
public class No32 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.setLchild(node2);
        node1.setRchild(node3);
        node2.setLchild(node4);
        node2.setRchild(node5);
        node3.setLchild(node6);
        node3.setRchild(node7);

        print1(node1);
        System.out.println();
        print2(node1);
    }

    private static void print1(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getValue()+" ");
            if (node.getLchild() != null) {
                queue.add(node.getLchild());
            }
            if (node.getRchild() != null) {
                queue.add(node.getRchild());
            }
        }
    }

    private static void print2(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int pCount = 0;      //当前层结点数目
        int nextCount = 1;   //下一层结点数目
        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            //打印当前层数字，并计算下一层结点数目
            for (int i = 1; i <= pCount; i++) {
                node = queue.poll();
                System.out.print(node.getValue() + " ");
                if (node.getLchild() != null) {
                    queue.offer(node.getLchild());
                    nextCount++;
                }
                if (node.getRchild() != null) {
                    queue.offer(node.getRchild());
                    nextCount++;
                }
            }
            System.out.println();
        }
    }
}

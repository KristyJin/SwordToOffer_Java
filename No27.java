package JianzhiOffer;
/*
 *FileName:  No27
 * Author:   Kristy
 * Date  :   2019/7/25 20:33
 * */

/**
 * 二叉树的镜像：
 * 请完成一个函数，输入一颗二叉树，该函数输出它的镜像。
 */
public class No27 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.setLchild(b);
        a.setRchild(c);
        b.setLchild(d);
        b.setRchild(e);
        c.setLchild(f);
        c.setRchild(g);
        print(a);
        System.out.println();
        mirrorRecur(a);
        print(a);

    }
    private static void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.getValue()+" ");
            print(root.getLchild());
            print(root.getRchild());
        }
    }

    private static void mirrorRecur(TreeNode node){
        if(node == null)
            return;
        if(node.getLchild() == null && node.getRchild() == null)
            return;
        TreeNode temp = node.getLchild();
        node.setLchild(node.getRchild());
        node.setRchild(temp);

        if(node.getLchild() != null)
            mirrorRecur(node.getLchild());
        if(node.getRchild() != null)
            mirrorRecur(node.getRchild());

    }
}

package JianzhiOffer;
/*
 *FileName:  No28
 * Author:   Kristy
 * Date  :   2019/7/26 9:11
 * */

/**
 * 对称的二叉树：
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 思路：通过比较二叉树的前序遍历序列和对称前序遍历序列来判断，
 *      要考虑null指针。
 */
public class No28 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(9);//6
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(5);
        a.setLchild(b);
        a.setRchild(c);
        b.setLchild(d);
        b.setRchild(e);
        c.setLchild(f);
        c.setRchild(g);
        System.out.println(isSymm(a));
    }

    private static boolean isSymm(TreeNode root){
        return isSymm(root,root);
    }
    private static boolean isSymm(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.getValue() != root2.getValue())
            return false;
        return isSymm(root1.getLchild(),root2.getRchild())
                && isSymm(root1.getRchild(),root2.getLchild());
    }
}

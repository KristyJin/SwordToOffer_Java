package JianzhiOffer;
/*
 *FileName:  No26
 * Author:   Kristy
 * Date  :   2019/7/25 19:37
 * */


/**
 * 树的子结构：
 * 输入两颗二叉树A和B，判断B是不是A的子结构。
 */
public class No26 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode('8');
        TreeNode node2 = new TreeNode('8');
        TreeNode node3 = new TreeNode('7');
        TreeNode node4 = new TreeNode('9');
        TreeNode node5 = new TreeNode('2');
        TreeNode node6 = new TreeNode('4');
        TreeNode node7 = new TreeNode('7');
        node1.setLchild(node2);
        node1.setRchild(node3);
        node2.setLchild(node4);
        node2.setRchild(node5);
        node5.setLchild(node6);
        node5.setRchild(node7);

        TreeNode a = new TreeNode('8');
        TreeNode b = new TreeNode('9');
        TreeNode c = new TreeNode('2');
        a.setLchild(b);
        a.setRchild(c);
        System.out.println(HasSubtree(node1, a));
    }

    private static boolean HasSubtree(TreeNode root1, TreeNode root2){
        boolean result = false;
        if(root1!=null&& root2 != null){
            if(root1.getData() == root2.getData())
                result = DoesTree1HaveTree2(root1,root2);
            if(!result)
                result = HasSubtree(root1.getLchild(),root2);
            if(!result)
                result = HasSubtree(root1.getRchild(),root2);

        }
        return result;
    }

    private static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.getData() != root2.getData())
            return false;
        return DoesTree1HaveTree2(root1.getLchild(),root2.getLchild())
                && DoesTree1HaveTree2(root1.getRchild(),root2.getRchild());
    }
}

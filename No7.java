package JianzhiOffer;
/*
 *FileName:  No7
 * Author:   Kristy
 * Date  :   2019/7/22 9:43
 * */

/**
 * 前序遍历：根左右
 * 中序遍历：左根右
 * 后序遍历：左右根
 * 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class No7 {
    public static void main(String[] args) {
        String preOrder = "12473568";
        String midOrder = "47215386";
        BiTree tree = new BiTree(preOrder, midOrder, preOrder.length());
        tree.postRootTraverse(tree.root);//后序遍历
    }

    static class BiTree {
        TreeNode root;

        public BiTree(String preOrder, String midOrder, int count) {
            if (count <= 0) {
                return;
            }
            char c = preOrder.charAt(0);
            int i = 0;
            for (; i < count; i++) {
                if (midOrder.charAt(i) == c)
                    break;
            }

            root = new TreeNode(c);
            root.setLchild(new BiTree(preOrder.substring(1, i + 1), midOrder.substring(0, i), i).root);
            root.setRchild(new BiTree(preOrder.substring(i + 1), midOrder.substring(i + 1), count - i - 1).root);
        }


        public void postRootTraverse(TreeNode root) {
            if (root != null) {
                postRootTraverse(root.getLchild());
                postRootTraverse(root.getRchild());
                System.out.print(root.getData());
            }
        }
    }

    static class TreeNode {
        char data;
        TreeNode Lchild;
        TreeNode Rchild;

        public TreeNode(char data) {
            super();
            this.data = data;
        }

        public TreeNode(char data, TreeNode lchild, TreeNode rchild) {
            super();
            this.data = data;
            Lchild = lchild;
            Rchild = rchild;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public TreeNode getLchild() {
            return Lchild;
        }

        public void setLchild(TreeNode lchild) {
            Lchild = lchild;
        }

        public TreeNode getRchild() {
            return Rchild;
        }

        public void setRchild(TreeNode rchild) {
            Rchild = rchild;
        }
    }
}



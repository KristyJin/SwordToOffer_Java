package JianzhiOffer;
/*
 *FileName:  TreeNode
 * Author:   Kristy
 * Date  :   2019/7/25 18:10
 * */

/**
 * 树的定义如下：
 */
public class TreeNode {
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

package JianzhiOffer;
/*
 *FileName:  TreeNode
 * Author:   Kristy
 * Date  :   2019/7/25 18:10
 * */

/**
 * 树的定义如下：
 * 使用此结构体的函数No7、No26
 */
public class TreeNode {
    char data;
    int value;
    TreeNode Lchild;
    TreeNode Rchild;

    public TreeNode(char data) {
        super();
        this.data = data;
    }
    public TreeNode(int value) {
        super();
        this.value = value;
    }

    public TreeNode(char data,int value, TreeNode lchild, TreeNode rchild) {
        super();
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

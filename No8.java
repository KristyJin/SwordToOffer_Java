package JianzhiOffer;
/*
 *FileName:  No8
 * Author:   Kristy
 * Date  :   2019/7/22 9:43
 * */

/**
 * 二叉树的下一个节点：给定一个二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 */
public class No8 {
    public static void main(String[] args) {
        System.out.print("test1:");
        test1();
        System.out.print("test2:");
        test2();
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            System.out.print("结点为null ");
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while(pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }
        while(pNode.parent !=null){
            if(pNode==pNode.parent .left)
                return pNode.parent;
            pNode=pNode.parent;
        }
        return null;
    }


    // ==================================测试代码==================================
    //创建树较为繁琐，未包括所有测试代码。
    public static void test1() {
        TreeLinkNode node = null;
        TreeLinkNode nextNode = GetNext(node);
        if(nextNode!=null)
            System.out.println(nextNode.val);
        else
            System.out.println("无下一结点");
    }

    public static void test2() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node4.left=node1;
        node1.parent=node4;
        TreeLinkNode nextNodeOf1=GetNext(node1);
        TreeLinkNode nextNodeOf2=GetNext(node2);
        TreeLinkNode nextNodeOf3=GetNext(node3);
        TreeLinkNode nextNodeOf4=GetNext(node4);
        if(nextNodeOf1!=null)
            System.out.println("1结点的下一个结点值为："+nextNodeOf1.val);
        else
            System.out.println("1结点无下一结点");
        if(nextNodeOf2!=null)
            System.out.println("2结点的下一个结点值为："+nextNodeOf2.val);
        else
            System.out.println("2结点无下一结点");
        if(nextNodeOf3!=null)
            System.out.println("3结点的下一个结点值为："+nextNodeOf3.val);
        else
            System.out.println("3结点无下一结点");
        if(nextNodeOf4!=null)
            System.out.println("4结点的下一个结点值为："+nextNodeOf4.val);
        else
            System.out.println("4结点无下一结点");
    }

}


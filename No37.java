package JianzhiOffer;
/*
 *FileName:  No37
 * Author:   Kristy
 * Date  :   2019/7/26 11:27
 * */

/**
 * 序列号二叉树：
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class No37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.setLchild(node1);
        root.setRchild(node2);
        node1.setLchild(node3);
        node2.setLchild(node4);
        node2.setRchild(node5);

        System.out.println(serialize(root));
        TreeNode res = Deserialize(serialize(root));

    }

    private static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("$,");
        }else{
            sb.append(root.getValue() + ",");
            sb.append(serialize(root.getLchild()));
            sb.append(serialize(root.getRchild()));
        }
        return sb.toString();
    }

    static int index = 0;
    private static TreeNode Deserialize(String str) {

        TreeNode node = null;
        if (str == null || str.length() == 0)
            return node;
        int start = index;
        while (str.charAt(index) != ',')
            index++;
        if (!str.substring(start, index).equals("$")) {
            node = new TreeNode(Integer.parseInt(str.substring(start, index)));
            index++; // 这条语句位置别放错了
            node.Lchild = Deserialize(str);
            node.Rchild = Deserialize(str);
        } else {
            index++;
        }
        return node;
    }
}

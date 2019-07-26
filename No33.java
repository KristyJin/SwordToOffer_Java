package JianzhiOffer;
/*
 *FileName:  No33
 * Author:   Kristy
 * Date  :   2019/7/26 10:51
 * */

/**
 * 二叉搜索树的后序遍历序列：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 假设输入数组的任意两个数字都互不相同。
 * 例如，输入数组{5,7,6,9,11,10,8}
 */
public class No33 {
    public static void main(String[] args) {
        int[] nums = {5,7,6,9,11,10,8};
        System.out.println(verfiySequenceOfBST(nums, 0, nums.length-1));

    }

    private static boolean verfiySequenceOfBST(int[] array, int start, int end) {
        if (array == null || start > end || start < 0 || end < 0)
            return false;

        if (start == end)
            return true;

        int root = array[end];

        //在二叉搜索树中左子树节点的值小于根节点的值
        int i = start;
        for (; i <= end; i++) {
            if (array[i] > root)
                break;
        }

        //在二叉搜索树中右子树节点的值大于根节点的值
        int j = i;
        for (; j <= end; j++) {
            if (array[j] < root)
                return false;
        }

        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > start) {
            left = verfiySequenceOfBST(array, start, i - 1);
        }

        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < end) {
            right = verfiySequenceOfBST(array, i, end - 1);
        }
        return (left && right);
    }
}

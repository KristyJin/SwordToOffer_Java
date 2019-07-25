package JianzhiOffer;
/*
 *FileName:  No4
 * Author:   Kristy
 * Date  :   2019/7/20 13:40
 * */

/**
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增
 * 的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组
 * 和一个整数，判断数组中是否函数该整数。
 */
public class No4 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        System.out.println(search(nums, 11));
        System.out.println(nums.length);
    }

    private static boolean search(int[][] nums, int value) {
        int column = nums[0].length;
        int row = nums.length;
        int i = 0;
        int j = column - 1;

        while (i <= row - 1 && j >= 0) {
            System.out.println("row:" + i + " column:" + j);
            if (nums[i][j] == value)
                return true;
            if (nums[i][j] > value)
                j--;
            else
                i++;
        }
        return false;
    }
}

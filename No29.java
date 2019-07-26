package JianzhiOffer;
/*
 *FileName:  No29
 * Author:   Kristy
 * Date  :   2019/7/26 9:20
 * */

import java.util.ArrayList;

/**
 * 顺时针打印矩阵：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如：依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 */
public class No29 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        /*
         * 解题思路：顺时针打印就是按圈数循环打印，一圈包含两行或者两列，在打印的时候会
         * 出现某一圈中只包含一行，要判断从左向右打印和从右向左打印的时候是否会出现重复打印，
         * 同样只包含一列时，要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况
         */
        System.out.println(printNums(nums));
        /*
         * 每次打印矩阵最外面的一圈（用方法printMatrixInCircle()表示），
         * 每次都是这个操作，所以可以采用递归。每次打印矩阵的左上角的横纵坐标相同，即为start，
         * 而其余三个角的坐标都与行列数以及start有关，因此只需要for循环即可实现打印。
         * 当然，其实只要针对start进行循环判断，start*2的值小于行数和列数时才需要继续打印，
         * 这样，通过这个条件，可以用循环来打印每次的最外圈矩阵
         */
        printMatrix(nums);
    }

    private static ArrayList<Integer> printNums(int[][] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int rows = nums.length;
        int cols = nums[0].length;
        res.clear();
        //计算打印的圈数
        int circle = ((rows < cols ? rows : cols) - 1) / 2 + 1;//圈数
        for (int i = 0; i < circle; i++) {
            //从左向右打印
            for (int j = i; j < cols - i; j++)
                res.add(nums[i][j]);
            //从上往下的每一列数据
            for (int k = i + 1; k < rows - i; k++)
                res.add(nums[k][cols - 1 - i]);
            //判断是否会重复打印(从右向左的每行数据)
            for (int m = cols - i - 2; (m >= i) && (rows - i - 1 != i); m--)
                res.add(nums[rows - i - 1][m]);
            //判断是否会重复打印(从下往上的每一列数据)
            for (int n = rows - i - 2; (n > i) && (cols - i - 1 != i); n--)
                res.add(nums[n][i]);
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0)
            return;
        printMatrixInCircle(matrix, 0);
    }

    private static void printMatrixInCircle(int[][] matrix, int start) {
        int row = matrix.length;
        int col = matrix[0].length;
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        if (endX < start || endY < start)
            return;
        //仅一行
        if (endY == start) {
            for (int i = start; i <= endX; i++) {
                System.out.print(matrix[start][i] + " ");
            }
            return;  //记得结束
        }
        //仅一列
        if (endX == start) {
            for (int i = start; i <= endY; i++) {
                System.out.print(matrix[i][start] + " ");
            }
            return;  //记得结束
        }

        //打印边界
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i] + " ");
        }
        for (int i = start + 1; i <= endY; i++) {
            System.out.print(matrix[i][endX] + " ");
        }
        for (int i = endX - 1; i >= start; i--) {
            System.out.print(matrix[endY][i] + " ");
        }
        for (int i = endY - 1; i >= start + 1; i--) {
            System.out.print(matrix[i][start] + " ");
        }

        //继续打印更内部的矩阵，令start+1
        printMatrixInCircle(matrix, start + 1);
    }
}

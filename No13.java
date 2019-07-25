package JianzhiOffer;
/*
 *FileName:  No13
 * Author:   Kristy
 * Date  :   2019/7/25 10:24
 * */

/**
 * 机器人的运动范围：
 * 地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次可以向左、右、上、下移动一格，
 * 但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k=18时，机器人能够进入方格(35，37)，因为3+5+3+7=18。但是不能进入(35，38)，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 */
public class No13 {
    public static void main(String[] args) {
        int count = movingCount(5, 10, 10); //21
        System.out.println(count);

        int count1 = movingCount(15, 20, 20); //359
        System.out.println(count1);

        int count2 = movingCount(0, 1, 1); //1
        System.out.println(count2);

        int count3 = movingCount(-2, 1, 1); //0
        System.out.println(count3);

    }

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    //访问的是当前的单元
    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    //判断是否可以到达
    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row][col])
            return true;
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

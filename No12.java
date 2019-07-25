package JianzhiOffer;
/*
 *FileName:  No12
 * Author:   Kristy
 * Date  :   2019/7/25 9:31
 * */

/**
 * 矩阵中的路径：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径，
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面3*4的矩阵中包含一条字符串“bfce”的路径。但矩阵中不包含字符串“abfb”的路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * a  b  t  g
 * c  f  c  s
 * j  d  e  h
 */
public class No12 {
    public static void main(String[] args) {
        String matrix = "abtgcfcsjdeh";
        char[] matrix1 = matrix.toCharArray();
        String str = "bfce";
        char[] str1 = str.toCharArray();
        System.out.println(hasPath(matrix1,3,4, str1));
    }

    private static boolean hasPath(char[] matrix, int rows,int cols, char[] str) {
        if (matrix.length <= 0 || rows < 1 || cols < 1 || str.length <= 0)
            return false;

        boolean visited[] = new boolean[rows * cols];
        int len = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix,rows,cols, i, j, str, len, visited))
                    return true;
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows,int cols,int row, int col, char[] str, int len, boolean[] visited) {
        if (len == str.length)
            return true;

        boolean flag = false;
        //当前点折算到原数组的位置是：row * cols + col
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[len] && !visited[row * cols + col]) {
            ++len;
            visited[row * cols + col] = true;
            //第一个点是合法的起点之后开始回溯:上下左右进行搜索
            flag = hasPathCore(matrix,rows, cols, row, col - 1, str, len, visited)
                    || hasPathCore(matrix,rows, cols, row - 1, col, str, len, visited)
                    || hasPathCore(matrix,rows, cols, row, col + 1, str, len, visited)
                    || hasPathCore(matrix,rows, cols, row + 1, col, str, len, visited);
            if (!flag) {//恢复现场
                --len;
                visited[row * cols + col] = false;
            }
        }
        return flag;
    }
}

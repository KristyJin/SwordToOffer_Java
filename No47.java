package JianzhiOffer;

/**
 * 礼物的最大价值： 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格，直到到达棋盘的右下角。 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class No47 {
	//
	private static int method1(int[][] values) {
		int rows = values.length;
		int cols = values[0].length;
		if (values == null || rows <= 0 || cols <= 0)
			return 0;
		int[][] maxValue = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0)
					up = maxValue[i - 1][j];
				if (j > 0)
					left = maxValue[i][j - 1];
				maxValue[i][j] = Math.max(up, left) + values[i][j];
			}
		}
		return maxValue[rows - 1][cols - 1];
	}

	//优化后的代码
	private static int method2(int[][] values) {
		int rows = values.length;
		int cols = values[0].length;
		if (values == null || rows <= 0 || cols <= 0)
			return 0;
		int[] maxValue = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0)
					up = maxValue[j];
				if (j > 0)
					left = maxValue[j - 1];
				maxValue[j] = Math.max(up, left) + values[i][j];
			}
		}
		return maxValue[cols - 1];
	}

	public static void main(String[] args) {
		int[][] values = {
				{1,10,3,8},
				{12,2,9,6},
				{5,7,4,11},
				{3,7,16,5}};
		System.out.println(method1(values));
		System.out.println(method2(values));
	}
}

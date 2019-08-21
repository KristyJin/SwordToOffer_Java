package JianzhiOffer;

/**
 * 丑数： 把只包含2、3、5的数成为丑数ugly number。
 * 求按从小到大的顺序的第1500个丑数.例如，6、8都是丑数，但14不是，因为包含因子7.习惯上把1当作第一个丑数
 */
public class No49 {
	private static boolean isUgly(int num) {
		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return (num == 1) ? true : false;
	}

	private static int getUglyNum(int num) {
		if (num <= 0)
			return 0;
		int count = 0;
		int found = 0;
		while (found < num) {
			++count;
			if (isUgly(count))
				++found;
		}
		return count;
	}

	private static int getUglyNum1(int num) {
		if (num <= 0)
			return 0;
		int[] uglyNums = new int[num];
		uglyNums[0] = 1;
		int nextUglyIndex = 1;
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		while (nextUglyIndex < num) {
			int min = (uglyNums[multiply2] * 2 < uglyNums[multiply3] * 3) ? uglyNums[multiply2] * 2 : uglyNums[multiply3] * 3;
			min = (min < uglyNums[multiply5] * 5) ? min : uglyNums[multiply5] * 5;
			uglyNums[nextUglyIndex] = min;
			while (uglyNums[multiply2] * 2 <= uglyNums[nextUglyIndex])
				++multiply2;
			while (uglyNums[multiply3] * 3 <= uglyNums[nextUglyIndex])
				++multiply3;
			while (uglyNums[multiply5] * 5 <= uglyNums[nextUglyIndex])
				++multiply5;
			++nextUglyIndex;
		}
		return uglyNums[nextUglyIndex - 1];
	}

	public static void main(String[] args) {
		// 逐个判断每个整数是不是丑数，直观但不够高效
		//System.out.println(getUglyNum(1500));
		// 创建数组保存已经找到的丑数，用空间换时间
		System.out.println(getUglyNum1(1500));
	}
}

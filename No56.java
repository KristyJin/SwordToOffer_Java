package JianzhiOffer;

/**
 * 数组中数字出现的次数：
 */
public class No56 {
	/*
	 * 题目一：数组中只出现一次的两个数字 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
	 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
	 */
	public static void FindNumsAppearOnce(int[] array) {
		if (array == null || array.length < 2)
			return;
		int resultExclusiveOR = 0;
		for (int i = 0; i < array.length; i++)
			resultExclusiveOR ^= array[i];

		int indexOf1 = 0;
		while (((resultExclusiveOR & 1) == 0) && (indexOf1 <= 4 * 8)) {
			resultExclusiveOR = resultExclusiveOR >> 1; // 只有n>>1不完整，要n=n>>1
			indexOf1++;
		}

		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (((array[i] >> indexOf1) & 1) == 1)
				num1 ^= array[i];
			else
				num2 ^= array[i];
		}
		System.out.println(num1 + " " + num2);
	}

	/*
	 * 题目二：数组中唯一只出现一次的数字 
	 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
	 */
	public static int findNumberAppearingOnce(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException();
		int[] bitSum = new int[32];
		for (int i = 0; i < 32; i++)
			bitSum[i] = 0;
		for (int i = 0; i < arr.length; i++) {
			int bitMask = 1;
			for (int j = 31; j >= 0; j--) {
				int bit = arr[i] & bitMask; // 注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
				if (bit != 0)
					bitSum[j] += 1;
				bitMask = bitMask << 1;
			}
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result << 1;
			result += (bitSum[i] % 3);
			// result=result<<1; //不能放在后面，否则最前面一位就没了
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 3, 6, 3, 2, 5, 5 };
		FindNumsAppearOnce(nums);
		System.out.println(findNumberAppearingOnce(nums));
	}
}

package JianzhiOffer;

import java.util.ArrayList;

/**
 * 和为S的数字：
 */
public class No57 {
	/*
	 * 题目一：和为S的两个数字。 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。 如果有多对数字的和等于s，输出任意一对即可。
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (array == null || array.length <= 0)
			return list;
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (array[low] + array[high] == sum) {
				list.add(array[low]);
				list.add(array[high]);
				break;
			} else if (array[low] + array[high] < sum)
				low++;
			else
				high--;
		}
		return list;
	}

	/*
	 * 题目二：和为S的连续正数序列。 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
	 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
	 */
	// 方法一：采用两个指针的方法
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<ArrayList<Integer>>();
		if (sum <= 0)
			return sequenceList;

		int small = 1;
		int big = 2;
		int curSum = small + big;
		while (small <= sum / 2) {
			if (curSum == sum) {
				ArrayList<Integer> sequence = new ArrayList<Integer>();
				for (int i = small; i <= big; i++)
					sequence.add(i);
				sequenceList.add(sequence);
				curSum -= small;
				small++; // 这两行位置先后要注意
			}
			if (curSum < sum) {
				big++;
				curSum += big;
			}
			if (curSum > sum) {
				curSum -= small;
				small++;
			}
		}
		return sequenceList;
	}

	// 方法二：数学分析法
	public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
		ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<ArrayList<Integer>>();
		if (sum <= 0)
			return sequenceList;

		for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
			if (((n & 1) == 1 && sum % n == 0) || ((n & 1) == 0 && (sum % n) * 2 == n)) {
				ArrayList<Integer> sequence = new ArrayList<>();
				for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
					sequence.add(k);
				}
				sequenceList.add(sequence);
			}
		}
		return sequenceList;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,4,7,11,15};
		No57 test = new No57();
		System.out.println(test.FindNumbersWithSum(nums, 15));
		System.out.println(test.FindContinuousSequence(15));
		System.out.println(test.FindContinuousSequence1(15));
	}
}

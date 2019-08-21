package JianzhiOffer;

/**
 * 连续子数组的最大和：
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为o(n)
 */
public class No42 {
	public static void main(String[] args) {
		int[] nums = {1,-2,3,10,-4,7,2,-5};
		int[] nums1 = new int[nums.length];
		System.arraycopy(nums, 0, nums1, 0, nums.length);
		System.out.println(FindGreatestSumOfSubArray(nums));
	}
	
	//解法一：举例分析数组的规律
	public static int FindGreatestSumOfSubArray(int[] nums) {
		if(nums == null || nums.length <= 0) {
			return 0;
		}
		int sum = 0;
		int maxSum = 0x80000000;
		for (int i = 0; i < nums.length; i++) {
			if(sum <= 0)
				sum = nums[i];
			else 
				sum += nums[i];
			
			if(sum > maxSum)
				maxSum = sum;
		}
		
		return maxSum;
	}
	//解法二：应用动态规划法
	/*
	* 递归公式： 
	* fi = nums[i], i = 0 或者f(i-1) <= 0 
	* fi = f(i-1) + nums[i], i != 0并且f(i-1) > 0
	*/
	
}

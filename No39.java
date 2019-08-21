package JianzhiOffer;
/*
 *FileName:  No39
 * Author:   Kristy
 * Date  :   2019/8/1 9:49
 * */

/**
 * 数组中出现次数超过一半的数字：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入一个长度为9的数组{1，2，3，2，2，2，5，4，2}.
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2.
 */
public class No39 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        //int[] nums = {1, 2, 3, 2, 5, 4};
        //方法一：基于partition函数的时间复杂度为o(n)的算法
        System.out.println(method1(nums));
        //方法二：根据数组特点找出时间复杂度为o(n)的算法
        System.out.println(method2(nums));
    }
    /*
     * 遍历数组时保存两个值，一个数组中的一个数字，另一个是次数。
     * 当遍历到下一个数字的时候，如果下一个数字和当前保存数字相同，次数加一；
     * 反之，如果不同，次数减一；次数为零，就需要保存下一个数字，并把次数设为1。
     */
    private static int method2(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int res = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if(times == 0){
                res = nums[i];
                times = 1;
            }
            else if (nums[i] == res)
                times++;
            else times--;
        }
        if (!CheckMoreThanHalf(nums, res))
            return 0;
        return res;
    }

    private static int method1(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int mid = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int res = nums[mid];
        if (!CheckMoreThanHalf(nums, res))
            return 0;
        return res;
    }

    public static int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while (start < end) {
            while (start < end && key <= nums[end]) {
                end--;
            }
            swap(nums, start, end);
            while (start < end && key >= nums[start]) {
                start++;
            }
            swap(nums, start, end);
        }
        nums[start] = key;
        return start;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }

    //如果输入的数组中出现频率最高的数字都没有达到超过数组长度一半，返回0
    private static boolean CheckMoreThanHalf(int[] nums, int number) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number)
                times++;
        }
        boolean isMoreThanHalf = true;
        if (times * 2 <= nums.length)
            isMoreThanHalf = false;
        return isMoreThanHalf;
    }

}

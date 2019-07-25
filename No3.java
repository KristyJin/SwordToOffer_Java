package JianzhiOffer;
/*
 *FileName:  No3
 * Author:   Kristy
 * Date  :   2019/7/19 14:18
 * */

import java.util.Arrays;
import java.util.HashSet;

/**
 * 数组中重复的数字
 */
public class No3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        //int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        //方法一：排序后查找O(nlogn)
        method1(nums);
        System.out.println();
        //方法二：利用哈希表O(n)
        method2(nums);
        System.out.println();
        //方法三：排序使第i个位置的数字为,仅判断数组中是否含有重复数字O(n)
        System.out.println(method3(nums));

        //不修改数组找出重复的数字：找出任意一个重复的数组，但不修改输入的数组
        //创建一个长度为n+1的辅助数组，复制后，将m复制到下标为m的位置o(n)
        System.out.println(getDup(nums));
    }

    private static void method1(int[] nums) {
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                System.out.print(temp + " ");
            } else {
                temp = nums[i];
            }
        }

    }

    private static void method2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                System.out.print(i + " ");
            }
        }

    }

    private static boolean method3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return true;
                }
                //交换nums[i]和nums[nums[i]]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return false;
    }

    public static int getDup(int[] nums) {
        if (nums.length <= 0 || nums == null)
            return -1;
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            int count = countRange(nums, start, mid);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }

            if (count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int countRange(int[] nums, int start, int end) {
        if (nums == null)
            return -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end)
                ++count;
        }
        return count;
    }

}

package JianzhiOffer;
/*
 *FileName:  No11
 * Author:   Kristy
 * Date  :   2019/7/23 16:32
 * */

/**
 * 旋转数组的最小数字：
 * 把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组{3，4，5，1，2}为{1，2，3，4，5}的一个旋转，该数组的最小值为1.
 */
public class No11 {
    private static int min(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int index1 = 0, index2 = nums.length - 1, mid = index1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }
            mid = (index1 + index2) / 2;
            if (nums[mid] >= nums[index1])
                index1 = mid;
            else if (nums[mid] <= nums[index2])
                index2 = mid;
        }
        return nums[mid];
    }

    private static int min1(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int index1 = 0, index2 = nums.length - 1, mid = index1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }
            mid = (index1 + index2) / 2;

            //如果下表为index1、index2和mid指向的三个数组相等，则只能顺序查找
            if (nums[index1] == nums[index2]&&nums[mid] == nums[index1])
                return minInorder(nums,index1,index2);

            if (nums[mid] >= nums[index1])
                index1 = mid;
            else if (nums[mid] <= nums[index2])
                index2 = mid;
        }
        return nums[mid];
    }

    private static int minInorder(int[] nums, int index1, int index2){
        int res = nums[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if(res>nums[i])
                res = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(min(nums));

        int[] nums1 = {0,1,1,1,1};
        System.out.println(min1(nums1));
    }
}

package JianzhiOffer;
/*
 *FileName:  No40
 * Author:   Kristy
 * Date  :   2019/8/7 10:10
 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 最小的K个数：
 * 输入n个整数，找出其中最小的k个数。
 * 例如，输入4,5,1,6,2,7,3,8这8个数组，则最小的4个数为1,2,3,4
 */
public class No40 {
    public static void main(String[] args) {
        int[] nums = {4,5,1,6,2,7,3,8};
        int k = 4;
        //方法一：时间复杂度为o(n)的算法，只有当我我们可以修改输入的数组时可用
        System.out.println(method1(nums,k));
        //方法二：时间复杂度为o(nlogn)的算法，特别适合处理海量数据
        System.out.println(method2(nums,k));
    }
    private static ArrayList<Integer> method1(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 0 || k > nums.length || k < 0)
            return list;
        int start = 0;
        int end = nums.length - 1;
        int index = No39.partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = No39.partition(nums, start, end);
            } else {
                start = index + 1;
                index = No39.partition(nums, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        return list;
    }
    private static ArrayList<Integer>  method2(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 0 || k > nums.length || k < 0)
            return list;
        TreeSet<Integer> kSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (kSet.size() < k) {
                kSet.add(nums[i]);
            } else if (nums[i] < kSet.last()) {
                kSet.remove(kSet.last());
                kSet.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = kSet.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}

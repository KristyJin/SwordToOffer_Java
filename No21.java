package JianzhiOffer;
/*
 *FileName:  No21
 * Author:   Kristy
 * Date  :   2019/7/25 17:14
 * */

/**
 * 调整数组顺序使奇数位于偶数前面：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

public class No21 {
    public static void main(String[] args) {
        int[] array = {3, 7, 4, 8, 23, 56, 77, 89, 46, 11, 66, 77};
        reorder(array);
        for (int a : array) {
            System.out.println(" " + a);
        }
    }

    //普通模式
    private static void reorder(int[] array) {
        if (array == null || array.length == 0)
            return;
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            //向后移动begin，直到它指向偶数
            while (begin < end && (begin & 0x1) != 0)//!isEven(array[begin])
                begin++;
            //向前移动end，直到它指向奇数
            while (begin < end && (end & 0x1) == 0)//isEven(array[end])
                end--;

            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
            if (begin >= end)
                break;
        }
    }

    //划分数组的标准，奇数偶数分为两部分
    //解耦的好处就是提高代码的重用性，为功能扩展提供便利
    private static boolean isEven(int i) {
        return (i & 0x1) == 0;

        //如果要求变为负数移到非负数前面
        //return i < 0;
        //%3==0移动到%3!=0前面
        //return i % 3 == 0;
    }
}


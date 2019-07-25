package JianzhiOffer;
/*
 *FileName:  No5
 * Author:   Kristy
 * Date  :   2019/7/22 9:42
 * */

import java.util.Arrays;

/**
 * 替换空格：
 * java字符串使用endsWith判断结尾
 * c/c++以字符'\0'作为结尾
 * 替换空格：实现一个函数，将字符串中的每个空格替换成"%20".
 */
public class No5 {
    public static void main(String[] args) {
        String str = "We are happy.";

        ////时间复杂度为O(n)
        char[] chars = str.toCharArray();
        System.out.println(replace(chars));

        /**
         * 有两个排序的数组A1和A2，把A2的所有数字插入A1，所有数字都是排序的
         */
        int[] A = {1, 7, 9};
        int[] B = {2, 4, 6};
        System.out.println(Arrays.toString(method(A, B)));

    }

    private static String replace(char[] charArray) {
        int count = 0;
        for (char i : charArray) {
            if (i == ' ')
                count++;
        }
        if (count == 0)
            return null;

        //增加长度，从后往前添加替换
        char[] temp = new char[charArray.length + 2 * count];
        int i = charArray.length - 1;
        int j = charArray.length + 2 * count - 1;
        while (i >= 0) {
            if (charArray[i] == ' ') {
                temp[j] = '0';
                temp[j - 1] = '2';
                temp[j - 2] = '%';
                j = j - 3;
            } else {
                temp[j] = charArray[i];
                j--;
            }
            i--;
        }
        return new String(temp);
    }

    private static int[] method(int[] A, int[] B) {
        if (A == null && B == null) {
            return null;
        }
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        int[] result = new int[A.length + B.length];
        int startA = 0;
        int startB = 0;
        int startResult = 0;
        while (startA < A.length && startB < B.length) {
            if (A[startA] > B[startB]) {
                result[startResult++] = B[startB++];
            } else {
                result[startResult++] = A[startA++];
            }
        }
        while (startA < A.length) {
            result[startResult++] = A[startA++];
        }
        while (startB < B.length) {
            result[startResult++] = B[startB++];
        }
        return result;

    }
}

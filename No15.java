package JianzhiOffer;
/*
 *FileName:  No15
 * Author:   Kristy
 * Date  :   2019/7/25 11:13
 * */

/**
 * 位运算：
 * 二进制中1的个数：
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如，9表示成二进制是1001，两位数为1.
 */
public class No15 {
    public static void main(String[] args) {
        System.out.println(method1(9));
        System.out.println(method2(9));
        System.out.println(getNum(9));
    }

    //可能引起死循环的解法
    private static int method1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                count++;
            n = n >> 1;
        }

        return count;
    }

    //常规解法
    private static int method2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }

        return count;
    }

    //最好的解法
    public static int getNum(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}

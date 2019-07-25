package JianzhiOffer;
/*
 *FileName:  No16
 * Author:   Kristy
 * Date  :   2019/7/25 11:23
 * */


/**
 * 数值的整数次方：
 * 实现函数double Power(double base, int exponent),求base的exponent次方。
 * 不能使用库函数，同时不需要考虑大数问题。
 */
public class No16 {
    public static void main(String[] args) {
        System.out.println(Power(2.0, 3));
        System.out.println(Power1(2.0, -3));
        System.out.println(Power2(2.0, 16));
    }

    //最简单的解法，但是没有考虑到exponent指数小于1的情况
    private static double Power(double base, int exponent) {
        double res = 1.0;
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        return res;
    }

    //全面但不高效，考虑指数小于1的情况

    private static double Power1(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            return 0.0;
        }
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;

        int absExponent = exponent;
        if (exponent < 0)
            absExponent = -exponent;
        double res = 1.0;
        for (int i = 1; i <= absExponent; i++) {
            res *= base;
        }
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }

    //书上说全面且高效的解法，但仍然没有处理exponent<0的情况
    private static double Power2(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        double res = Power2(base, exponent >> 1);
        return (((exponent & 0x1) == 1) ? base : 1.0) * res * res;
    }
}

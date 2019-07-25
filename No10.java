package JianzhiOffer;
/*
 *FileName:  No10
 * Author:   Kristy
 * Date  :   2019/7/23 9:15
 * */


/**
 * 斐波那契数列：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 * 定义如下：0，1，1，2，3，5，8，13，21...
 *
 * 青蛙跳台阶问题：一只青蛙一次可以跳上一级台阶，也可以跳上2级台阶。求该青蛙跳上n级的台阶总共有多少种跳法。
 * 本质斐波那契
 */
public class No10 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("递归方法--第" + n + "项值为：" + Fibonacci(n));
        System.out.println("非递归方法--第" + n + "项值为：" + Fibonacci1(n));


    }

    //递归方法
    private static long Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //非递归方法解决
    private static long Fibonacci1(int n){
        int[] result = {0,1};
        if(n<2)
            return result[n];
        long minusOne = 1;
        long minusTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = fibN;
        }
        return fibN;
    }
}

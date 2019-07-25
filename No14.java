package JianzhiOffer;
/*
 *FileName:  No14
 * Author:   Kristy
 * Date  :   2019/7/25 11:10
 * */

/**
 * 动态规划和贪心算法
 * 剪绳子：
 * 给你一根长度为n的绳子，请把绳子剪成m段(m、n都是整数，n>1并且m>1)，每段绳子长度记为k[0],k[1]...k[m]。
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度为2，3，3的三段，此时得到的最大乘积是18.
 */
public class No14 {
    public static void main(String[] args) {
        //几组测试值：(1,0),(2,1),(3,2),(4,4),(5,6),(8,18),(10,36),(50,86093442)
        int length = 8, expected = 18;
        System.out.println("期待值:" + expected);
        System.out.println("动态规划:" + maxProductAftercutting_solution1(length));
        System.out.println("贪婪算法:" + maxProductAftercutting_solution2(length));

    }

    //常规的o(n^2)时间和o(n)空间的动态规划思路
    private static int maxProductAftercutting_solution1(int len) {
        if (len < 2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        // 用于存放最大乘积值
        int[] products = new int[len + 1];
        // 下面几个不是乘积，因为其本身长度比乘积大
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        // 开始从下到上计算长度为i绳子的最大乘积值product[i]
        for (int i = 4; i <= len; i++) {
            int max = 0;
            // 算不同子长度的乘积，找出最大的乘积
            for (int j = 1; j <= i / 2; j++) {
                if (max < products[j] * products[i - j])
                    max = products[j] * products[i - j];
            }
            products[i] = max;
        }

        return products[len];
    }

    //只需要o(1)时间和空间的贪婪算法思路
    private static int maxProductAftercutting_solution2(int len) {
        if (len < 2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        /*//尽可能多地剪去长度为3的绳子段
        int timeOf3 = len / 3;
        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        //此时更好的方法是把绳子剪成长度为2的两段，因为2*2>3*1
        if (len - timeOf3 * 3 == 1)
            timeOf3--;
        int timeOf2 = (len - timeOf3 * 3) / 2;
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));*/


        int timesOf3=len/3;
        if(len%3==0)
            return (int)Math.pow(3, timesOf3);
        if(len%3==1)
            return (int)Math.pow(3, timesOf3-1)*4;  //是乘以4，不是2
        return (int)Math.pow(3, timesOf3)*2;
    }
}

package JianzhiOffer;
/*
 *FileName:  No17
 * Author:   Kristy
 * Date  :   2019/7/25 11:50
 * */

/**
 * 打印从1到最大的n位数：
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。
 * 例如，输入3，打印出从1、2、3到最大的三位数999.
 */
public class No17 {
    public static void main(String[] args) {
        method1(3);
        method2(3);
    }

    //最简单的，但是n很大的时候，溢出
    private static void method1(int n) {
        int num = 1;
        int i = 0;
        while (i++ < n)
            num *= 10;
        for (i = 1; i < num; i++) {
            System.out.print(i + " ");
        }
    }

    private static void method2(int n) {
        if (n < 0)
            return;
        int[] array = new int[n];
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n) {

        if (n != array.length) {
            for (int i = 0; i < 10; i++) {
                array[n] = i;
                printArray(array, n + 1);
            }
        } else {
            boolean flag = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0) {
                    flag = true;
                }
                if (flag) {
                    System.out.print(array[j]);
                }
            }
            // 去掉空白行
            if (flag) {
                System.out.print(" ");
            }
        }
    }

}

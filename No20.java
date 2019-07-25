package JianzhiOffer;
/*
 *FileName:  No20
 * Author:   Kristy
 * Date  :   2019/7/25 15:55
 * */

/**
 * 表示数值的字符串：
 * 实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.14.6"以及"-1e-16"都表示数值，
 * 但是"12e","1a3.14","1.2.3","+-5",以及"12e+5.4"都不是。
 */
public class No20 {
    int p = 0;
    int n = 0;
    public static void main(String[] args) {
        No20 demo = new No20();
        String str = "+123.123e+123";
        boolean res = demo.isNumeric1(str.toCharArray());
        System.out.println(res);
    }
    public boolean isNumeric1(char[] str) {
        if (str == null) return false;
        boolean isNum = false;
        n = str.length;
        // 判断有无正负号，有的话p会移动到下一位
        if (str[p] == '+' || str[p] == '-') {
            p++;
        }
        // 再判断是否是个整数
        isNum = isUnsignInte(str);
        // 当返回时 p可能==n  也可能遇到了非数字的字符
        // p<n 一定在前，否则 str[p]会出现越界现象。
        if (p < n && str[p] == '.') {
            p++;
            // 参考剑指，这个地方三种情况  小数点前为有数 或者 小数点后有数// .B和A.和A.B形式均可以
            isNum = isUnsignInte(str) || isNum;
        }
        // p<n ！ 判断是否存在指数部分
        if (p < n && (str[p] == 'e' || str[p] == 'E')) {
            p++;
            if (p < n && str[p] == '+' || str[p] == '-') {
                p++;
            }
            isNum = isUnsignInte(str) && isNum;
        }

        return isNum && p == n;
    }

    public boolean isUnsignInte(char[] str) {
        int before = p;
        while (p < n && Character.isDigit(str[p])) {
            p++;
        }
        return p > before;
    }
}

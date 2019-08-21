package JianzhiOffer;

/**
 * 不用加减乘除做加法： 写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 */
public class No65 {
	public static int add(int num1, int num2) {
		while (num2 != 0) {
			int sum = num1 ^ num2; // 没进位的和
			int carry = (num1 & num2) << 1; // 进位
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}
	public static void main(String[] args) {
		System.out.println(add(10, 2));
	}
}

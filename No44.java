package JianzhiOffer;
/**
 * 数字序列中某一位的数字：
 * 数字以0123456789101112131415...的格式序列化到一个字符序列中。
 * 在这个序列中，第5位(从0开始计数)是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 */
public class No44 {
	/*
	 * 序列的前10位是0-9
	 * 接下来180位是90个10-99
	 * 接下来的2700位是900个100-999
	 * 以此类推。。。
	 */
	public static int digitAtIndex(int index) {
		if(index < 0)
			return -1;
		int digits = 1;
		while(true) {
			int numbers = countOfIntegers(digits);
			if(index < numbers * digits)
				return digitAtIndex(index,digits);
			index -= digits * numbers;
			digits++;
		}
	}
	//得到m位的数字总共有多少个
	public static int countOfIntegers(int digits) {
		if(digits == 1)
			return 10;
		int count = (int)Math.pow(10, digits-1);
		return 9*count;
	}
	//要找的数字位于某m位数之中后，找出那一位数字
	public static int digitAtIndex(int index, int digits) {
		int number = beginNumber(digits) + index/digits;
		int indexFromRight = digits - index%digits;
		for (int i = 1; i < indexFromRight; i++) {
			number /= 10;
		}
		return number%10;
	}
	//m位数的第一个数字
	public static int beginNumber(int digits) {
		if(digits == 1)
			return 0;		
		return (int)Math.pow(10, digits-1);
	}
	public static void main(String[] args) {
		//功能测试：10，190，1000，0，1，
		System.out.println(digitAtIndex(19));
	}
}

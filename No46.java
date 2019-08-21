package JianzhiOffer;
/**
 * 把数字翻译成字符串：
 * 给定一个数字，我们按照如下规则把它翻译成字符串：0翻译成“a”，1翻译成“b”，。。。，11翻译成“l”，25翻译成“z”。
 * 一个数字可能有多个翻译。例如，12258有5种不同的翻译，分别是 “bccfi”,"bwfi","bczi","mcfi"和“mzi”。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class No46 {
	public static void main(String[] args) {
		System.out.println(GetTranslationCount(12258));
	}
	private static int GetTranslationCount(int num) {
		if(num < 0)
			return 0;
		String str = String.valueOf(num);
		int len = str.length();
		int[] counts = new int[len];
		int count = 0;
		for (int i = len - 1; i >= 0; --i) {
			count = 0;
			if(i<len-1)
				count = counts[i+1];
			else
				count = 1;
			if(i<len-1) {
				int digit1 = str.charAt(i) - '0';
				int digit2 = str.charAt(i+1) - '0';
				int convert = digit1 *10 + digit2;
				if(convert >= 10 && convert <= 25) {
					if(i<len-2)
						count += counts[i+2];
					else
						count += 1;
				}
			}
			counts[i] = count; 
		}
		count = counts[0];
		return count;
	}
}

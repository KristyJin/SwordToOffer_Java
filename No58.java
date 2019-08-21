package JianzhiOffer;

/**
 * 翻转字符串：
 */
public class No58 {
	/*
	 * 题目一：翻转单词顺序. 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。 为简单起见，标点符号和普通字母一样处理。
	 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
	 */
	public String ReverseSentence(char[] chars) {
		if (chars == null || chars.length <= 0)
			return String.valueOf(chars);
		// 翻转整个句子
		reverseSb(chars, 0, chars.length - 1);
		// 翻转单词（指针指向单词的第一个和最后一个）
		int start = 0;
		int end = 0;
		while (start < chars.length) {
			while (end < chars.length && chars[end] != ' ')
				end++;
			reverseSb(chars, start, end - 1);
			start = ++end;
		}
		/*
		 * 翻转单词的另一种写法（指针指向blank位置） int blank = -1; for(int i = 0;i < chars.length;i++){
		 * if(chars[i] == ' '){ int nextBlank = i; reverse(chars,blank + 1,nextBlank -
		 * 1); blank = nextBlank; } } reverse(chars,blank + 1,chars.length -
		 * 1);//最后一个单词单独进行反转
		 */
		return String.valueOf(chars);
	}

	private void reverseSb(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	/*
	 * 题目二：左旋转字符串。 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。 
	 * 请定义一个函数实现字符串左旋转操作的功能。
	 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
	 */
	public String leftRotateString(char[] chars, int n) {
		if (chars == null || chars.length <= 0)
			return String.valueOf(chars);
		if (n <= 0 || n > chars.length)
			return String.valueOf(chars);
		reverse(chars, 0, n - 1);
		reverse(chars, n, chars.length - 1);
		reverse(chars, 0, chars.length - 1);
		return String.valueOf(chars);
	}

	private void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {		
		String str = "I am a student.";
		String str1 = "abcdefg";
		No58 test = new No58();
		System.out.println(test.ReverseSentence(str.toCharArray()));
		System.out.println(test.leftRotateString(str1.toCharArray(), 2));
	}
}

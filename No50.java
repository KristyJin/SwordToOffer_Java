package JianzhiOffer;

/**
 * 第一个只出现一次的字符： 字符串中第一个只出现一次的字符。 在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”，则输出'b'。
 */
public class No50 {
	public static char firstNotRepeatingChar(String str) {
		if (str == null)
			return '\0';
		int[] repetitions = new int[256];
		for (int i = 0; i < 256; i++)
			repetitions[i] = 0;
		for (int i = 0; i < str.length(); i++) {
			int loc = (int) str.charAt(i);
			repetitions[loc] += 1;
		}
		for (int i = 0; i < str.length(); i++) {
			int loc = (int) str.charAt(i);
			if (repetitions[loc] == 1)
				return (char) loc;
		}
		return '\0';
	}

	public static void main(String[] args) {
		System.out.println((firstNotRepeatingChar("google") == 'l'));
		System.out.println((firstNotRepeatingChar("aabccdbd") == '\0'));
		System.out.println((firstNotRepeatingChar("$abcdefg") == '$'));
		System.out.println((firstNotRepeatingChar(null) == '\0'));
	}
	
	//题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
	//字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
	//符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。	 
	public class FirstCharacterInStream {
	    private int index;
	    private int[] occurence;
	     
	    public FirstCharacterInStream() {  //在构造函数中初始化成员变量
	        index=0;
	        occurence = new int[256];
	        for(int i=0;i<256;i++) {
	            occurence[i]=-1;
	        }
	    }
	     
	    public void insert(char ch) {
	        if(occurence[(int)ch]==-1) {
	            occurence[(int)ch]=index;   //第一次出现
	        }else if(occurence[(int)ch]>=0) {
	            occurence[(int)ch]=-2;   //已经出现过了
	        }
	        index++;
	    }
	     
	    public char getFirst() {
	        int minIndex=Integer.MAX_VALUE;  //最大的integer
	        char ch='#';
	        for(int i=0;i<256;i++) {
	            if(occurence[i]>=0 && occurence[i]<minIndex) {
	                ch = (char) i;
	                minIndex=occurence[i];
	            }
	        }
	        return ch;
	    }
	}

}

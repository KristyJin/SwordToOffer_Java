package JianzhiOffer;
import java.util.HashMap;
import java.util.Map;
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

	public static int FirstNotRepeatingChar1(String str) {
		Map<Character, Integer> map = new HashMap();
		char[] data = new char[10000];
		// 统计字符出现次数以及记录字符位置
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (map.get(cur) == null) {
				map.put(cur, 1);
			} else {
				map.put(cur, map.get(cur) + 1);
			}
			data[i] = cur;
		}
		// 寻找第一个只出现一次字符，并返回位置
		for (int i = 0; i < str.length(); i++) {
			if (map.get(data[i]) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println((firstNotRepeatingChar("google") == 'l'));
		System.out.println((firstNotRepeatingChar("aabccdbd") == '\0'));
		System.out.println((firstNotRepeatingChar("$abcdefg") == '$'));
        	System.out.println((firstNotRepeatingChar(null) == '\0'));
        
       		String str = "abckjkac";
		for (int i = 0; i < str.length(); i++) {
			// 截去第i个字符
			String temp = str.substring(0, i) + str.substring(i + 1);
			// 在剩余的字符串中搜索有没有与第i个字符相同的，没有的时候会返回-1
			int idx = temp.indexOf(str.charAt(i));
			// 剩下的字符串中没有的，就是唯一的
			if (idx == -1) {
				String c = String.valueOf(str.charAt(i));
				System.out.println(c);
				break;
			}
		}
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

package JianzhiOffer;

/**
 * 最长不含重复字符的子字符串：
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含‘a’-‘z’的字符。例如，在字符串“arabcacfr”中，
 * 最长的不含重复字符的子字符串是“acfr”，长度是4.
 */
public class No48 {
	private static int longestSubString(String str) {
		int curLen = 0;
		int maxLen = 0;
		int[] position = new int[26];
		for (int i = 0; i < position.length; i++) {
			position[i]= -1; 
		}
		
		for (int i = 0; i < str.length(); i++) {
			int prevIndex = position[str.charAt(i) - 'a'];
			if(prevIndex < 0 || i - prevIndex > curLen)
				++curLen;
			else {
				if(curLen > maxLen)
					maxLen = curLen;
				curLen = i - prevIndex;
			}
			position[str.charAt(i) - 'a'] = i;
		}
		if(curLen > maxLen)
			maxLen = curLen;
		return maxLen;
	}
	public static void main(String[] args) {
		System.out.println(longestSubString("arabcacfr"));
	}
}

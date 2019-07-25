package JianzhiOffer;
/*
 *FileName:  No19
 * Author:   Kristy
 * Date  :   2019/7/25 15:42
 * */

/**
 * 正则表达式匹配：
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。
 * 模式中'.'表示任意一个字符，'*'表示它前面的字符可以出现任意次（含0次）。
 * 匹配指字符串的所有字符匹配整个模式。
 * 例如：字符串"aaa"与模式"a.a"he "ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class No19 {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "aa.a";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        if (p.equals(".*")){
            return true;
        }
        if (s == null || p == null){
            return false;  // 如果字符串或者模式是空的，那么肯定没有匹配的
        }
        int strIndex = 0, patternIndex = 0;                 // 从字符串和模式的第一位开始进行匹配
        return matchChar(s, strIndex, p, patternIndex);
    }

    public static boolean matchChar(String str, int strIndex, String pattern, int patternIndex){

        if (strIndex == str.length() && patternIndex == pattern.length()){  // 字符串和模式同时都到末尾
            return true;
        }
        if (strIndex != str.length() && patternIndex == pattern.length()){  // 模式先到末尾
            return false;
        }
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*'){
            // 下一个字符是*
            if ((strIndex != str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex)) ||
                    (strIndex != str.length() && pattern.charAt(patternIndex) == '.') ){
                return matchChar(str, strIndex, pattern, patternIndex + 2) ||
                        matchChar(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchChar(str, strIndex + 1, pattern, patternIndex);
            }else {
                return matchChar(str, strIndex, pattern, patternIndex + 2);
            }
        }else if ((strIndex!=str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex)) ||
                (strIndex != str.length() && pattern.charAt(patternIndex) == '.')){
            // 下一个字符不是*，字符串当前字符和模式中的当前字符相匹配
            return matchChar(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

}

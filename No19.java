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

    }

    private static boolean match(char[] str, char[] pattern){
        if(str.length <= 0 || pattern.length <= 0)
            return false;
        return matchCore(str,pattern);
    }

    private static boolean matchCore(char[] str, char[] pattern){


        return false;
    }

}

package JianzhiOffer;
/*
 *FileName:  No31
 * Author:   Kristy
 * Date  :   2019/7/26 10:27
 * */

import java.util.Stack;

/**
 * 栈的压入、弹出序列：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列{1,2,3,4,5}是某栈的压栈序列，
 * 序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4,3,5,1,2}不可能是该压栈序列的弹出序列。
 */
public class No31 {
    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 2, 1};//{4, 3, 5, 1, 2}
        System.out.println(isRight(pushOrder, popOrder, 5));
        System.out.println(isPopOrder(pushOrder, popOrder));
    }

    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if (popA.length != pushA.length || pushA.length == 0)
            return false;
        int popIndex = 0;
        for (int pushIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    private static boolean isRight(int[] pushOrder, int[] popOrder, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (int i = 0; i < popOrder.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popOrder[i])
                stack.pop();
            else {
                if (count == pushOrder.length)
                    return false;
                else {
                    do {
                        stack.push(pushOrder[count++]);
                    }
                    while (stack.peek() != popOrder[i] && count != pushOrder.length);
                    if (stack.peek() == popOrder[i])
                        stack.pop();
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

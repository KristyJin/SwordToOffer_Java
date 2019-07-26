package JianzhiOffer;
/*
 *FileName:  No30
 * Author:   Kristy
 * Date  :   2019/7/26 10:23
 * */

import java.util.Stack;

/**
 * 包含min函数的栈：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在栈中，调用min、push以及pop的时间复杂度都是o(1)。
 */
public class No30 {
    public static void main(String[] args) {
        MyStack a = new MyStack();
        a.push(10);
        a.push(11);
        System.out.println(a.min());
    }
    static class MyStack {
        private Stack<Integer> stack1, stackHelp;

        public MyStack() {
            stack1 = new Stack<Integer>();
            stackHelp = new Stack<Integer>();
        }

        public void push(int num) {
            stack1.push(num);
            if (stackHelp.size() == 0 || num < stackHelp.peek()) {
                stackHelp.push(num);
            } else {
                stackHelp.push(stackHelp.peek());
            }
        }

        public void pop() {
            stack1.pop();
            stackHelp.pop();

        }

        public Integer min() {
            if (stackHelp.size() == 0) {
                return null;
            }
            return stackHelp.peek();
        }
    }

}

package JianzhiOffer;
/*
 *FileName:  No9
 * Author:   Kristy
 * Date  :   2019/7/22 9:43
 * */

import java.util.Stack;

/**
 * 用两个栈实现队列。
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class No9 {
    private Stack s1 = new Stack();
    private Stack s2 = new Stack();

    public void appendTail(Object x) {
        s1.push(x);
    }

    public void deleteHead(){
        if (s1.size() == 0 && s2.size() == 0) {
            try {
                throw new Exception("empty queue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (s2.size() != 0) {
                //System.out.println(s2.peek().toString());
                s2.pop();
            } else {
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                }
                //System.out.println(s2.peek().toString());
                s2.pop();
            }
        }
    }

    public static void main(String[] args) {
        No9 queue = new No9();
        queue.appendTail("a");
        queue.appendTail("b");
        queue.appendTail("c");
        System.out.println("----------");

        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
    }
}

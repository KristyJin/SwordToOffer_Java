package JianzhiOffer;
/*
 *FileName:  No6
 * Author:   Kristy
 * Date  :   2019/7/22 9:43
 * */

import java.util.Stack;

/**
 * 从尾到头打印链表：
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 */

public class No6 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        printListRevers(node1);
        //printListRevers1(node1);//递归实现
    }

    //每经过一个节点，把该节点放到一个栈中，当遍历完整个链表后，再从栈顶开始逐个输出节点的值
    // 采用栈
    public static void printListRevers(ListNode node) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (node!= null) {
            stack.push(node);
            node=node.next;
        }
        while(!stack.empty()) {
            System.out.println(stack.pop().data);
        }
    }

    //用递归实现，递归本质上就是一个栈结构，先递归输出后面的节点，再输出该节点本身。
    //存在问题：当链表非常长的时候，就会导致函数调用的层级很深，从而可能导致函数调用栈溢出。
    //采用递归
    public static void printListRevers1(ListNode node) {
        if(node!=null) {
            printListRevers1(node.next);
            System.out.println(node.data);
        }else
            return;
    }
}



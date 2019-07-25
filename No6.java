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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        printListRevers(node1);
        //printListRevers1(node1);//递归实现
    }

    //每经过一个节点，把该节点放到一个栈中，当遍历完整个链表后，再从栈顶开始逐个输出节点的值
    // 采用栈
    public static void printListRevers(Node node) {
        Stack<Node> stack = new Stack<Node>();
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
    public static void printListRevers1(Node node) {
        if(node!=null) {
            printListRevers1(node.next);
            System.out.println(node.data);
        }else
            return;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            super();
            this.data = data;
        }

        public Node(int data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}



package JianzhiOffer;
/*
 *FileName:  No18
 * Author:   Kristy
 * Date  :   2019/7/25 14:30
 * */

import java.util.HashSet;
import java.util.Set;

/**
 * 删除链表的节点：
 */
public class No18 {
    static class MyNode {
        MyNode next;
        int value;

        public MyNode(int value) {
            super();
            this.value = value;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }

        public int getData() {
            return value;
        }

        public void setData(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyNode a = new MyNode(1);
        MyNode b = new MyNode(2);
        MyNode c = new MyNode(3);
        MyNode d = new MyNode(4);
        MyNode e = new MyNode(4);
        MyNode f = new MyNode(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        MyNode temp = a;

        delete(a, f);
        DelNode2(temp);
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
    }

    /**
     * 题目一：在o(1)时间内删除链表节点。
     * 给定单向链表的头指针和一个节点指针，定义一个函数在时间内删除该节点
     */
    private static void delete(MyNode head, MyNode c) {
        // 如果是尾节点,只能遍历删除
        if (c.next == null) {
            while (head.next != c) {
                head = head.next;
            }
            head.next = null;
        } else if (head == c) {
            head = null;
        } else {
            c.setData(c.getNext().getData());
            c.setNext(c.getNext().getNext());
        }
    }

    /**
     * 题目二：删除链表中重复的节点。
     * 在一个排序的链表中，如何删除重复的节点？
     */
    private static void DelNode1(MyNode head) {
        if (head == null) {
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.value);
        MyNode pre = head;
        MyNode cur = head.next;
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = pre.next;
            }
            cur = cur.next;
        }
    }

    private static void DelNode2(MyNode head) {
        if (head == null) {
            return;
        }
        MyNode cur = head;
        while (cur != null) {
            MyNode pre = cur;
            MyNode next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                }else {
                    pre = pre.next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}

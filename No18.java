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

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(4);
        Node f = new Node(5);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        Node temp = a;

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
    private static void delete(Node head, Node c) {
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
    private static void DelNode1(Node head) {
        if (head == null) {
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.data);
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (set.contains(cur.data)) {
                pre.next = cur.next;
            } else {
                set.add(cur.data);
                pre = pre.next;
            }
            cur = cur.next;
        }
    }

    private static void DelNode2(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            Node pre = cur;
            Node next = cur.next;
            while (next != null) {
                if (cur.data == next.data) {
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

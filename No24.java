package JianzhiOffer;
/*
 *FileName:  No24
 * Author:   Kristy
 * Date  :   2019/7/25 17:53
 * */

/**
 * 反转链表：
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class No24 {
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
        Node newNode = reverse(node1);
        //Node newNode = reverse2(node1);//递归实现
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.getNext();
        }
    }
    private static Node reverse(Node head) {
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }

    private static Node reverse2(Node head) {
        if (head.next == null) {
            return head;
        }
        Node reverseHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverseHead;
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

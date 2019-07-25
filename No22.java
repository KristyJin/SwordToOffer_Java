package JianzhiOffer;
/*
 *FileName:  No22
 * Author:   Kristy
 * Date  :   2019/7/25 17:30
 * */

/**
 * 链表中倒数第k个节点：
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
 */
public class No22 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        //本题
        System.out.println(findKthToTail(a, 5));

        /**
         * 求链表的中间结点。如果链表中结点总数为奇数，
         * 返回中间结点；如果结点总数为偶数，返回中间两个结点的任意一个
         */
        ListNode mid = getMid(a);
        System.out.println(mid.getData());
    }

    private static int findKthToTail(ListNode head, int k) {
        if (head == null || k == 0)
            return -1;

        ListNode temp = head;
        ListNode res = null;
        for (int i = 0; i < k - 1; i++) {
            if (temp.getNext() != null)
                temp = temp.getNext();
            else return -1;
        }
        res = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            res = res.getNext();
        }
        return res.getData();
    }

    static class ListNode {
        private int data;
        private ListNode Next;

        public ListNode(int data) {
            super();
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return Next;
        }

        public void setNext(ListNode next) {
            this.Next = next;
        }
    }

    private static ListNode getMid(ListNode a) {
        if (a == null) {
            return null;
        }
        ListNode slow = a;
        ListNode fast = a;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

}

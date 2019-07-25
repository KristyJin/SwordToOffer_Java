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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ListNode newNode = reverse(node1);
        //Node newNode = reverse2(node1);//递归实现
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.getNext();
        }
    }
    private static ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.getNext();
        ListNode temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }

    private static ListNode reverse2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode reverseHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverseHead;
    }

}

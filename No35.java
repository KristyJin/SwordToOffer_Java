package JianzhiOffer;
/*
 *FileName:  No35
 * Author:   Kristy
 * Date  :   2019/7/26 11:14
 * */

/**
 * 复杂链表的复制：
 * 请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，
 * 复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个m_pNext指针指向下一个结点外，
 * 还有一个m_pSibling指向链表中的任意结点或者NULL
 */
public class No35 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        ListNode result = clone(node1);
        while (result != null) {
            System.out.print(result.data+" ");
            result = result.next;
        }
    }

    private static ListNode clone(ListNode head) {
        cloneNodes(head);
        copySibingNodes(head);
        return separateNodes(head);
    }

    private static void cloneNodes(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode cloneNode = new ListNode(node.data);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private static void copySibingNodes(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode cloneNode = node.next;
            if (node.sibling != null) {
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }
    }

    private static ListNode separateNodes(ListNode head) {
        ListNode node = head;
        ListNode cloneHead = null;
        ListNode cloneNode = null;
        if (node != null) {
            cloneNode = node.next;
            cloneHead = cloneNode;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

}

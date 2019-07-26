package JianzhiOffer;/*
 *FileName:  ListNode
 * Author:   Kristy
 * Date  :   2019/7/25 19:49
 * */

/**
 * 链表需要的定义如下：
 * 使用的有No6、No18、No22、No24、No25、No35
 */
public class ListNode {
    int data;
    ListNode next;
    ListNode sibling;

    public ListNode(int data) {
        super();
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
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
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}

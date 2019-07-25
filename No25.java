package JianzhiOffer;
/*
 *FileName:  No25
 * Author:   Kristy
 * Date  :   2019/7/25 18:15
 * */

/**
 * 合并两个排序的链表：
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 例如，输入链表1：1->3->5->7和链表2：2->4->6->8，
 * 则合并之后的升序链表为链表3：1->2->3->4->5->6->7->8
 */
public class No25 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(8);
        e.setNext(f);
        f.setNext(g);
        g.setNext(h);
        ListNode merge = Merge(a,e);
        while (merge != null) {
            System.out.print(merge.getData() + " ");
            merge = merge.next;
        }
    }

    private static ListNode Merge(ListNode node1, ListNode node2){
        if(node1 == null)
            return node2;
        else if(node2 == null)
            return node1;

        ListNode mergeNode = null;
        if(node1.getData() < node2.getData()){
            mergeNode = node1;
            mergeNode.setNext(Merge(node1.getNext(), node2));
        }else{
            mergeNode = node2;
            mergeNode.setNext(Merge(node1, node2.getNext()));
        }

        return mergeNode;
    }
}

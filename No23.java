package JianzhiOffer;
/*
 *FileName:  No23
 * Author:   Kristy
 * Date  :   2019/7/25 17:43
 * */

/**
 * 链表中环的入口节点：
 * 如果一个链表中包含环，如何找出环的入口节点？
 */
/*
 * 思路:1.确定链表是否有环：通过两个不同速度的指针确定
 *      2.确定环中结点的数目n：指针走一圈，边走边计数
 *      3.找到环的入口：从头结点开始，通过两个相差为n的指针来得到（即寻找链表中倒数第n个结点）
 */
public class No23 {
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
        g.setNext(c);
        ListNode res = entryNodeOfLoop(a);
        if(res != null)
            System.out.println(res.getData());
        else
            System.out.println("null");
    }
    /*
     * 确定链表是否有环，采用快慢指针确定
     * 返回值代表快慢指针相遇时的结点，返回null代表链表无环
     */
    private static ListNode meetingNode(ListNode head) {
        if(head==null)
            return null;
        ListNode pSlow=head;
        ListNode pFast=head;
        while(pFast!=null) {
            pSlow=pSlow.next;
            pFast=pFast.next;
            if(pFast!=null)
                pFast=pFast.next;
            if(pSlow!=null && pSlow==pFast)
                return pSlow;
        }
        return null;
    }


    /**
     * 计算环中入口结点
     */
    public static ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode=meetingNode(head);
        if(meetingNode==null)
            return null;

        //计算环中结点的数目
        int count=1;  //环中结点的数目
        ListNode pNode1 = meetingNode.next;
        while(pNode1!=meetingNode){
            count++;
            pNode1=pNode1.next;
        }

        //先移动pNode1，次数为count
        pNode1=head;
        for(int i=1;i<=count;i++) {
            pNode1=pNode1.next;
        }
        ListNode pNode2=head;
        while(pNode1!=pNode2) {
            pNode1=pNode1.next;
            pNode2=pNode2.next;
        }
        return pNode1;
    }
}

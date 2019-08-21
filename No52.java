package JianzhiOffer;

/**
 * 两个链表的第一个公共节点：
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class No52 {
	/*
	 * 蛮力法：遍历第一个链表的结点，每到一个结点，就在第二个链表上遍历每个结点，判断是否相等。时间复杂度为O(m*n)，效率低；
	 * 使用栈：由于公共结点出现在尾部，所以用两个栈分别放入两个链表中的结点，从尾结点开始出栈比较。时间复杂度O(m+n)，空间复杂度O(m+n)。
	 * 利用长度关系：计算两个链表的长度之差，长链表先走相差的步数，之后长短链表同时遍历，找到的第一个相同的结点就是第一个公共结点。
	 * 利用两个指针：一个指针顺序遍历list1和list2，另一个指针顺序遍历list2和list1，（这样两指针能够保证最终同时走到尾结点），
	 * 两个指针找到的第一个相同结点就是第一个公共结点。
	 */
	 //方法1：利用长度关系
    public static ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        int lengthDif = length1-length2;
        ListNode longList = pHead1;
        ListNode shortList = pHead2;
        if(lengthDif<0){
            longList = pHead2;
            shortList = pHead1;
            lengthDif = -lengthDif;
        }
        for(int i=0;i<lengthDif;i++)
            longList = longList.next;
        while(longList!=null && longList!=shortList ){
            longList=longList.next;
            shortList=shortList.next;
        }
        return longList;  //没有公共结点刚好是null
    }
     
    private static int getLength(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
 
    //方法2：两个指针，p1顺序遍历list1和list2；p2顺序遍历list2和list1；最终一定会相遇
    public static ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while(p1!=p2){
            if(p1!=null) p1=p1.next;
            if(p2!=null) p2=p2.next;
            if(p1!=p2){
                //到达最后时，指针指向另一个链表
                if(p1==null) p1=pHead2;
                if(p2==null) p2=pHead1;
            }
        }
        return p1;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(6);
        ListNode head4 = new ListNode(7);
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        node.next = node1;
        node1.next = head3;
        head3.next = head4;
        ListNode result1 = findFirstCommonNode1(head,node);
        ListNode result = findFirstCommonNode2(head,node);
        while (result != null) {
            System.out.print(result.data+" ");
            result = result.next;
        }
	}
}

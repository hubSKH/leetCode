package audition;

import assit.ListNode;

/**
 * 面试题22. 链表中倒数第k个节点
 * @Description
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * @auther SHENKAIHUAN
 * @create 2020-04-11 13:53
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode (1);
//        listNode.next=new ListNode (2);
//        listNode.next.next=new ListNode (3);
//        listNode.next.next.next=new ListNode (4);
//        listNode.next.next.next.next=new ListNode (5);
        int k=1;
        long start =System.currentTimeMillis ();
        System.out.println (getKthFromEnd(listNode,k).val);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p =head;
        ListNode q =head;
        int count=1;
        while (count<k && q.next!=null){
            q=q.next;
            count++;
        }
        while (q.next!=null){
            q=q.next;
            p=p.next;
        }
        return p;
    }
}

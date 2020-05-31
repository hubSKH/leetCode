package audition;

import assit.ListNode;

/**
 * 面试题52. 两个链表的第一个公共节点
 * @Description
 * 输入两个链表，找出它们的第一个公共节点。
 * @auther SHENKAIHUAN
 * @create 2020-05-31 10:47
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

        ListNode c1=new ListNode (3);
        ListNode c2=new ListNode (4);
        ListNode c3=new ListNode (5);
        c1.next=c2;c2.next=c3;

        ListNode a1=new ListNode (1);
        ListNode a2=new ListNode (2);
        a1.next=a2;a2.next=c1;

        ListNode b1=new ListNode (1);
        ListNode b2=new ListNode (2);
        ListNode b3=new ListNode (3);
        b1.next=b2;b2.next=b3;b3.next=c1;

        ListNode intersectionNode = getIntersectionNode (a1, b1);

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        int count =0;
        while (node1!=null) {
            node1=node1.next;
            count++;
        }
        while (node2 !=null){
            node2=node2.next;
            count--;
        }
        if (node1 != node2) return null;
        node1 = count > 0 ? headA : headB;
        node2 = node1 == headA ? headB : headA;
        count = Math.abs (count);
        while (count > 0) {
            node1 = node1.next;
            count--;
        }
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

}

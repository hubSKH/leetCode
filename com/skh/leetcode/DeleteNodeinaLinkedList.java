package leetcode;

import assit.ListNode;

/**
 * @Description
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-20 14:37
 */
public class DeleteNodeinaLinkedList {

    public static void main(String[] args) {
        ListNode node1 =new ListNode(4);
        ListNode node2 =new ListNode(5);
        ListNode node3 =new ListNode(1);
        ListNode node4 =new ListNode(9);
//        ListNode node5 =new ListNode(4);
//        ListNode node6 =new ListNode(5);
//        ListNode node7 =new ListNode(6);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;

        ListNode p =node1;
        while (p != null){
            System.out.print(p.val+", ");
            p=p.next;
        }
        System.out.println ();

        long start =System.currentTimeMillis ();
        deleteNode (node1);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        p =node1;
        while (p != null){
            System.out.print (p.val+", ");
            p=p.next;
        }
        System.out.println ();
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

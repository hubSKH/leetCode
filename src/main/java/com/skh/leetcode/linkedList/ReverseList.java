package leetcode.linkedList;

import assit.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/7/9 15:10
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new ReverseList().reverseList(head);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = q;
            q = tmp;
        }
        return q;
    }

}

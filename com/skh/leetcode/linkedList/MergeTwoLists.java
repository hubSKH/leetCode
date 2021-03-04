package leetcode.linkedList;

import assit.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * @auther SHENKAIHUAN
 * @create 2021-03-04 21:56
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode (1);
        l1.next = new ListNode (2);
        l1.next.next = new ListNode (4);
        ListNode l2 = new ListNode (1);
        l2.next = new ListNode (3);
        l2.next.next = new ListNode (4);
        ListNode listNode = mergeTwoLists (l1, l2);
        System.out.println (listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode (0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }
}

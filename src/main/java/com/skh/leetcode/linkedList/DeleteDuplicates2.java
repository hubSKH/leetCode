package leetcode.linkedList;

import assit.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/6/3 11:09
 */
public class DeleteDuplicates2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        ListNode listNode = new DeleteDuplicates2().deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        ListNode p = preHead.next;
        ListNode q = preHead.next.next;
        while (q != null) {
            if (p.val == q.val) {

                while (q != null && p.val == q.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
                q = q == null ? null : q.next;
            } else {
                pre = pre.next;
                q = q.next;
                p = p.next;
            }
        }
        return preHead.next;
    }
}

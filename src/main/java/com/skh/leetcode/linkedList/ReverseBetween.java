package leetcode.linkedList;

import assit.LinkListBuilder;
import assit.ListNode;

/**
 * 92. 反转链表 II
 *
 * @Description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @auther SHENKAIHUAN
 * @create 2023/7/29 15:15
 */
public class ReverseBetween {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode head = LinkListBuilder.builderLinkList(array);
        int left = 2, right = 4;
        ListNode listNode = new ReverseBetween().reverseBetween(head, left, right);
        System.out.println(listNode);

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1, head);
        ListNode p = pre;
        int idx = 1;
        while (idx < left) {
            p = p.next;
            idx++;
        }
        ListNode next;
        ListNode q = p.next;
        while (idx < right) {
            next = q.next;
            q.next = next.next;
            next.next = p.next;
            p.next = next;
            idx++;
        }
        return pre.next;
    }
}

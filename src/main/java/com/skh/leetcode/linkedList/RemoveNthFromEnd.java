package leetcode.linkedList;

import assit.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @auther SHENKAIHUAN
 * @create 2021-03-14 20:21
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode (1);
        head.next = new ListNode (2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (4);
        head.next.next.next.next = new ListNode (5);
        int n = 2;
        System.out.println (head);
        System.out.println (removeNthFromEnd (head, n));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode secondList = new ListNode (0, head);
        ListNode slow = secondList, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return secondList.next;
    }
}

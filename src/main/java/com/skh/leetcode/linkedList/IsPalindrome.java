package leetcode.linkedList;

import assit.ListNode;

/**
 * 234. 回文链表
 *
 * @Description 请判断一个链表是否为回文链表。
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @auther SHENKAIHUAN
 * @create 2021-05-02 23:28
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode (1);
        head.next = new ListNode (2);
        head.next.next = new ListNode (2);
        head.next.next.next = new ListNode (1);
        System.out.println (isPalindrome (head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secHead = reverseSecList (slow);
        slow.next = null;
        while (secHead != null) {
            if (head.val != secHead.val) return false;
            head = head.next;
            secHead = secHead.next;
        }
        return true;
    }

    private static ListNode reverseSecList(ListNode node) {
        ListNode p = node, temp, q = null;
        while (p != null) {
            temp = p;
            p = p.next;
            temp.next = q;
            q = temp;

        }
        return q;
    }
}

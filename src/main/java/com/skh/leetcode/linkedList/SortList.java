package leetcode.linkedList;

import assit.ListNode;

/**
 * 148. 排序链表
 *
 * @Description 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * @auther SHENKAIHUAN
 * @create 2021-03-24 21:23
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode (4);
        head.next = new ListNode (2);
        head.next.next = new ListNode (1);
        head.next.next.next = new ListNode (3);
        head.next.next.next.next = new ListNode (-1);
        System.out.println (sortList2 (head));
    }
    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
    public static ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        int length = getLength (node);
        ListNode first = new ListNode (0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = first, curr = first.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge (head1, head2);
                prev.next = merged;
                while (prev.next != null) prev = prev.next;
                curr = next;
            }
        }
        return first.next;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode (0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return dummyHead.next;
    }

    private static int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

}

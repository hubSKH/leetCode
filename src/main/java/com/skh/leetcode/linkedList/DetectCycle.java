package leetcode.linkedList;

import assit.ListNode;

/**
 * 142. 环形链表 II
 *
 * @Description 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @auther SHENKAIHUAN
 * @create 2021-03-12 23:54
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode (3);
        head.next = new ListNode (2);
        head.next.next = new ListNode (0);
        head.next.next.next = new ListNode (4);
        head.next.next.next.next = head.next;
        ListNode listNode = detectCycle (head);
        System.out.println (listNode.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}

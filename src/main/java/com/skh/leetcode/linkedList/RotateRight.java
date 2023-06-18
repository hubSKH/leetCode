package leetcode.linkedList;

import assit.ListNode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/6/18 15:36
 */
public class RotateRight {
    public static void main(String[] args) {
        int k = 7;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new RotateRight().rotateRight(head, k);
        System.out.println(listNode);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int count = 0;
        ListNode slow = head;
        ListNode fast = head;
        //快指针先走k步
        while (count < k) {
            fast = fast.next;

            if (count++ < k && fast == null) {
                //到达链表尾部，还没走完
                k = k % count;
                fast = head;
                for (int i = 0; i < k; i++) {
                    fast = fast.next;
                }
            }
        }
        if (slow != fast) {
            //slow前进到需要右移的位置
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = head;
            ListNode tmp = slow.next;
            slow.next = null;
            slow = tmp;

        }
        return slow;
    }
}

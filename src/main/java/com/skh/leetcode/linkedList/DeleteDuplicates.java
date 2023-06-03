package leetcode.linkedList;

import assit.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * @Description 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * @auther SHENKAIHUAN
 * @create 2023/6/3 10:46
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode listNode = new DeleteDuplicates().deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        while (q != null) {
            if (p.val == q.val) {
                q = q.next;
                p.next = q;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        return head;
    }
}

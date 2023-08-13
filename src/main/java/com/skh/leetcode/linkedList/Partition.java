package leetcode.linkedList;

import assit.LinkListBuilder;
import assit.ListNode;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/8/13 14:46
 */
public class Partition {
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 3, 0, 2, 5, 2};
        int x = 3;
        ListNode head = LinkListBuilder.builderLinkList(array);
        ListNode node = new Partition().partition(head, x);
        System.out.println(node);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode p = new ListNode(-1);
        ListNode pPre = p;
        ListNode q = new ListNode(-1);
        ListNode qPre = q;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = qPre.next;
        return pPre.next;
    }
}

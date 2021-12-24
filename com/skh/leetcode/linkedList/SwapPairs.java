package leetcode.linkedList;

import assit.ListNode;

/**
 * 24. 两两交换链表中的节点
 * @Description
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * @auther SHENKAIHUAN
 * @create 2021-12-24 9:43
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head =new ListNode (1);
        head.next=new ListNode (2);
        head.next.next=new ListNode (3);
        head.next.next.next=new ListNode (4);
        System.out.println (new SwapPairs ().swapPairs (head));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode (-1);
        h.next=head;
        ListNode tmp= h;
        while (tmp.next!=null && tmp.next.next!=null){
            ListNode p=tmp.next;
            ListNode q=tmp.next.next;
            p.next=q.next;
            q.next=p;
            tmp.next=q;
            tmp=p;
        }
        return h.next;
    }
}

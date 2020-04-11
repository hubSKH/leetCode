package audition;

import assit.ListNode;

/**
 * 面试题24. 反转链表
 * @Description
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @auther SHENKAIHUAN
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @create 2020-04-11 22:42
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode (1);
        listNode.next=new ListNode (2);
        listNode.next.next=new ListNode (3);
        listNode.next.next.next=new ListNode (4);
        listNode.next.next.next.next=new ListNode (5);
        long start =System.currentTimeMillis ();
        System.out.println (reverseList(listNode).val);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static ListNode reverseList(ListNode head) {

        ListNode p =head;
        ListNode q =null;
        ListNode temp;
        while (p!=null){
            temp= p;
            p=p.next;
            temp.next=q;
            q=temp;
        }
        return q;

    }
}

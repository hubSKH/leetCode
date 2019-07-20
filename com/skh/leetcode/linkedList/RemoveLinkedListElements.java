package leetcode.linkedList;

import assit.ListNode;

/**
 * @Description
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @auther SHENKAIHUAN
 * @create 2019-07-20 11:53
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        int val =1;

        ListNode node1 =new ListNode(1);
        ListNode node2 =new ListNode(1);
        ListNode node3 =new ListNode(6);
        ListNode node4 =new ListNode(3);
        ListNode node5 =new ListNode(4);
        ListNode node6 =new ListNode(5);
        ListNode node7 =new ListNode(6);

        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;

        ListNode p =node1;
        while (p != null){
            System.out.print(p.val+", ");
            p=p.next;
        }
        System.out.println ();

        long start =System.currentTimeMillis ();
        p= removeElements (node1,val);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        while (p != null){
            System.out.print (p.val+", ");
            p=p.next;
        }
        System.out.println ();
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        ListNode q = null;//记录前
        while (p != null){
            if(p.val ==val){
                if(q == null){
                    //处理头结点
                    head = p.next;
                }else {
                    q.next = p.next;
                }
            }else {
                q = p;
            }
            p = p.next;
        }
        return head;
    }
}

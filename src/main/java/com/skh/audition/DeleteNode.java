package audition;

import assit.ListNode;

/**
 * 面试题18. 删除链表的节点
 * @Description
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @auther SHENKAIHUAN
 * @create 2020-04-05 1:14
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node=new ListNode (4);
        node.next=new ListNode (5);
        node.next.next=new ListNode (1);
        node.next.next.next=new ListNode (9);
        int val=5;
        long start =System.currentTimeMillis ();
        System.out.println (deleteNode(node,val));
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode p= head;
        ListNode pre = null;
        while (p!=null){
            if(p.val==val){
                if(pre==null){
                    head=head.next;
                }else {
                    pre.next=p.next;
                }
                break;
            }
            pre=p;
            p=p.next;
        }
        return head;

    }
}

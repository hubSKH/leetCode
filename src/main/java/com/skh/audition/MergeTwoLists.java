package audition;

import assit.ListNode;

/**
 * 面试题25. 合并两个排序的链表
 * @Description
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @auther SHENKAIHUAN
 * @create 2020-04-19 21:13
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode =new ListNode (1);
        listNode.next=new ListNode (2);
        listNode.next.next=new ListNode (4);

        ListNode listNode2 = new ListNode (1);
        listNode2.next=new ListNode (3);
        listNode2.next.next=new ListNode (4);
        long start = System.currentTimeMillis ();
        System.out.println (mergeTwoLists (listNode,listNode2).val);
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));



    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result =new ListNode (0);
        ListNode cur=result;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return result.next;

    }
}

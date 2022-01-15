package comp.NO167;

import assit.ListNode;

/**
 * 二进制链表转整数
 * @Description
 * @auther SHENKAIHUAN
 * @create 2019-12-15 10:29
 */
public class LinkToNum {
    public static void main(String[] args) {
        ListNode listNode=new ListNode (1);
        ListNode listNode1=new ListNode (0);
        ListNode listNode2=new ListNode (1);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        System.out.println (getDecimalValue(listNode));

    }

    public static int getDecimalValue(ListNode head) {
        int count =0;
        ListNode p =head;
        while (p!=null){
           count++;
            p=p.next;
        }
        int sum =0;
        for(count--;count>=0;count--){
            sum+=Math.pow (2,count)*head.val;
            head=head.next;
        }
        return sum;

    }
}

package leetcode;

import assit.ListNode;

/**
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode loFirst =new ListNode(5);
//        loFirst.next=new ListNode(4);
//        loFirst.next.next=new ListNode(3);

        ListNode lsFirst =new ListNode(5);
//        lsFirst.next=new ListNode(6);
//        lsFirst.next.next=new ListNode(4);

        ListNode result = addTwoNumbers(loFirst,lsFirst);
        ListNode p= result;
        do{
            System.out.println(p.val);
            p=p.next;
        }while (p!=null);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode total =new ListNode(0);
        ListNode p =total;
        int i=0;
        while (null!= l1|| null!=l2){
            int v1 = l1==null?0:l1.val;
            int v2 = l2 == null?0:l2.val;
            int sum=v1+v2+i;
            p.next=new ListNode(sum%10);
            p=p.next;
            i=sum/10;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(i!=0){
            p.next=new ListNode(i);
        }
        return total.next;
    }
}

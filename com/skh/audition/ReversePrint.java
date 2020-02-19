package audition;

import assit.ListNode;

/**
 * 面试题06. 从尾到头打印链表
 * @Description
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @auther SHENKAIHUAN
 * @create 2020-02-17 0:03
 */
public class ReversePrint {
    public static void main(String[] args) {
        ListNode head= new ListNode (1);
        ListNode node2= new ListNode (2);
        ListNode node3= new ListNode (3);
        head.next=node3;
        node3.next=node2;
        long start =System.currentTimeMillis ();
        int[] ints = reversePrint (head);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
        for (int num :ints){
            System.out.print (num+",");
        }
        System.out.println ();

    }
    public static int[] reversePrint(ListNode head) {
        ListNode p =head;
        int count =0;
        while (p!=null){
            p=p.next;
            count++;
        }
        int[] result = new int[count];
        while (count>0){
            result[--count]=head.val;
            head=head.next;
        }
        return result;
    }
}

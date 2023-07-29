package assit;

/**
 * 数组生成链表
 *
 * @Description
 * @auther SHENKAIHUAN
 * @create 2023/7/29 15:17
 */
public class LinkListBuilder {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = builderLinkList(array);
        System.out.println(listNode);
    }

    public static ListNode builderLinkList(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return head.next;
    }
}

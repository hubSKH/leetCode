package audition;

import assit.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35. 复杂链表的复制
 * @Description
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * @auther SHENKAIHUAN
 * @create 2020-05-01 20:25
 */
public class CopyRandomList {
    public static void main(String[] args) {
        Node head = new Node (7);
        Node node13 = new Node (13);
        Node node11 = new Node (11);
        Node node10 = new Node (10);
        Node node1 = new Node (1);
        head.next=node13;
        node13.next=node11;
        node11.next=node10;
        node10.next=node1;
        node13.random=head;
        node11.random=node1;
        node10.random=node11;
        node1.random=head;
        long start = System.currentTimeMillis ();
        Node node = cuttingRope (head);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static Node cuttingRope(Node head) {
        Map<Node,Node> map =new HashMap<> ();
        Node copyHead=new Node (-1),q=copyHead ;
        Node p=head;
        while (p!=null){
            q.next =new Node (p.val);
            map.put (p,q.next);
            p=p.next;
            q=q.next;
        }
        q=head;
        while (q!=null){
           map.get (q).random=map.get (q.random);
           q=q.next;
        }
        return copyHead.next;

    }
}
